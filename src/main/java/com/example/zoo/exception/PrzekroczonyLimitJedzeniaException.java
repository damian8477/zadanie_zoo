package com.example.zoo.exception;

public class PrzekroczonyLimitJedzeniaException extends Exception{
    public PrzekroczonyLimitJedzeniaException(String errorMessage) {
        super(errorMessage);
    }

}
