package migsoft.Exceptions;

public class Resposta {
    private String error;


    public Resposta(String error) {
        super();
        this.error = error;
    }



    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


}
