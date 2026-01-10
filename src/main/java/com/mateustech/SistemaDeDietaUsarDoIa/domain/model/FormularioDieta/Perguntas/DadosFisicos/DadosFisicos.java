package com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.DadosFisicos;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.DadosFisicos.DFenum.Corpo;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.DadosFisicos.DFenum.Tipo_corpo;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.DadosFisicos.DFenum.Tipo_da_gentetica;

public class DadosFisicos {
    private Double Altura;
    private Double PesoAtual;
    private Double PesoIdeal;
    private Double PessoDesejado;
    private Tipo_corpo tipoCorpo;
    private Tipo_da_gentetica tipoDagentetica;
    private Corpo corpo;
    private Double PercentualDeGordura;

    public DadosFisicos() {
    }

    public DadosFisicos(Double altura, Double pesoAtual, Double pesoIdeal, Double pessoDesejado, Tipo_corpo tipoCorpo, Tipo_da_gentetica tipoDagentetica, Corpo corpo, Double percentualDeGordura) {
        Altura = altura;
        PesoAtual = pesoAtual;
        PesoIdeal = pesoIdeal;
        PessoDesejado = pessoDesejado;
        this.tipoCorpo = tipoCorpo;
        this.tipoDagentetica = tipoDagentetica;
        this.corpo = corpo;
        PercentualDeGordura = percentualDeGordura;
    }

    public Double getAltura() {
        return Altura;
    }

    public void setAltura(Double altura) {
        Altura = altura;
    }

    public Double getPesoAtual() {
        return PesoAtual;
    }

    public void setPesoAtual(Double pesoAtual) {
        PesoAtual = pesoAtual;
    }

    public Double getPesoIdeal() {
        return PesoIdeal;
    }

    public void setPesoIdeal(Double pesoIdeal) {
        PesoIdeal = pesoIdeal;
    }

    public Double getPessoDesejado() {
        return PessoDesejado;
    }

    public void setPessoDesejado(Double pessoDesejado) {
        PessoDesejado = pessoDesejado;
    }

    public Tipo_corpo getTipoCorpo() {
        return tipoCorpo;
    }

    public void setTipoCorpo(Tipo_corpo tipoCorpo) {
        this.tipoCorpo = tipoCorpo;
    }

    public Tipo_da_gentetica getTipoDaGentetica() {
        return tipoDagentetica;
    }

    public void setTipoDaGentetica(Tipo_da_gentetica tipoDagentetica) {
        this.tipoDagentetica = tipoDagentetica;
    }

    public Corpo getCorpo() {
        return corpo;
    }

    public void setCorpo(Corpo corpo) {
        this.corpo = corpo;
    }

    public Double getPercentualDeGordura() {
        return PercentualDeGordura;
    }

    public void setPercentualDeGordura(Double percentualDeGordura) {
        PercentualDeGordura = percentualDeGordura;
    }
}
