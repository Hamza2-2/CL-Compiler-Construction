# Compiler Construction -(Back-End)  
**Semantic Analyzer & Intermediate Code Generator**  

## 📌 Overview  
Extends the Milestone 1 front-end with:  
- **Semantic Analyzer**: Type-checking (`int`, `float`, `string`, `char`).  
- **Intermediate Code Generator**: Quadruples (3-address code).  

## 📁 Project Structure

```plaintext
📦Compiler Extended - Back_End - Semantic Analyzer & Intermediate Code Generation
 ┣ 📜 Parser.jjt              # JavaCC grammar (lexer + parser)
 ┣ 📜 ST.java                 # Symbol Table manager class
 ┣ 📜 STC.java                # Symbol Table cell (entry) class
 ┣ 📜 SemanticAnalysis.java   # Semantic analysis with type checking
 ┣ 📜 SemanticException.java  # Custom exception class for semantic errors
 ┣ 📜 CodeGenerator.java      # Generates intermediate 3-address code (quadruples)
 ┣ 📜 Loop.txt                # Input CL program for testing
 ┣ 📜 README.md               # Project documentation
 
```
## 🛠️ Setup & Usage  
1. **Requirements**:  
   - Java JDK 11+  
   - Completed Milestone 1 (`CL.jjt`).  

2. **Steps**:  
   ```bash
   # Compile all Java files:
   javac *.java

   # Run semantic analysis + code generation:
   java SemanticAnalyzer test.cl
   java IntermediateCodeGen test.cl
 
3. **Output**:

    - Semantic Errors:
      ```bash
      Error (Line 5): Type mismatch - Cannot add 'string' and 'int'.
      
    - Quadruples:
      ```bash
      1: t1 = b * c
      2: t2 = t1 + d
      3: a = t2

## 🚀 Features

### ✅ Semantic Analyzer
- **Data Types Supported**: `int`, `float`, `string`, `char`
- **Type Checking**:
  - Detects illegal operations like `string + int`
  - Reports line numbers for semantic errors
- **Symbol Table**:
  - Tracks variable name, type, and scope

### ⚙️ Intermediate Code Generator
- Translates expressions into **three-address code**
- Handles arithmetic expressions:
  - Example: `a = b * -c + b * -c`
    - → Transformed into temp variables (`t1`, `t2`, ...)
- Displays intermediate code as an **instruction array (quadruples)**

### 🧠 Statement Support
- All constructs from Milestone 1 (validated with semantic rules)
  - `loopif`, `switchFor`
  - `if/else`, assignments, `outString`, etc.

---
