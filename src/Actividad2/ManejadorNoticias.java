/*
 */
package Actividad2;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author pcostoubi
 */
class ManejadorNoticias extends DefaultHandler {

    private static int num_noticia = 0;
    private boolean title;
    private boolean item;
    private boolean status;
    private boolean user;
    private boolean votes;
    private boolean category;
    private boolean pubDate;
    private final ArrayList<String> categories = new ArrayList<>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("\t\t\t\t\t MENÉAME");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println(num_noticia + " noticias.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equals("item")) {
            item = true;
        }
        if (localName.equals("title")) {
            title = true;
        }
        if (qName.equals("meneame:status")) {
            status = true;
        }
        if (qName.equals("meneame:user")) {
            user = true;
        }
        if (qName.equals("meneame:votes")) {
            votes = true;
        }
        if (qName.equals("category")) {
            category = true;
        }
        if (qName.equals("pubDate")) {
            pubDate = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("item")) {
            if (!categories.isEmpty()) {
                System.out.print("\tCategorías: ");
                int ultimo = categories.size() - 1;
                for (String category : categories) {
                    //Si estamos tratando el último elemento no mostramos la coma
                    if (categories.get(ultimo).equals(category)) {
                        System.out.print(category + ".");
                    } else {
                        System.out.print(category + ", ");
                    }
                }
                categories.clear();
            }
            System.out.println(System.lineSeparator());
            item = false;
        }
        if (localName.equals("title")) {
            title = false;
        }
        if (qName.equals("meneame:status")) {
            status = false;
        }
        if (qName.equals("meneame:user")) {
            user = false;
        }
        if (qName.equals("meneame:votes")) {
            votes = false;
        }
        if (qName.equals("category")) {
            category = false;
        }
        if (qName.equals("pubDate")) {
            pubDate = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (item) {
            if (title) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Noticia " + num_noticia++ + " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\tTítulo: " + String.valueOf(ch, start, length));
            }
            if (pubDate) {
                System.out.println("\tFecha: " + String.valueOf(ch, start, length));
            }
            if (status) {
                System.out.print("\tEstado: " + (String.valueOf(ch, start, length).equals("published") ? "publicada" : "pendiente"));
            }
            if (user) {
                System.out.print("\tEnviado por: " + "Pepa" /*String.valueOf(ch, start, length)*/);
            }
            if (votes) {
                System.out.println("\tVotos: " + String.valueOf(ch, start, length));
            }
            if (category) {
                categories.add(String.valueOf(ch, start, length));
            }
        }
    }
}
