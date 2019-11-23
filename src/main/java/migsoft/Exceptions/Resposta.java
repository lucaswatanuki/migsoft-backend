package migsoft.Exceptions;

public class Resposta {
    private int code;
    private String error;
    private Object body;

    public Resposta(int code, String error, Object body) {
        super();
        this.code = code;
        this.error = error;
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

}
