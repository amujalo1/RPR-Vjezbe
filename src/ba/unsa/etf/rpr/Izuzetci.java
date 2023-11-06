package ba.unsa.etf.rpr;


public class Izuzetci {
    public static class InvalidPhoneNumberException extends RuntimeException {
        public InvalidPhoneNumberException(String message) {
            super(message);
        }
    }

    public static class PersonNotFoundException extends RuntimeException {
        public PersonNotFoundException(String message) {
            super(message);
        }
    }

    public static class InvalidCommandException extends RuntimeException {
        public InvalidCommandException(String message) {
            super(message);
        }
    }
}
