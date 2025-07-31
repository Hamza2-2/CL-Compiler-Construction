# Compiler Construction -(Back-End) - **Semantic Analyzer & Intermediate Code Generator**  
 

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
```
## 🛠️ Setup & Usage  
1. **Requirements**:  
   - Java JDK 11+  
   - Compiler Extended - Back_End - Semantic Analyzer & Intermediate Code Generation File  

2. **Steps**:  

  - Generate the Parser
     ```bash
      javacc Parser.jjt

  - Compile All Java Files
     ```bash
     javac *.java
  - Run the Compiler
     Use your test file (e.g., Loop.txt) to run semantic analysis and generate intermediate code:
     ```bash
       java Parser Loop.txt
 
3. **Output**:

    - Semantic Phase:
       - Semantic Error
      
         ```bash
         Error (Line 5): Type mismatch - Cannot add 'string' and 'int'.
      
    - Code Generation Phase:
      
       Displays 3-address intermediate code as quadruples
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



##  📸 Output Result - Processing Input CL File
---
<img width="807" height="862" alt="image" src="https://github.com/user-attachments/assets/b8b0647c-dc71-4047-905e-30ff82427c1e" />
