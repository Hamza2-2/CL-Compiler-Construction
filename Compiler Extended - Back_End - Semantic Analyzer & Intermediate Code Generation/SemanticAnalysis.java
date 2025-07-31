

public class SemanticAnalysis {
    private ST symbolTable;

    // Constructor
    public SemanticAnalysis(ST symbolTable) {
        this.symbolTable = symbolTable;
    }

    // Declare a variable in the current scope
    public void declareVariable(String variableName, String variableType, Object value) {
        symbolTable.insert(variableName, variableType, value);
    }

    // Check if a variable is declared in any accessible scope
    public void checkVariableDeclaration(String variableName) throws SemanticException {
        if (symbolTable.lookup(variableName) == null) {
            throw new SemanticException("Variable " + variableName + " not declared.");
        }
    }

    // Get the type of a given variable
    public String getVariableType(String variableName) throws SemanticException {
        STC variable = symbolTable.lookup(variableName);
        if (variable == null) {
            throw new SemanticException("Variable " + variableName + " not declared.");
        }
        return variable.getType();
    }

    // Update the value of a variable in the current or accessible scope
    public void updateVariableValue(String variableName, Object newValue) throws SemanticException {
        if (symbolTable.lookup(variableName) == null) {
            throw new SemanticException("Variable " + variableName + " not declared.");
        }
        symbolTable.updateValue(variableName, newValue);
    }

    // Enter a new scope (e.g., when entering a function or a block)
    public void enterScope() {
        symbolTable.enterScope();
    }

    // Exit the current scope (e.g., when exiting a function or a block)
    public void exitScope() {
        try {
            symbolTable.exitScope();
        } catch (IllegalStateException e) {
            System.out.println("Error: Cannot exit the global scope");
        }
    }

    // Print the symbol table for debugging purposes
    public void showSymbolTable() {
        symbolTable.show();
    }
}
