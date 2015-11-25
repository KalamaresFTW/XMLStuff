/*
 */
package Extra;

import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author pcostoubi
 */
public class ManejadorEmpleados extends DefaultHandler {

    private char separador;
    private boolean esSeparador;
    private boolean esEmpleado;
    private boolean esNombre;
    private HashMap datos;
    private boolean esCargo;
    private boolean esDireccion;
    private boolean esAumento;

    public ManejadorEmpleados() {
        datos = new HashMap();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Procesando documento.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fin.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equalsIgnoreCase("separador")) {
            esSeparador = true;
        }
        if (localName.equalsIgnoreCase("empleado")) {
            esEmpleado = true;
        }
        if (localName.equalsIgnoreCase("nombre")) {
            esNombre = true;
        }
        if (localName.equalsIgnoreCase("cargo")) {
            esCargo = true;
        }
        if (localName.equalsIgnoreCase("direccion")) {
            esDireccion = true;
        }
        if (localName.equalsIgnoreCase("aumento")) {
            esAumento = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equalsIgnoreCase("separador")) {
            esSeparador = false;
        }
        if (localName.equalsIgnoreCase("empleado")) {
            String nombre = datos.get("nombre").toString();
            String cargo = datos.get("cargo").toString();
            String direccion = datos.get("direccion").toString();
            double aumento = Double.parseDouble(datos.get("aumento").toString());
            new DocumentCreator(nombre, cargo, direccion, aumento, this.separador).createDocument();
            datos.clear();
            esEmpleado = false;
        }
        if (localName.equalsIgnoreCase("nombre")) {
            esNombre = false;
        }
        if (localName.equalsIgnoreCase("nombre")) {
            esNombre = false;
        }
        if (localName.equalsIgnoreCase("cargo")) {
            esCargo = false;
        }
        if (localName.equalsIgnoreCase("direccion")) {
            esDireccion = false;
        }
        if (localName.equalsIgnoreCase("aumento")) {
            esAumento = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (esSeparador) {
            System.out.println("Separador: " + String.valueOf(ch, start, length));
            this.separador = ch[start];
        }
        if (esNombre) {
            datos.put("nombre", String.valueOf(ch, start, length));
        }
        if (esCargo) {
            datos.put("cargo", String.valueOf(ch, start, length));
        }
        if (esDireccion) {
            datos.put("direccion", String.valueOf(ch, start, length));
        }
        if (esAumento) {
            datos.put("aumento", String.valueOf(ch, start, length));
        }
    }
}
