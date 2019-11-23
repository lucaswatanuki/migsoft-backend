package migsoft.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class EstoqueException extends RuntimeException {

    private Integer code = 3;

    public EstoqueException(String message) {
        super(message);
    }

    public Integer getCode() {
        return code;
    }
}
