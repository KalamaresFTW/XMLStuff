/*
 */
package Actividad2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author pcostoubi
 */
public class ManejadorActores extends DefaultHandler {
    
    private static int numActores = 0; 
    private BufferedWriter writer;
    
    //Constantes de texto
    private static final String INFORMACIÓN_DE_LOS_ACTORES = "Información de los actores.";
    private static final String NÚMERO_DE_ACTORES_ = "Número de actores: ";
    private static final String STRING = "***********";
    private static final String STRING1 = "================";
    private static final String STRING2 = "-------------------------------";
    private static final String ERROR = "Error";
    private static final String _ = ": ";
    private static final String ACTOR = "Actor";
    private static final String ESPACIO = " ";

    public ManejadorActores() {
        try {
            writer = new BufferedWriter(new FileWriter(new File("InfoActores.txt")));
        } catch (IOException ex) {
            System.err.println(ERROR);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println(INFORMACIÓN_DE_LOS_ACTORES);
        writeln(INFORMACIÓN_DE_LOS_ACTORES);
        System.out.println(STRING1);
        writeln(STRING1);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println(STRING1);
        writeln(STRING1);
        System.out.println(NÚMERO_DE_ACTORES_ + numActores);
        writeln(NÚMERO_DE_ACTORES_ + numActores);
        try {
            writer.close();
        } catch (IOException ex) {
            System.err.println(ERROR);
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equals(ACTOR)) {
            numActores++;
            System.out.println(localName + ESPACIO + numActores);
            writeln(localName + ESPACIO + numActores);
            System.out.println(STRING);
            writeln(STRING);
            if (attributes != null) {
                System.out.println(attributes.getLocalName(0) + _ + attributes.getValue(0));
                writeln(attributes.getLocalName(0) + _ + attributes.getValue(0));
            }
        } else {
            System.out.print(qName + _);
            write(qName + _);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals(ACTOR)) {
            System.out.println(STRING2);
            writeln(STRING2);
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println(String.valueOf(ch, start, length));
        writeln(String.valueOf(ch, start, length));
    }

    //Escribe una linea en el fichero de texto con salto de línea
    private void writeln(String linea) {
        try {
            writer.write(linea);
            writer.newLine();
        } catch (IOException ex) {
            System.err.println(ERROR);
        }
    }

    //Escribe una linea en el fichero de texto, sin salto de línea
    private void write(String linea) {
        try {
            writer.write(linea);
        } catch (IOException ex) {
            System.err.println(ERROR);
        }

    }
}
