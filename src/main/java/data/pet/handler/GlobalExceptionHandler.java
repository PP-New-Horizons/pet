package data.pet.handler;

import data.pet.data.PetAdoptedData;
import data.pet.data.PetBookedData;
import data.pet.data.PetNotFoundData;
import data.pet.exception.NotFoundPetException;
import data.pet.exception.PetAdoptedException;
import data.pet.exception.PetBookedException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundPetException.class)
    public ResponseEntity<PetNotFoundData> handlePetNotFoundException(NotFoundPetException ex) {
        PetNotFoundData data = PetNotFoundData.builder()
                .info(ex.getMessage()).build();
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PetBookedException.class)
    public ResponseEntity<PetBookedData> handlePetBookedException(PetBookedException ex) {
        PetBookedData data = PetBookedData.builder()
                .info(ex.getMessage()).build();
        return new ResponseEntity<>(data, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PetAdoptedException.class)
    public ResponseEntity<PetAdoptedData> handlePetAdoptedException(PetAdoptedException ex) {
        PetAdoptedData data = PetAdoptedData.builder()
                .info(ex.getMessage()).build();
        return new ResponseEntity<>(data, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(violation -> {
            String fieldName = violation.getPropertyPath().toString();
            String[] pathParts = fieldName.split("\\.");
            fieldName = pathParts[pathParts.length - 1];
            Object invalidValue = violation.getInvalidValue();
            String errorMessage = String.format("Параметр '%s' некорректен: %s", invalidValue, violation.getMessage());
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
