package com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.Comprometimento;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.Comprometimento.Cenum.Preferencia_de_dietas;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.Comprometimento.Cenum.Preferencia_de_refeicoes;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.enumGenerico.NivelTres;

public class Comprometimento {
    private NivelTres grau_de_comprometimento;
    private Preferencia_de_dietas preferenciaDedietas;
    private NivelTres orcamentoMensalParaAlimentacao;
    private Preferencia_de_refeicoes preferenciaDerefeicoes;

    public Comprometimento() {
    }

    public Comprometimento(NivelTres grau_de_comprometimento, Preferencia_de_dietas preferenciaDedietas, NivelTres orcamentoMensalParaAlimentacao, Preferencia_de_refeicoes preferenciaDerefeicoes) {
        this.grau_de_comprometimento = grau_de_comprometimento;
        this.preferenciaDedietas = preferenciaDedietas;
        this.orcamentoMensalParaAlimentacao = orcamentoMensalParaAlimentacao;
        this.preferenciaDerefeicoes = preferenciaDerefeicoes;
    }

    public void setGrau_de_comprometimento(NivelTres grau_de_comprometimento) {
        this.grau_de_comprometimento = grau_de_comprometimento;
    }

    public Preferencia_de_refeicoes getPreferenciaDeRefeicoes() {
        return preferenciaDerefeicoes;
    }

    public NivelTres getOrcamentoMensalParaAlimentacao() {
        return orcamentoMensalParaAlimentacao;
    }

    public void setOrcamentoMensalParaAlimentacao(NivelTres orcamentoMensalParaAlimentacao) {
        this.orcamentoMensalParaAlimentacao = orcamentoMensalParaAlimentacao;
    }

    public void setPreferenciaDeRefeicoes(Preferencia_de_refeicoes preferenciaDerefeicoes) {
        this.preferenciaDerefeicoes = preferenciaDerefeicoes;
    }

    public Preferencia_de_dietas getPreferenciaDeDietas() {
        return preferenciaDedietas;
    }

    public void setPreferenciaDeDietas(Preferencia_de_dietas preferenciaDedietas) {
        this.preferenciaDedietas = preferenciaDedietas;
    }


}
