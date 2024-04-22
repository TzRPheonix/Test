package org.example.Exception;

public class NotEnoughMoneyException extends RuntimeException  {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
