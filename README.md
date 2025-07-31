# 🧠 Compiler Construction – Classroom Language (CL)

This repository contains a two-part compiler project for a custom programming language called **Classroom Language (CL)**. 



## 📚 Overview

The project is divided into two main milestones:

---

### 🔹 Milestone 1 – Front-End Compiler  
**Focus**: *Lexical and Syntax Analysis using JavaCC*

- Implements the **lexer** and **parser** for CL using `JavaCC`.
- Recognizes tokens like `int`, `string`, identifiers, operators, and custom keywords.
- Validates CL programs with grammar rules including:
  - `startProgram` / `endProgram`
  - Variable declarations (`int`, `string`)
  - Assignment statements
  - Control structures: `loopif`, `switchFor` (optional), `if`, `else`
  - Output: `outString`
- Constructs a **symbol table** for declared variables.

---

### 🔹 Milestone 2 – Back-End Compiler  
**Focus**: *Semantic Analysis & Intermediate Code Generation*

- Adds **semantic validation**:
  - Type checking (`int`, `float`, `char`, `string`)
  - Reports type mismatches with line numbers
- Builds a complete **symbol table** using Java classes.
- Generates **3-address intermediate code** in the form of **quadruples**.
- Displays:
  - Symbol table
  - Intermediate instructions
  - Operator table for code analysis

---

## 📁 Repository Structure

```plaintext
📦 CL-Compiler-Construction 
├── 📂 Milestone-1-FrontEnd/            # Lexical and Syntax Analysis
│   ├── 🧾 Parser.jjt                   # JavaCC grammar (lexer + parser)
│   ├── 📄 SymbolTable.java              # Symbol table class
│   ├── 📄 Loop.txt                      # Sample CL code (basic)
│   ├── 📄 SwitchCase.txt                # Sample CL code (basic)
│   └── 📘 README.md                    # Readme  File

├── 📂 Milestone-2-BackEnd/             # Semantic Analysis + Code Generation
│   ├── 📄 Parser.jjt                   # JavaCC grammar reused from M1
│   ├── 📄 SemanticAnalysis.java        # Semantic analysis with type checking
│   ├── 📄 CodeGenerator.java           # Generates 3-address intermediate code
│   ├── 📄 ST.java                      # Symbol table (manager)
│   ├── 📄 STC.java                     # Symbol table cell (entry)
│   ├── 📄 SemanticException.java       # Exception class for semantic errors
│   ├── 📄 Loop.txt                     # Test file (extended CL source code)
│   ├── 📄 Compilation Steps.docx       # Manual compile/run instructions
│   └── 📘 README.md                    # Readme File
```
## 🛠️ Setup & Compilation Instructions
✅ Prerequisites
- Java JDK 8+

- JavaCC 5.0+


## 📌 Language Features (CL)

| Feature           | Description                                                                 |
|-------------------|-----------------------------------------------------------------------------|
| 🧮 Data Types       | `int`, `string` (Milestone 1) → extended with `float`, `char` in Milestone 2 |
| 🧾 Statements       | Variable declaration, assignment, `if-else`, `loopif`, `switchFor`, `outString` |
| ➕ Operators        | Arithmetic: `+`, `-`, `*`, `/`<br>Comparison: `>`, `<`, `>=`, `<=`, `==`, `!=` |
| 📤 Output Format    | Symbol table with type & scope, semantic error messages (if any), intermediate 3-address code (quadruples) |

## ✍️ Author
Hamza Afzal
 
---
