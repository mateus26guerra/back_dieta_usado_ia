package com.mateustech.SistemaDeDietaUsarDoIa.adapter.out.ia;

import com.mateustech.SistemaDeDietaUsarDoIa.adapter.out.pdf.PdfGenerator;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.contracts.PdfGateway;
import org.springframework.stereotype.Service;

@Service
public class PdfGatewayImpl implements PdfGateway {

    @Override
    public byte[] gerar(String html) {
        return PdfGenerator.gerarPdf(html);
    }
}