package com.lazaro.comprecoisas.exceptions;

public class NullCategoriaPaiException extends RuntimeException {
    public NullCategoriaPaiException(String message) {
        super(message);
    }

    public NullCategoriaPaiException() {
        super("A categoria informada não possui uma sub-categoria.");
    }
}
