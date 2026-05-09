package io.github.lucasiferreira.catalogoapi.exceptions;

public class EntidadeExistenteException extends RuntimeException {
    public EntidadeExistenteException(String message) {
        super(message);
    }
}
