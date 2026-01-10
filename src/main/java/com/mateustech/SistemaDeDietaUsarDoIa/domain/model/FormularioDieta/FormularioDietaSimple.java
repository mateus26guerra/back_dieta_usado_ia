package com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.AtividadeFisica.AtividadeFisica;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.DadosFisicos.DadosFisicos;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.Usuario.Usuario;

public class FormularioDietaSimple {


    private Usuario usuario;
    private DadosFisicos dadosFisicos;
    private AtividadeFisica atividadeFisica;

    public FormularioDietaSimple(Usuario usuario, DadosFisicos dadosFisicos, AtividadeFisica atividadeFisica) {
        this.usuario = usuario;
        this.dadosFisicos = dadosFisicos;
        this.atividadeFisica = atividadeFisica;
    }

    public void setAtividadeFisica(AtividadeFisica atividadeFisica) {
        this.atividadeFisica = atividadeFisica;
    }

    public AtividadeFisica getAtividadeFisica() {
        return atividadeFisica;
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
}
