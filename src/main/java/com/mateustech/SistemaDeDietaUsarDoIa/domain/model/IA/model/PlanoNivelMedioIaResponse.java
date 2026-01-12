package com.mateustech.SistemaDeDietaUsarDoIa.domain.model.IA.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanoNivelMedioIaResponse {

    public Plano plano;
    public Conteudo conteudo;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Plano {
        public String descricao;
        public String objetivo;
        public String nivel;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Conteudo {

        public String plano_de_dieta;

        public Map<String, DiaCardapio> cardapio_5_dias;

        public AtividadeFisica atividade_fisica;

        public String orientacoes_gerais;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DiaCardapio {
        public String cafe;
        public String almoco;
        public String lanche;
        public String jantar;
        public String ceia;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AtividadeFisica {
        public String musculacao;
        public String cardio;
        public String core;
    }

}
