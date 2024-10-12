package data.pet.exception;

public class NotFoundPetException extends RuntimeException {
    public NotFoundPetException(String message) {
        super(message);
    }
}
