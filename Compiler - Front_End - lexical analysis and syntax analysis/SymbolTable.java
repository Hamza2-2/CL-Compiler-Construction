

import java.util.HashMap;

public class SymbolTable {
    // HashMap to store variable names (identifiers) and their values
    private HashMap<String, String> symbolTable;

    // Constructor to initialize the symbol table
    public SymbolTable() {
        symbolTable = new HashMap<>();
    }

    // Method to add or update a variable in the symbol table
    public void put(String identifier, String value) {
        symbolTable.put(identifier, value);
    }

    // Method to get the value of a variable
    public Object get(String identifier) {
        if (symbolTable.containsKey(identifier)) {
            return symbolTable.get(identifier);
        } else {
            throw new RuntimeException("Variable '" + identifier + "' not found.");
        }
    }

    // Method to check if a variable exists in the symbol table
    public boolean contains(String identifier) {
        return symbolTable.containsKey(identifier);
    }

    // Method to remove a variable from the symbol table
    public void remove(String identifier) {
        symbolTable.remove(identifier);
    }

    // Method to print the current state of the symbol table
    public void printTable() {
        System.out.println("Current Symbol Table:");
        for (String key : symbolTable.keySet()) {
            System.out.println(key + " = " + symbolTable.get(key));
        }
    }
}
