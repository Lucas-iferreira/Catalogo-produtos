package io.github.lucasiferreira.catalogoapi.exceptions.records;

import java.time.Instant;

public record ErroResposta(
        int status,
        String mensagem,
        Instant timestamp
) {
}
