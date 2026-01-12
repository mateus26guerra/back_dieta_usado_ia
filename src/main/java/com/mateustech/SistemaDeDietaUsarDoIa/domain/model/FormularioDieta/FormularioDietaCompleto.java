package com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.AtividadeFisica.AtividadeFisica;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.Comprometimento.Comprometimento;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.DadosFisicos.DadosFisicos;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.Objetivo.Objetivo;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.PreferenciasAlimentares.PreferenciasAlimentares;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.alimentacaoAtual.AlimentacaoAtual;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.habitosDeVida.HabitosDeVida;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Perguntas.saude.Saude;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Usuario.Usuario;

public class FormularioDietaCompleto {


    private Usuario usuario;//
    private DadosFisicos dadosFisicos;//
    private AtividadeFisica atividadeFisica;//
    private AlimentacaoAtual alimentacaoAtual;//
    private Saude saude;//
    private HabitosDeVida habitosDeVida;//
    private PreferenciasAlimentares preferenciasAlimentares;//
    private Objetivo objetivo;//
    private Comprometimento comprometimento;

    FormularioDietaCompleto(){

    }

    public FormularioDietaCompleto(Usuario usuario, DadosFisicos dadosFisicos, AtividadeFisica atividadeFisica, AlimentacaoAtual alimentacaoAtual, Saude saude, HabitosDeVida habitosDeVida, PreferenciasAlimentares preferenciasAlimentares, Objetivo objetivo, Comprometimento comprometimento) {
        this.usuario = usuario;
        this.dadosFisicos = dadosFisicos;
        this.atividadeFisica = atividadeFisica;
        this.alimentacaoAtual = alimentacaoAtual;
        this.saude = saude;
        this.habitosDeVida = habitosDeVida;
        this.preferenciasAlimentares = preferenciasAlimentares;
        this.objetivo = objetivo;
        this.comprometimento = comprometimento;
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

    public Saude getSaude() {
        return saude;
    }

    public void setSaude(Saude saude) {
        this.saude = saude;
    }

    public HabitosDeVida getHabitosDeVida() {
        return habitosDeVida;
    }

    public void setHabitosDeVida(HabitosDeVida habitosDeVida) {
        this.habitosDeVida = habitosDeVida;
    }

    public PreferenciasAlimentares getPreferenciasAlimentares() {
        return preferenciasAlimentares;
    }

    public void setPreferenciasAlimentares(PreferenciasAlimentares preferenciasAlimentares) {
        this.preferenciasAlimentares = preferenciasAlimentares;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public Comprometimento getComprometimento() {
        return comprometimento;
    }

    public void setComprometimento(Comprometimento comprometimento) {
        this.comprometimento = comprometimento;
    }
}
