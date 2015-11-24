/*
 */
package Actividad2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ManejadorMareas extends DefaultHandler {

    private boolean titulo;
    private boolean fecha;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equalsIgnoreCase("title")) {
            System.out.println("==================================");
            titulo = true;
        }
        if (localName.equalsIgnoreCase("date")) {
            fecha = true;
        }
        if (qName.equalsIgnoreCase("Mareas:mareas")) {
            System.out.println("\tEstado:" + attributes.getValue(1) + " Hora:"
                    + attributes.getValue(2) + " Altura:" + attributes.getValue(3));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equalsIgnoreCase("item")) {
            System.out.println();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (titulo) {
            System.out.println(String.valueOf(ch, start, length));
            titulo = false;
        }
        if (fecha) {
            //Ñapas made in chando
            System.out.println("Fecha de la predicción: " + String.valueOf(ch, start, length).replaceAll("[TZ]", " "));
            fecha = false;
        }
    }
}
