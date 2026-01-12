package com.mateustech.SistemaDeDietaUsarDoIa.adapter.out.ia;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.contracts.IaGateway;
import org.springframework.stereotype.Service;

@Service
public class GeminiIaGateway implements IaGateway {

    private final GeminiService geminiService;

    public GeminiIaGateway(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @Override
    public String gerarPlanoJson(String prompt) {
        return geminiService.gerarResposta(prompt);
    }
}