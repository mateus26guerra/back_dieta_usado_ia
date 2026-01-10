package com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.habitosDeVida;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.enumGenerico.NivelTres;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.enumGenerico.Qualidade;

public class habitosDeVida {

    private  int Horas_de_sono;
    private Qualidade qualidade;
    private double consumode_agua_diario;
    private NivelTres nivelDeEstresse;

    public habitosDeVida() {
    }


    public habitosDeVida(int horas_de_sono, Qualidade qualidade, double consumode_agua_diario, NivelTres nivelDeEstresse) {
        Horas_de_sono = horas_de_sono;
        this.qualidade = qualidade;
        this.consumode_agua_diario = consumode_agua_diario;
        this.nivelDeEstresse = nivelDeEstresse;
    }

    public NivelTres getNivelDeEstresse() {
        return nivelDeEstresse;
    }

    public void setNivelDeEstresse(NivelTres nivelDeEstresse) {
        this.nivelDeEstresse = nivelDeEstresse;
    }

    public int getHoras_de_sono() {
        return Horas_de_sono;
    }

    public void setHoras_de_sono(int horas_de_sono) {
        Horas_de_sono = horas_de_sono;
    }

    public Qualidade getQualidade_do_sono() {
        return qualidade;
    }

    public void setQualidade_do_sono(Qualidade qualidade_do_sono) {
        this.qualidade = qualidade;
    }

    public double getConsumode_agua_diario() {
        return consumode_agua_diario;
    }

    public void setConsumode_agua_diario(double consumode_agua_diario) {
        this.consumode_agua_diario = consumode_agua_diario;
    }


}
