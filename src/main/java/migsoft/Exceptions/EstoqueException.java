package migsoft.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class EstoqueException extends RuntimeException {

    public EstoqueException(String message) {
        super(message);
    }

}
