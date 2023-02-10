package de.f4bii.commandlib;

public class SuccessfulCommand extends RuntimeException {
    public SuccessfulCommand(String message) {
        super(message);
    }
}
