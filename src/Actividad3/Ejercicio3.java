package Actividad3;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.sax.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Ejercicio3 {

    private static final String hojaEstios = "Notas.xsl";
    private static final String notas = "Notas.xml";

    public static void main(String[] args) {
        TransformerFactory transformerFactory;
        SAXTransformerFactory saxFactory;
        SAXSource datos;
        Source estilos;
        TransformerHandler handler;
        try {
            saxFactory = (SAXTransformerFactory) TransformerFactory.newInstance();
            datos = new SAXSource(new InputSource(notas));
            estilos = new StreamSource(hojaEstios);
            handler = saxFactory.newTransformerHandler(estilos);
            Result resultado = new SAXResult(new Manejador());
            handler.getTransformer().transform(estilos, resultado);
            //StreamResult result = 
        } catch (TransformerFactoryConfigurationError | TransformerConfigurationException e) {
            System.err.println("Error al obtener el transformador");
        } catch (TransformerException ex) {
            System.err.println("Error al transformar");
        }
    }

    private static class Manejador extends DefaultHandler {

        public Manejador() {
        }

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Pingas");
        }

        @Override
        public void endDocument() throws SAXException {
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
        }
    }
}
