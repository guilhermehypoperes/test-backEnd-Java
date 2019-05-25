
package br.com.uol.test.util;

import br.com.uol.test.business.LigaDaJustica;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.uol.test.business package. 
 * <p>An LigaDaJusticaFactory allows you to programatically
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class LigaDaJusticaFactory {


    /**
     * Create a new LigaDaJusticaFactory that can be used to create new instances of schema derived classes for package: br.com.uol.test.business
     * 
     */
    public LigaDaJusticaFactory() {
    }

    /**
     * Create an instance of {@link LigaDaJustica }
     * 
     */
    public LigaDaJustica createLigaDaJustica() {
        return new LigaDaJustica();
    }

    /**
     * Create an instance of {@link LigaDaJustica.Codinomes }
     * 
     */
    public LigaDaJustica.Codinomes createLigaDaJusticaCodinomes() {
        return new LigaDaJustica.Codinomes();
    }

}
