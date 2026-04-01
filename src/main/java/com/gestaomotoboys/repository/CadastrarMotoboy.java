package com.gestaomotoboys.repository;

import com.gestaomotoboys.model.Motoboy;

import java.util.ArrayList;
import java.util.List;

public class CadastrarMotoboy {

    private List<Motoboy> motoboys = new ArrayList<>();

    public void cadastrar(Motoboy motoboy){
        motoboys.add(motoboy);
    }

    public Motoboy buscarPorId(int id){
        for(Motoboy m : motoboys){
            if(m.getId() == id) return m;
        }
        return null;
    }

    public Motoboy buscarPorNome(String nome){
        for(Motoboy m : motoboys){
            if (m.getNome().equalsIgnoreCase(nome)) return m;
        }
        return null;
    }
}
