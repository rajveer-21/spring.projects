package org.example.exceptionsandhandlers;

public class InsufficientStockException extends RuntimeException
{
    public InsufficientStockException(String message)
    {
        super(message);
    }
}
