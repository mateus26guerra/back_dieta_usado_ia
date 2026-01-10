package com.mateustech.SistemaDeDietaUsarDoIa.domain.UserCase.GeraPdfSimples;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.FormularioDietaSimple;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.Usuario.Usuario;
import org.springframework.stereotype.Service;

@Service
public class GeraPdfSimplesUserCase {

    public FormularioDietaSimple gerarPdfSimples(FormularioDietaSimple FormularioDietaSimple) {

        // Aqui depois você vai:
        // 1. chamar a IA
        // 2. gerar o PDF
        // 3. devolver o resultado

        // Por enquanto só devolve o usuário
        return FormularioDietaSimple;
    }
}
