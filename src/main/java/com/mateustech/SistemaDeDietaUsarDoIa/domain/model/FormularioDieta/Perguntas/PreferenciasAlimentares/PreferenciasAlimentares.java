package com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.PreferenciasAlimentares;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.PreferenciasAlimentares.PAenum.Nivel_na_cozinha;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.PreferenciasAlimentares.PAenum.Restricoes_alimentares;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.PreferenciasAlimentares.PAenum.Tipo_de_dieta;

public class PreferenciasAlimentares {

    private Tipo_de_dieta tipo_de_dieta;
    private Restricoes_alimentares restricoes_alimentares;
    private String alimentosNaoGosto;
    private String alimentosFavoritos;
    private Nivel_na_cozinha nivelNaCozinha;

    public PreferenciasAlimentares() {
    }

    public PreferenciasAlimentares(Tipo_de_dieta tipo_de_dieta, Restricoes_alimentares restricoes_alimentares, String alimentosNaoGosto, String alimentosFavoritos, Nivel_na_cozinha nivelNaCozinha) {
        this.tipo_de_dieta = tipo_de_dieta;
        this.restricoes_alimentares = restricoes_alimentares;
        this.alimentosNaoGosto = alimentosNaoGosto;
        this.alimentosFavoritos = alimentosFavoritos;
        this.nivelNaCozinha = nivelNaCozinha;
    }

    public Tipo_de_dieta getTipo_de_dieta() {
        return tipo_de_dieta;
    }

    public void setTipo_de_dieta(Tipo_de_dieta tipo_de_dieta) {
        this.tipo_de_dieta = tipo_de_dieta;
    }

    public Restricoes_alimentares getRestricoes_alimentares() {
        return restricoes_alimentares;
    }

    public void setRestricoes_alimentares(Restricoes_alimentares restricoes_alimentares) {
        this.restricoes_alimentares = restricoes_alimentares;
    }

    public String getAlimentosNaoGosto() {
        return alimentosNaoGosto;
    }

    public void setAlimentosNaoGosto(String alimentosNaoGosto) {
        this.alimentosNaoGosto = alimentosNaoGosto;
    }

    public String getAlimentosFavoritos() {
        return alimentosFavoritos;
    }

    public void setAlimentosFavoritos(String alimentosFavoritos) {
        this.alimentosFavoritos = alimentosFavoritos;
    }

    public Nivel_na_cozinha getNivelNaCozinha() {
        return nivelNaCozinha;
    }

    public void setNivelNaCozinha(Nivel_na_cozinha nivelNaCozinha) {
        this.nivelNaCozinha = nivelNaCozinha;
    }
}
