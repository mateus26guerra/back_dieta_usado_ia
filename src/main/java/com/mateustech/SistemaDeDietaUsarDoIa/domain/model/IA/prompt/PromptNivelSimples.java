package com.mateustech.SistemaDeDietaUsarDoIa.domain.model.IA.prompt;

public class PromptNivelSimples {
    public static String gerar(String formularioJson) {
        return """
Você é um nutricionista profissional.

Use APENAS os dados abaixo (JSON real do sistema):

%s

⚠️ IMPORTANTE:
- Responda SOMENTE em JSON
- NÃO escreva nenhum texto fora do JSON
- NÃO mude os nomes das chaves
- NÃO crie campos novos

O JSON DEVE seguir EXATAMENTE este formato:

{
  "plano": {
    "nivel": "BASICO",
    "descricao": "Plano simples e acessível para quem está começando"
  },
  "conteudo": {
    "plano_de_dieta_simples": "texto aqui",
    "cardapio_de_um_dia": "texto aqui",
    "orientacoes_gerais": "texto aqui"
  },
  "nao_inclui": {
    "treino_detalhado": false,
    "personalizacao_profunda": false
  }
}

NÃO use o nome "plano_alimentar".
Use SOMENTE os campos acima.
""".formatted(formularioJson);
    }
}