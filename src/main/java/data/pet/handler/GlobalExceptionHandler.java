package data.pet.handler;

import data.pet.data.PetNotFoundData;
import data.pet.exception.NotFoundPetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundPetException.class)
    public ResponseEntity<PetNotFoundData> handlePetNotFoundException(NotFoundPetException ex) {
        PetNotFoundData data = PetNotFoundData.builder()
                .info(ex.getMessage()).build();
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
