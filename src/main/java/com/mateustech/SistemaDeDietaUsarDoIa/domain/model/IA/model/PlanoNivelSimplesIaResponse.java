package com.mateustech.SistemaDeDietaUsarDoIa.domain.model.IA.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanoNivelSimplesIaResponse {

    public Plano plano;
    public Conteudo conteudo;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Plano {
        public String descricao;   // vem da IA
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Conteudo {
        public String plano_de_dieta_simples;
        public String cardapio_de_um_dia;
        public String orientacoes_gerais;
    }
}
