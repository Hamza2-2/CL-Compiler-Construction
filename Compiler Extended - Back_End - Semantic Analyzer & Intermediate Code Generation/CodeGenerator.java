
import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {

    private SimpleNode root; 
    private StringBuilder code; 
    private int tempVarCount;
    private List<String[]> codeList; // List to store three-address code
    // Constructor
    public CodeGenerator(SimpleNode root) {
        this.root = root;
        this.code = new StringBuilder();
        this.tempVarCount = 1;
        this.codeList = new ArrayList<>();
    }

    // Start the code generation process
    public String generate() {
        traverseAndProcess(root); 
        return code.toString();
    }

    // Recursive traversal and processing method
    private String traverseAndProcess(SimpleNode node) {
        if (node == null) return "";

        switch (node.toString()) {
            case "S":
            	return processRoot(node);
			case "Variables":
				return processVariables(node);
			case "intDecl":
				return processIntDecl(node);
			case "strDecl":
				return processStrDecl(node);
			case "Code":
				return processCode(node);
			case "Statement":
				return traverseAndProcess((SimpleNode) node.jjtGetChild(0));
			case "Output":
				return processOutput(node);
            case "Expression":
                return traverseAndProcess((SimpleNode) node.jjtGetChild(0)); 

            case "AdditiveExpression":
                return processAdditiveExpression(node);

            case "MultiplicativeExpression":
                return processMultiplicativeExpression(node);

            case "UnaryExpression":
                return processUnaryExpression(node);

            case "Identifier":
                return processIdentifier(node);

            case "Integer":
                return processInteger(node);
            // lets also add an assighment node
			case "Assignment":
				return processAssignment(node);
			case "LoopIf":
				return processLoopIf(node);
			case "Condition":
				return processCondition(node);
		    case "SwitchStatement":
		            return processSwitchStatement(node);
		    case "CaseStatement":
		            return processCaseStatement(node);
            default:
                return "";
        }
    }
    
    
    
    private String processRoot(SimpleNode node) {
    	  traverseAndProcess((SimpleNode) node.jjtGetChild(0)); // Process Variables()
    	    traverseAndProcess((SimpleNode) node.jjtGetChild(1)); // Process Code()
    	    return "";
	}
    
    
	private String processVariables(SimpleNode node) {
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			traverseAndProcess((SimpleNode) node.jjtGetChild(i)); // Process each variable
		}
		return "";
	}
	
	private String processIntDecl(SimpleNode node) {
		String varName = getNodeValue((SimpleNode) node);
		if (node.jjtGetNumChildren() == 1) {
			String value = getNodeValue((SimpleNode) node.jjtGetChild(0));
			code.append("int ").append(varName).append(" = ").append(value).append(";\n"); // Declare and initialize the
			codeList.add(new String[] { "int", varName, "", value });
																							// variable
		} else {
			code.append("int ").append(varName).append(";\n"); // Declare the variable
			codeList.add(new String[] { "int", varName , "", "" });
		}
		
		return varName; // Return the variable name if needed
	}
	
	private String processStrDecl(SimpleNode node) {
		String varName = getNodeValue((SimpleNode) node);
		if (node.jjtGetNumChildren() ==1 ) {
			String value = getNodeValue((SimpleNode) node.jjtGetChild(0));
			code.append("String ").append(varName).append(" = ").append(value).append(";\n"); // Declare and initialize
			codeList.add(new String[] { "String", varName, "", value });
																								// the variable
		} else {
			code.append("String ").append(varName).append(";\n"); // Declare the variable
			codeList.add(new String[] { "String", varName, "", "" });
		}
		
		return varName; // Return the variable name if needed
	}
	
	private String processCode(SimpleNode node) {
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			traverseAndProcess((SimpleNode) node.jjtGetChild(i)); // Process each statement
		}
		return "";
	}
	
	private String processOutput(SimpleNode node) {
		String output = getNodeValue((SimpleNode) node.jjtGetChild(0));
		code.append("outString(").append(output).append(");\n");
		codeList.add(new String[] { "outString", "", "", output });
		return output; // Return the output value if needed
	}
	
    
    
   
    private String processSwitchStatement(SimpleNode node) {
        String switchVar = getNodeValue((SimpleNode) node.jjtGetChild(0)); // Get the switch variable
        code.append("switch (").append(switchVar).append(") {\n");

        for (int i = 1; i < node.jjtGetNumChildren(); i++) {
            traverseAndProcess((SimpleNode) node.jjtGetChild(i)); // Process each case
        }

        code.append("}\n");
        return switchVar; // Return the switch variable if needed
    }

    private String processCaseStatement(SimpleNode node) {
        String caseValue =getNodeValue((SimpleNode) node.jjtGetChild(0)); // Get the case value
        code.append("case ").append(caseValue).append(":\n");

        for (int i = 1; i < node.jjtGetNumChildren(); i++) {
            traverseAndProcess((SimpleNode) node.jjtGetChild(i)); // Process assignments in the case
        }
        code.append("break;\n"); // Add break to exit the switch
        return caseValue; // Return the case value if needed
    }
    
	

    private String processCondition(SimpleNode node) {
        String left = getNodeValue((SimpleNode) node.jjtGetChild(0));
        String operator = getNodeValue((SimpleNode) node.jjtGetChild(1));
        String right = getNodeValue((SimpleNode) node.jjtGetChild(2));

        // Generate temporary variable and append the condition code
        String temp = getTempVar();
        code.append(temp).append(" = ").append(left).append(" ").append(operator).append(" ").append(right).append(";\n");
        codeList.add(new String[]{operator, left, right, temp});
        
        return temp;
    }

    private String processLoopIf(SimpleNode node) {
        String condition = traverseAndProcess((SimpleNode) node.jjtGetChild(0));
        code.append("loop_start:\n");

        // Process any assignments inside the loop
        for (int i = 1; i < node.jjtGetNumChildren(); i++) {
            traverseAndProcess((SimpleNode) node.jjtGetChild(i));
        }

        String endLabel = "loop_end";
        code.append("if not ").append(condition).append(" goto ").append(endLabel).append(";\n");

        code.append("goto loop_start;\n");
        code.append(endLabel).append(":\n");
        return condition;  // Return the condition for use if needed elsewhere
    }



    
	private String processAssignment(SimpleNode node) {
		String left = getNodeValue((SimpleNode) node);
		String right = traverseAndProcess((SimpleNode) node.jjtGetChild(0));
		code.append(left).append(" = ").append(right).append(";\n");
		codeList.add(new String[] { "=", right, "", left });
		return left;
	}
    
    
    // Process AdditiveExpression
    private String processAdditiveExpression(SimpleNode node) {
    
        String left = traverseAndProcess((SimpleNode) node.jjtGetChild(0)); 
        for (int i = 1; i < node.jjtGetNumChildren(); i ++) {
            String operator = getNodeValue((SimpleNode)node);
            String right = traverseAndProcess((SimpleNode) node.jjtGetChild(i));
            String temp = getTempVar();
            code.append(temp).append(" = ").append(left).append(" ").append(operator).append(" ").append(right).append(";\n");
            codeList.add(new String[]{operator, left, right, temp});
            left = temp; 
        }
        
        return left;
    }

    // Process MultiplicativeExpression
    private String processMultiplicativeExpression(SimpleNode node) {
        String left = traverseAndProcess((SimpleNode) node.jjtGetChild(0)); 
        for (int i = 1; i < node.jjtGetNumChildren(); i++) {
        	String operator = getNodeValue((SimpleNode) node);
            String right = traverseAndProcess((SimpleNode) node.jjtGetChild(i)); 
            String temp = getTempVar();
            code.append(temp).append(" = ").append(left).append(" ").append(operator).append(" ").append(right).append(";\n");
            codeList.add(new String[]{operator, left, right, temp});
            left = temp; // Use the result as the left operand for subsequent operations
        }
        return left;
    }

    // Process UnaryExpression
    private String processUnaryExpression(SimpleNode node) 
    {
        if (node.jjtGetNumChildren() == 1) 
        {
        return traverseAndProcess((SimpleNode) node.jjtGetChild(0));
        }
        String operator = node.value.toString(); 
        String operand = traverseAndProcess((SimpleNode) node.jjtGetChild(0)); 
        String temp = getTempVar();
        code.append(temp).append(" = ").append(operator).append(operand).append(";\n");
        codeList.add(new String[]{operator, operand, "", temp});
        return temp;
    }

   
    private String processIdentifier(SimpleNode node) {
        return node.value.toString(); 
    }

  
    private String processInteger(SimpleNode node) {
        return node.value.toString(); 
    }

   
    private String getTempVar() {
        return "r" + (tempVarCount++);
    }
    
 // Utility method to safely get the node's value
    private String getNodeValue(SimpleNode node) {
        if (node == null || node.value == null) {
            return ""; // Handle missing value gracefully
        }
        return node.value.toString();
    }
    
    
    void printTable() {
    	// Print the heading
    	System.out.printf("%-10s%-10s%-10s%-10s%n", "Operator", "Arg1", "Arg2", "Result");
    	System.out.println("------------------------------------------------------");

    	// Print the three-address code
    	for (String[] code : codeList) {
    	    System.out.printf("%-10s%-10s%-10s%-10s%n", 
    	                      code[0], 
    	                      code[1], 
    	                      code[2], 
    	                      code[3]);
    	}

    }
}
