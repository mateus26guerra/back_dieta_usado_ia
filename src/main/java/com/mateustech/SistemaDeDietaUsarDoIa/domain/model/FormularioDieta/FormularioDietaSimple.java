package com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.DadosFisicos.DadosFisicos;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.Objetivo.Objetivo;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Usuario.Usuario;

public class FormularioDietaSimple {


    private Usuario usuario;
    private DadosFisicos dadosFisicos;
    private Objetivo objetivo;

    public FormularioDietaSimple() {
    }

    public FormularioDietaSimple(Usuario usuario, DadosFisicos dadosFisicos, Objetivo objetivo) {
        this.usuario = usuario;
        this.dadosFisicos = dadosFisicos;
        this.objetivo = objetivo;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
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
}
