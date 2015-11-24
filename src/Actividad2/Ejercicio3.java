package Actividad2;

import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Ejercicio3 {

    private static final String URL = "http://meneame.feedsportal.com/rss";
    public static final String PROXYHOST = "192.168.0.11";
    private static final String PROXYPORT = "3128";

    public static void main(String[] args) {
        try {
            System.setProperty("http.proxyHost", PROXYHOST);
            System.setProperty("http.proxyPort", PROXYPORT);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new ManejadorNoticias());
            reader.setErrorHandler(new SimpleErrorHandler());
            reader.parse(URL);
        } catch (SAXException ex) {
            System.err.println("Sax Error");
        } catch (IOException ex) {
            System.err.println("Error al obtener el XML");
        }
    }
}
