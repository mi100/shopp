package dmytro.shop.exception;

public class WrongInputDataException extends RuntimeException {
    public WrongInputDataException() {
    }

    public WrongInputDataException(String message) {
        super(message);
    }
}
