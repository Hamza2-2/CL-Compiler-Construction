

//Symbol Table Container (STC)
public class STC {
 private String type;   // e.g., "Int", "Bool"
 private String name;   // e.g., variable name
 private Object value;  // value of the variable (Object allows any type)

 // Constructor to initialize type, name, and value
 
 
 
 
 public STC(String type, String name, Object value) {
     this.type = type;
     this.name = name;
     this.value = value;
 }

 // Getters
 public String getType() {
     return type;
 }

 public String getName() {
     return name;
 }

 public Object getValue() {
     return value;
 }

 // Setters (if you need to update values)
 public void setValue(Object value) {
     this.value = value;
 }

 @Override
 public String toString() {
     return "STC{" +
             "type='" + type + '\'' +
             ", name='" + name + '\'' +
             ", value=" + value +
             '}';
 }
}
