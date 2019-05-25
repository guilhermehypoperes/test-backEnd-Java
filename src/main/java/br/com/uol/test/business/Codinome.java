package br.com.uol.test.business;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Codinome{

    @SerializedName("codinome")
    @Expose
    private String codinome;

    public String getCodinome() {
        return codinome;
    }

}
