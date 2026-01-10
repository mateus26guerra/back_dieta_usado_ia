package com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.saude;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.saude.Senum.Condição_de_saúde;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.enumGenerico.SimNao;

public class saude {
    private Condição_de_saúde condição_de_saúde;
    private  SimNao medicamentos_contínuos;
    private  SimNao fez_dieta_antes;
    public saude() {
    }

    public saude(Condição_de_saúde condição_de_saúde, SimNao medicamentos_contínuos, SimNao fez_dieta_antes) {
        this.condição_de_saúde = condição_de_saúde;
        this.medicamentos_contínuos = medicamentos_contínuos;
        this.fez_dieta_antes = fez_dieta_antes;
    }

    public Condição_de_saúde getCondição_de_saúde() {
        return condição_de_saúde;
    }

    public void setCondição_de_saúde(Condição_de_saúde condição_de_saúde) {
        this.condição_de_saúde = condição_de_saúde;
    }

    public SimNao getMedicamentos_contínuos() {
        return medicamentos_contínuos;
    }

    public void setMedicamentos_contínuos(SimNao medicamentos_contínuos) {
        this.medicamentos_contínuos = medicamentos_contínuos;
    }

    public SimNao getFez_dieta_antes() {
        return fez_dieta_antes;
    }

    public void setFez_dieta_antes(SimNao fez_dieta_antes) {
        this.fez_dieta_antes = fez_dieta_antes;
    }


}
