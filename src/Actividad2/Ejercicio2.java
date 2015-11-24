package Actividad2;

import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Ejercicio2 {

    private static final String URL = "http://servizos.meteogalicia.es/rss/predicion/rssMareas.action?request_locale=gl";
    public static final String PROXYHOST = "192.168.0.11";
    private static final String PROXYPORT = "3128";

    public static void main(String[] args) {
        try {
            System.setProperty("http.proxyHost", PROXYHOST);
            System.setProperty("http.proxyPort", PROXYPORT);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new ManejadorMareas());
            reader.setErrorHandler(new SimpleErrorHandler());
            reader.parse(URL);
        } catch (SAXException ex) {
            System.err.println("Sax Error");
        } catch (IOException ex) {
            System.err.println("Error al obtener el XML de mareas");
        }
    }
}
