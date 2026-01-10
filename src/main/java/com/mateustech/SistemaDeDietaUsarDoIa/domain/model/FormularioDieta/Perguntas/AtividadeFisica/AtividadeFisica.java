package com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.AtividadeFisica;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.AtividadeFisica.AFenum.Intensidade;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.AtividadeFisica.AFenum.Tipo_de_treino;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.enumGenerico.SimNao;

public class AtividadeFisica {
    private SimNao pratica_atividade_física;
    private Tipo_de_treino tipo_de_treino;
    private int Frequência_semanal;
    private Intensidade intensidade;


    public AtividadeFisica() {
    }

    public AtividadeFisica(SimNao pratica_atividade_física, Tipo_de_treino tipo_de_treino, int frequência_semanal, Intensidade intensidade) {
        this.pratica_atividade_física = pratica_atividade_física;
        this.tipo_de_treino = tipo_de_treino;
        Frequência_semanal = frequência_semanal;
        this.intensidade = intensidade;
    }

    public Intensidade getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(Intensidade intensidade) {
        this.intensidade = intensidade;
    }

    public int getFrequência_semanal() {
        return Frequência_semanal;
    }

    public void setFrequência_semanal(int frequência_semanal) {
        Frequência_semanal = frequência_semanal;
    }

    public Tipo_de_treino getTipo_de_treino() {
        return tipo_de_treino;
    }

    public void setTipo_de_treino(Tipo_de_treino tipo_de_treino) {
        this.tipo_de_treino = tipo_de_treino;
    }

    public SimNao getPratica_atividade_física() {
        return pratica_atividade_física;
    }

    public void setPratica_atividade_física(SimNao pratica_atividade_física) {
        this.pratica_atividade_física = pratica_atividade_física;
    }
}
