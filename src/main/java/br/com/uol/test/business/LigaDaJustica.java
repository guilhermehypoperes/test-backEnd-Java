
package br.com.uol.test.business;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codinomes"
})
@XmlRootElement(name = "liga_da_justica")
public class LigaDaJustica {

    @XmlElement(required = true)
    protected LigaDaJustica.Codinomes codinomes;

    public LigaDaJustica.Codinomes getCodinomes() {
        return codinomes;
    }

    public void setCodinomes(LigaDaJustica.Codinomes value) {
        this.codinomes = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "codinome"
    })
    public static class Codinomes {

        @XmlElement(required = true)
        protected List<String> codinome;

        public List<String> getCodinome() {
            if (codinome == null) {
                codinome = new ArrayList<String>();
            }
            return this.codinome;
        }

    }

}
