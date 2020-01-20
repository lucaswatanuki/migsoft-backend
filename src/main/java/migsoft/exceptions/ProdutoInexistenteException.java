package migsoft.exceptions;

public class ProdutoInexistenteException extends RuntimeException{

    private Integer code = 1;

    public ProdutoInexistenteException(String message) {
        super(message);
    }

    public Integer getCode() {
        return code;
    }
}
