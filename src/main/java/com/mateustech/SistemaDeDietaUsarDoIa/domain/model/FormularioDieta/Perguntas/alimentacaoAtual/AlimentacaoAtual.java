package com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.alimentacaoAtual;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.enumGenerico.NivelTres;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.enumGenerico.Qualidade;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.enumGenerico.SimNao;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.enumGenerico.Frequencia;

public class AlimentacaoAtual {
    private Qualidade Qualidade;
    private int refeições_por_dia;
    private SimNao pular_refeições;
    private NivelTres consumo_de_açúcar;
    private NivelTres consumo_de_ultraprocessados;
    private Frequencia consumo_de_bebidas_alcoólicas;

    AlimentacaoAtual(){
    }

    public AlimentacaoAtual(Qualidade Qualidade, int refeições_por_dia, SimNao pular_refeições, NivelTres consumo_de_açúcar, NivelTres consumo_de_ultraprocessados, Frequencia consumo_de_bebidas_alcoólicas) {
        this.Qualidade = Qualidade;
        this.refeições_por_dia = refeições_por_dia;
        this.pular_refeições = pular_refeições;
        this.consumo_de_açúcar = consumo_de_açúcar;
        this.consumo_de_ultraprocessados = consumo_de_ultraprocessados;
        this.consumo_de_bebidas_alcoólicas = consumo_de_bebidas_alcoólicas;
    }

    public NivelTres getConsumo_de_ultraprocessados() {
        return consumo_de_ultraprocessados;
    }

    public void setConsumo_de_ultraprocessados(NivelTres consumo_de_ultraprocessados) {
        this.consumo_de_ultraprocessados = consumo_de_ultraprocessados;
    }

    public int getRefeições_por_dia() {
        return refeições_por_dia;
    }

    public void setRefeições_por_dia(int refeições_por_dia) {
        this.refeições_por_dia = refeições_por_dia;
    }

    public SimNao getPular_refeições() {
        return pular_refeições;
    }

    public void setPular_refeições(SimNao pular_refeições) {
        this.pular_refeições = pular_refeições;
    }

    public NivelTres getConsumo_de_açúcar() {
        return consumo_de_açúcar;
    }

    public void setConsumo_de_açúcar(NivelTres consumo_de_açúcar) {
        this.consumo_de_açúcar = consumo_de_açúcar;
    }

    public Qualidade Qualidade() {
        return Qualidade;
    }

    public void Qualidade(Qualidade qualidade_da_alimentação) {
        this.Qualidade = qualidade_da_alimentação;
    }

    public Frequencia getConsumo_de_bebidas_alcoólicas() {
        return consumo_de_bebidas_alcoólicas;
    }

    public void setConsumo_de_bebidas_alcoólicas(Frequencia consumo_de_bebidas_alcoólicas) {
        this.consumo_de_bebidas_alcoólicas = consumo_de_bebidas_alcoólicas;
    }
}
