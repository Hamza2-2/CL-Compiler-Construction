

import java.util.HashMap;
import java.util.Stack;

// Symbol Table with Scope Management using STC
public class ST {
    private Stack<HashMap<String, STC>> scopes; // Stack for scope management

    // Constructor
    public ST() {
        scopes = new Stack<>();
        // Start with a global scope
        scopes.push(new HashMap<>());
    }

    // Insert a new symbol into the current scope
    public void insert(String name, String type, Object value) {
        STC symbol = new STC(type, name, value);
        scopes.peek().put(name, symbol);
    }

    // Lookup for a symbol in the current and outer scopes
    public STC lookup(String name) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            STC symbol = scopes.get(i).get(name);
            if (symbol != null) {
                return symbol; // Return the symbol if found
            }
        }
        return null; // Not found in any scope
    }

    // Enter a new scope
    public void enterScope() {
        scopes.push(new HashMap<>());
    }

    // Exit the current scope
    public void exitScope() {
        if (scopes.size() > 1) { // Don't pop the global scope
            scopes.pop();
        } else {
            throw new IllegalStateException("Cannot exit the global scope");
        }
    }

    // Update the value of an existing symbol in the current or outer scopes
    public void updateValue(String name, Object newValue) {
        STC symbol = lookup(name);
        if (symbol != null) {
            symbol.setValue(newValue); // Update the value
        } else {
            throw new IllegalArgumentException("Symbol not found: " + name);
        }
    }

    // Print the Symbol Table
    public void show() {
        System.out.println("Symbol Table:");
        for (int i = 0; i < scopes.size(); i++) {
            System.out.println("Scope " + i + ":");
            for (String key : scopes.get(i).keySet()) {
                System.out.println("  " + scopes.get(i).get(key));
            }
        }
    }
}
