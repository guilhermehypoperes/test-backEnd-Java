package br.com.uol.test.business;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Vingadores {
    @SerializedName("vingadores")
    @Expose
    private List<Codinome> vingadores = null;

    public List<Codinome> getVingadores() {
        return vingadores;
    }

    public List<String> getVingadoresStringList() {
        final ArrayList<String> listString = new ArrayList<String>();
        vingadores.forEach((k) -> listString.add(k.getCodinome()));
        return listString;
    }

    public void setVingadores(List<Codinome> vingadores) {
        this.vingadores = vingadores;
    }
}
