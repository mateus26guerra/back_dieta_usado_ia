package com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.Objetivo;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.Objetivo.OBenum.Objetivo_principal;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.Objetivo.OBenum.Tipo_de_resultado;

public class Objetivo {
    private Objetivo_principal objetivo_principal;
    private String Objetivo_secundário;
    private Double KgDesejoPerder;
    private Double kgDesejoGanhar;
    private Tipo_de_resultado tipo_de_resultado;

    public Objetivo() {
    }

    public Objetivo(Objetivo_principal objetivo_principal, String objetivo_secundário, Double kgDesejoPerder, Double kgDesejoGanhar, Tipo_de_resultado tipo_de_resultado) {
        this.objetivo_principal = objetivo_principal;
        Objetivo_secundário = objetivo_secundário;
        KgDesejoPerder = kgDesejoPerder;
        this.kgDesejoGanhar = kgDesejoGanhar;
        this.tipo_de_resultado = tipo_de_resultado;
    }

    public Objetivo_principal getObjetivo_principal() {
        return objetivo_principal;
    }

    public void setObjetivo_principal(Objetivo_principal objetivo_principal) {
        this.objetivo_principal = objetivo_principal;
    }

    public String getObjetivo_secundário() {
        return Objetivo_secundário;
    }

    public void setObjetivo_secundário(String objetivo_secundário) {
        Objetivo_secundário = objetivo_secundário;
    }

    public Double getKgDesejoPerder() {
        return KgDesejoPerder;
    }

    public void setKgDesejoPerder(Double kgDesejoPerder) {
        KgDesejoPerder = kgDesejoPerder;
    }

    public Double getKgDesejoGanhar() {
        return kgDesejoGanhar;
    }

    public void setKgDesejoGanhar(Double kgDesejoGanhar) {
        this.kgDesejoGanhar = kgDesejoGanhar;
    }

    public Tipo_de_resultado getTipo_de_resultado() {
        return tipo_de_resultado;
    }

    public void setTipo_de_resultado(Tipo_de_resultado tipo_de_resultado) {
        this.tipo_de_resultado = tipo_de_resultado;
    }
}
