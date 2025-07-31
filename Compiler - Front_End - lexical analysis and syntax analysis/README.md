#  **CL Language Lexer & Parser**  

## 📌 Overview  
This project implements the **front-end** of a compiler for the Classroom Language (CL), including:  
- **Lexical Analyzer**: Token recognition (identifiers, integers, strings, keywords).  
- **Syntax Analyzer**: Top-down parser for CL grammar using JavaCC.

## 📁 Project Structure

```plaintext
📦Compiler - Front_End - lexical analysis and syntax analysis
 ┣ 📜 Parser.jjt        # JavaCC grammar (lexer + parser)
 ┣ 📜 SymbolTable.java  # Java symbol table implementation
 ┗ 📜 Loop.txt          # Sample CL input file
 ┗ 📜 SwitchFor.txt          # Sample CL input file
 
```
  
## 🛠️ Setup & Usage  
1. **Requirements**:  
   - Java JDK 11+  
   - JavaCC (install via `brew install javacc` or [download](https://javacc.org/)).  

2. **Steps**:
   
   - Generate lexer/parser from JavaCC:
       - jjtree Parser.jjt
         
            <img width="975" height="484" alt="image" src="https://github.com/user-attachments/assets/ae33aa57-d168-4d1c-b0fb-ab001f303ab7" />

       - javacc Parser.jj
         
         <img width="946" height="289" alt="image" src="https://github.com/user-attachments/assets/291449a4-0d96-4def-834e-34549d6f9943" />

    - Compile Java files:
       - javac *.jav
         
         <img width="975" height="231" alt="image" src="https://github.com/user-attachments/assets/9d17f906-f812-4c49-8319-255f0df632ae" />
   
    -  Run the compiler on a test file:
       - java Parser Loop.txt
         
         <img width="923" height="720" alt="image" src="https://github.com/user-attachments/assets/78c99d1d-dd5e-4a0c-be86-632b76a2cc13" />


4. **Output**:  
   - Prints tokens and syntax tree. 
   - Reports syntax errors (e.g., missing semicolons).
  
 
## 🧾 CL Language Specifications

- **Data Types**: `int`, `string`
- **Operators**: `+`, `-`, `*`, `/` (with Java-like precedence)
- **Statements**:
  - Variable declaration and assignment
  - Loops: `loopif`
  - Conditionals: `if`, `else`
  - Output: `outString`


## 📜 CL Language Syntax
```
startProgram  
variables:  
    int x = 10;  
code:  
    outString(x);  
endProgram
```
