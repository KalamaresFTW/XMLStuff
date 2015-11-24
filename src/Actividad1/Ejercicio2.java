package Actividad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio2 {

    public static void main(String[] args) throws IOException {

        //2 - Un programa que cree un fichero de texto contenga toda la información de los actores
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setIgnoringComments(true);
        builderFactory.setCoalescing(true);
        Document d = null;
        try {
            d = builderFactory.newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            DocumentBuilder db = builderFactory.newDocumentBuilder();
            d = db.parse(new File("Actores.xml"));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.err.println("Error");
        }

        OutputStreamWriter writer = null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream("Actores.txt"), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            System.err.println("Codificación no soportada");
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo de texto no encontrado");
        }

        writer.write("Actores");
        writer.write(System.lineSeparator());
        NodeList actores = d.getElementsByTagName("Actor");
        for (int i = 0; i < actores.getLength(); i++) {
            Node actual = actores.item(i);
            writer.write("-------------------------------");
            writer.write(System.lineSeparator());
            writer.write(actual.getAttributes().item(0).getNodeName()
                    + ": " + actual.getAttributes().item(0).getFirstChild().getTextContent());
            writer.write(System.lineSeparator());
            for (int j = 0; j < actual.getChildNodes().getLength(); j++) {
                if (actual.getChildNodes().item(j).getNodeType() == Node.ELEMENT_NODE) {
                    writer.write(actual.getChildNodes().item(j).getNodeName()
                            + ": " + actual.getChildNodes().item(j).getTextContent());
                    writer.write(System.lineSeparator());
                }
            }
        }
        writer.close();
    }
}
