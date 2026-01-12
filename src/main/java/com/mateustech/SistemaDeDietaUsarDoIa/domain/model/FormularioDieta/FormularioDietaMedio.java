package com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.AtividadeFisica.AtividadeFisica;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.DadosFisicos.DadosFisicos;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.Objetivo.Objetivo;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.alimentacaoAtual.AlimentacaoAtual;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Usuario.Usuario;

public class FormularioDietaMedio {

    private Usuario usuario;
    private DadosFisicos dadosFisicos;
    private AtividadeFisica atividadeFisica;
    private AlimentacaoAtual alimentacaoAtual;
    private Objetivo objetivo;

    public FormularioDietaMedio() {
    }

    public FormularioDietaMedio(Usuario usuario, DadosFisicos dadosFisicos, AtividadeFisica atividadeFisica, AlimentacaoAtual alimentacaoAtual, Objetivo objetivo) {
        this.usuario = usuario;
        this.dadosFisicos = dadosFisicos;
        this.atividadeFisica = atividadeFisica;
        this.alimentacaoAtual = alimentacaoAtual;
        this.objetivo = objetivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public DadosFisicos getDadosFisicos() {
        return dadosFisicos;
    }

    public void setDadosFisicos(DadosFisicos dadosFisicos) {
        this.dadosFisicos = dadosFisicos;
    }

    public AtividadeFisica getAtividadeFisica() {
        return atividadeFisica;
    }

    public void setAtividadeFisica(AtividadeFisica atividadeFisica) {
        this.atividadeFisica = atividadeFisica;
    }

    public AlimentacaoAtual getAlimentacaoAtual() {
        return alimentacaoAtual;
    }

    public void setAlimentacaoAtual(AlimentacaoAtual alimentacaoAtual) {
        this.alimentacaoAtual = alimentacaoAtual;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }
}
