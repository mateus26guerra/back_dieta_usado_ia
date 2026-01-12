package com.mateustech.SistemaDeDietaUsarDoIa.domain.contracts;

public interface PdfGateway {
    byte[] gerar(String html);
}
