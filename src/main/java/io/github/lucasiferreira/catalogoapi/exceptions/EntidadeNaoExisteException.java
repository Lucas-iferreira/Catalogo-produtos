package io.github.lucasiferreira.catalogoapi.exceptions;

public class EntidadeNaoExisteException extends RuntimeException {
    public EntidadeNaoExisteException(String message) {
        super(message);
    }
}
