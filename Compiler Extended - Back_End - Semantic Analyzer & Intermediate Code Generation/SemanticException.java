
import java.io.Serializable;

public class SemanticException extends RuntimeException implements Serializable{
    // Declaring a serialVersionUID
    private static final long serialVersionUID = 1L;
        public SemanticException(String message) {
            super(message);
        }
    
}
