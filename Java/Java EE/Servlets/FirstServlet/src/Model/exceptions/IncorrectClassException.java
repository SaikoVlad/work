package Model.exceptions;

public class IncorrectClassException extends Exception {


    public IncorrectClassException(String s) {
    }

    public IncorrectClassException() {
        System.err.println("Incorrect parameter class");
    }
}
