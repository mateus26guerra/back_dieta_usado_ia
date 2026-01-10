
package com.mateustech.SistemaDeDietaUsarDoIa.adapter.in.web.controllers;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.UserCase.GeraPdfSimples.GeraPdfSimplesUserCase;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.FormularioDietaSimple;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.Usuario.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GeraPdfControlle {

    private final GeraPdfSimplesUserCase geraPdfSimplesUserCase;

    public GeraPdfControlle(GeraPdfSimplesUserCase geraPdfSimplesUserCase) {
        this.geraPdfSimplesUserCase = geraPdfSimplesUserCase;
    }

    @PostMapping("/gerar-pdf-simples")
    public ResponseEntity<FormularioDietaSimple> gerarPdf(@RequestBody FormularioDietaSimple formularioDietaSimple) {

        FormularioDietaSimple usuarioProcessado = geraPdfSimplesUserCase.gerarPdfSimples(formularioDietaSimple);

        return ResponseEntity.ok(usuarioProcessado);
    }
}
