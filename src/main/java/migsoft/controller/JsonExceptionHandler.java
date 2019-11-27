package migsoft.controller;

import migsoft.Exceptions.EstoqueException;
import migsoft.Exceptions.Resposta;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class JsonExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllOtherErrors(EstoqueException exception) {
        Resposta resposta = new Resposta(exception.getLocalizedMessage());
        return new ResponseEntity<Object>(resposta, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
