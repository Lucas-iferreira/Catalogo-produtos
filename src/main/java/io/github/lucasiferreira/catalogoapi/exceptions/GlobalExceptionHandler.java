package io.github.lucasiferreira.catalogoapi.exceptions;

import io.github.lucasiferreira.catalogoapi.exceptions.records.ErroResposta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntidadeNaoExisteException.class)
    public ResponseEntity<ErroResposta> handle404(EntidadeNaoExisteException ex) {
        ErroResposta erro = new ErroResposta(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                Instant.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(EntidadeExistenteException.class)
    public ResponseEntity<ErroResposta> handle409(EntidadeExistenteException ex) {
        ErroResposta erro = new ErroResposta(
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                Instant.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }
}
