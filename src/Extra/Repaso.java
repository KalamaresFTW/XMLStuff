/*
 */
package Extra;

import java.io.FileNotFoundException;
import java.io.IOException;
import jdk.internal.util.xml.impl.XMLWriter;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author pcostoubi
 */
public class Repaso {

    public static void main(String[] args) {
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException ex) {
            System.err.println("SAX error");
        }
        reader.setErrorHandler(new SimpleErrorHandler());
        reader.setContentHandler(new ManejadorEmpleados());
        try {
            reader.parse("Empleados.xml");
        } catch (FileNotFoundException ex) {
            System.err.println("Fichero no encontrado");
        } catch (IOException | SAXException ex) {
            System.err.println("Error al leer el fichero");
        }
    }
}
