package migsoft.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class EstoqueException extends Exception {

    private String texto;

    public EstoqueException(String texto) {
        this.texto = texto;
    }
}
