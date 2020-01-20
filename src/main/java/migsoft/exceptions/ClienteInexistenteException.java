package migsoft.exceptions;

public class ClienteInexistenteException extends RuntimeException {

    private Integer code = 2;
    public ClienteInexistenteException(String message) {
        super(message);
    }

    public Integer getCode() {
        return code;
    }
}
