package br.com.uol.test.util;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

public class CodinomeUtil {

    public String getCodinomeDisponivel(String grupo, List<String> listaDeCodinomesEmUso, ConfigProperties properties) throws Exception {

        String codinome = "";

        HttpURLConnection connection = HttpConnectionUtil.getHttpConnection(
                properties.getConfigValue(((grupo.contains("Vingadores") ? "urlVingadores" : "urlLigaDaJustica"))));
        String response = IOUtils.toString(connection.getInputStream(), "UTF-8");
        List<String> codinomes = new SerializadorDeCodinome().serializaCodinomes(response);

        //remove os codinomes já em uso
        codinomes.removeAll(listaDeCodinomesEmUso);
        if(!codinomes.isEmpty())
            codinome = codinomes.get(0);


        return codinome;
    }


}
