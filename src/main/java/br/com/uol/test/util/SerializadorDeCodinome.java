package br.com.uol.test.util;

import br.com.uol.test.business.LigaDaJustica;
import br.com.uol.test.business.Vingadores;
import com.google.gson.Gson;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class SerializadorDeCodinome {

    public List<String> serializaCodinomes(String arquivo) throws JAXBException {

        List<String> codinomes = new ArrayList<String>();

        if(arquivo.contains("vingadores")){
            codinomes = new Gson().fromJson(arquivo, Vingadores.class).getVingadoresStringList();
        }else{
            JAXBContext jaxbContext = JAXBContext.newInstance(LigaDaJustica.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(arquivo);
            LigaDaJustica ligaDaJustica = (LigaDaJustica) unmarshaller.unmarshal(reader);
            codinomes = ligaDaJustica.getCodinomes().getCodinome();
        }
        return codinomes;
    }


}
