/*
 */
package Actividad2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author pcostoubi
 */
public class Ejercicio1 {

    private static final String val = "http://xml.org/sax/features/validation"; //DTD
    private static final String namespaces = "http://xml.org/sax/features/namespaces";
    private static final String esquemas = "http://apache.org/xml/features/validation/schema"; //Schema

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();

            if (!reader.getFeature(val)) {
                System.out.println("El Reader no valida, se activará.");
                reader.setFeature(val, true);
                System.out.println("Validación activada.");
            } else {
                System.out.println("El Reader ya valida.");
            }

            if (!reader.getFeature(namespaces)) {
                System.out.println("El Reader no soporta espacios de nombres, se activarán.");
                reader.setFeature(namespaces, true);
                System.out.println("Espacios de nombres activados.");
            } else {
                System.out.println("El Reader ya soporta espacios de nombres.");
            }
            
            if (!reader.getFeature(esquemas)) {
                System.out.println("El Reader no soporta validación con esquemas, se activará.");
                reader.setFeature(esquemas, true);
                System.out.println("Validación con esquemas activada.");
            } else {
                System.out.println("El reader ya soporta la validación con esquemas");
            }
            reader.setContentHandler(new ManejadorActores());
            reader.setErrorHandler(new SimpleErrorHandler());
            reader.parse(new InputSource(new FileInputStream("Actores.xml")));
        } catch (FileNotFoundException ex) {
            System.err.println("Fichero XML no encontrado");
        } catch (IOException ex) {
            System.err.println("Error de IO");
        } catch (SAXException ex) {
            System.err.println("Error con SAX");
        }


    }
}
