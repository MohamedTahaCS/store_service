package com.store.fawry.exception;

public class DuplicateStockException extends RuntimeException {

    public DuplicateStockException(String message) {
        super(message);
    }
}