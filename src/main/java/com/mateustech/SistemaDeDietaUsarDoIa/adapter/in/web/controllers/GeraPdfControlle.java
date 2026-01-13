
package com.mateustech.SistemaDeDietaUsarDoIa.adapter.in.web.controllers;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.usecase.GeraPdfSimples.GeraPdfUserCase;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.FormularioDietaCompleto;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.FormularioDietaMedio;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.FormularioDietaSimple;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GeraPdfControlle {

    private final GeraPdfUserCase geraPdfUserCase;

    public GeraPdfControlle(GeraPdfUserCase geraPdfUserCase) {
        this.geraPdfUserCase = geraPdfUserCase;
    }

    @PostMapping("/gerar-pdf-simples")
    public ResponseEntity<byte[]> gerarPdfSimples
            (@RequestBody FormularioDietaSimple formulario) {

        byte[] pdfBytes = geraPdfUserCase.gerarPdfSimples(formulario);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=plano-dieta-simples.pdf")
                .header("Content-Type", "application/pdf")
                .body(pdfBytes);
    }

    @PostMapping("/gerar-pdf-medio")
    public ResponseEntity<byte[]> gerarPdfMedio(
            @RequestBody FormularioDietaMedio formulario) {

        byte[] pdfBytes = geraPdfUserCase.gerarPdfMedio(formulario);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=plano-dieta-intermediario.pdf")
                .header("Content-Type", "application/pdf")
                .body(pdfBytes);
    }


    @PostMapping("/gerar-pdf-completo")
    public ResponseEntity<byte[]> gerarPdf(
            @RequestBody FormularioDietaCompleto formulario
    ) {
        byte[] pdf = geraPdfUserCase.gerarPdfCompleto(formulario);

        return ResponseEntity.ok()
                .header("Content-Type", "application/pdf")
                .header("Content-Disposition", "inline; filename=plano-completo.pdf")
                .body(pdf);
    }

}
