package com.mateustech.SistemaDeDietaUsarDoIa.domain.model.IA.prompt;

public class PromptNivelCompleto {

    public static String gerar(String formularioJson) {
        return """
        Você é um nutricionista clínico e treinador físico.

        Dados completos do paciente:

        %s

        Gere:
        - Plano alimentar completo
        - Divisão de macronutrientes
        - Estratégia semanal
        - Atividade física recomendada
        - Observações personalizadas

        Linguagem profissional e detalhada.
        """.formatted(formularioJson);
    }
}
