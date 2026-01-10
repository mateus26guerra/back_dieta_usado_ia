package com.mateustech.SistemaDeDietaUsarDoIa.domain.model.Usuario;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.Usuario.Uenum.Sexo;

public class Usuario {

   private String Primeiro_nome;
   private int Idade;
   private Sexo sexo;


    public Usuario() {
    }

    public Usuario(String primeiro_nome, int idade, Sexo sexo) {
        Primeiro_nome = primeiro_nome;
        Idade = idade;
        this.sexo = sexo;
    }


    public String getPrimeiro_nome() {
        return Primeiro_nome;
    }

    public void setPrimeiro_nome(String primeiro_nome) {
        Primeiro_nome = primeiro_nome;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
