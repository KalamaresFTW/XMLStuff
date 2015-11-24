package Actividad1;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @autor pcostoubi
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        String XMLDocument = "Actores.xml";
        Document documento = null;
        try {
            documento = documentBuilderFactory.newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException ex) {
        }

        try {
            DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
            documento = db.parse(new File(XMLDocument));
            System.out.println("Éxito al cargar");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.err.println("Error /n" + e.getMessage());
        }

        System.out.println("Validacion: " + documentBuilderFactory.isValidating());
        if (!documentBuilderFactory.isValidating()) {
            documentBuilderFactory.setValidating(true);
            System.out.println("Validación activada.");
        }

        System.out.println("Espacio de nombres: " + documentBuilderFactory.isNamespaceAware());
        if (!documentBuilderFactory.isNamespaceAware()) {
            documentBuilderFactory.setNamespaceAware(true);
            System.out.println("Espacio de nombres activado");
        }

        System.out.println("Ignorar comentarios: " + documentBuilderFactory.isIgnoringComments());
        if (!documentBuilderFactory.isIgnoringComments()) {
            documentBuilderFactory.setIgnoringComments(true);
            System.out.println("Los comentarios se ignorarán.");
        }

        System.out.println("Codificacion del documento XML: " + documento.getXmlEncoding());

        DocumentType d = documento.getDoctype();
        if (d != null) {
            System.out.println("DTD asociado: " + documento.getDoctype().getName());
        } else {
            System.out.println("No hay DTD asociado");
        }

        NodeList actores = documento.getElementsByTagName("Actor");
        Element raiz = documento.getDocumentElement();  
        System.out.println(
                "\nNombre del elemento raíz: " + raiz.getTagName()
                + "\nValor del nodo: " + raiz.getNodeValue()
                + "\nNúmero de hijos: " + actores.getLength());

        System.out.println("Lista de actores");
        for (int i = 0; i < actores.getLength(); i++) {
            Node actor = actores.item(0);
            System.out.println(actor.getNodeName() + actor.getTextContent());
        }

        //Este es el segundo "hijo" del nodo "padre" o raíz 
        Node nodo = raiz.getFirstChild().getNextSibling();
        System.out.println("Nombre nodo: " + nodo.getNodeName() + "- Valor del nodo: " + nodo.getNodeValue());

        /**
         * 9) A partir del nodo situado en el ejercicio anterior visualiza la
         * siguiente información:
         *
         * Nombre nodo:Actor Valor del nodo:null
         * <id>:59
         * <Nome>:Eliabeth Shue
         * <Sexo>:muller
         * <DataNacemento>: 06/10/1963
         */
        System.out.println("9.");
        System.out.println("Nombre nodo: " + nodo.getNodeName() + ". Valor del nodo: " + nodo.getNodeValue());
        for (int i = 0; i < nodo.getAttributes().getLength(); i++) {
            Node itemNode = nodo.getAttributes().item(i);
            System.out.println("<" + itemNode.getNodeName() + ">: " + itemNode.getNodeValue());
        }

        NodeList listaNodos = nodo.getChildNodes();
        for (int i = 0; i < listaNodos.getLength(); i++) {
            Node itemNode = listaNodos.item(i);
            if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("<" + itemNode.getNodeName() + ">" + itemNode.getTextContent() + "<" + itemNode.getNodeName() + "/>");
            }
        }

        /**
         * 10) A partir del nodo anterior, obten la misma informacion del nodo
         * hermano de actor que esta situado dos posiciones hacia la derecha
         * (nodo con id="100")
         */
        System.out.println("10.");
        Node nodo139 = nodo.getNextSibling();
        Node nodo100 = nodo139.getNextSibling();

        System.out.println("Nombre nodo: " + nodo100.getNodeName() + ". Valor del nodo: " + nodo100.getNodeValue());
        for (int i = 0; i < nodo100.getAttributes().getLength(); i++) {
            Node itemNode = nodo100.getAttributes().item(i);
            System.out.println("<" + itemNode.getNodeName() + ">: " + itemNode.getNodeValue());
        }

        NodeList lista2 = nodo100.getChildNodes();
        for (int i = 0; i < lista2.getLength(); i++) {
            Node itemNode = lista2.item(i);
            if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("<" + itemNode.getNodeName() + ">: " + itemNode.getTextContent());
            }
        }

        //12
        listarNodos(raiz);
    }

    public static void listarNodos(Node node) {
        System.out.println("Nombre del nodo: " + node.getNodeName() + " Valor del nodo: " + node.getNodeValue());
        if (node.getAttributes().item(0) != null) {
            System.out.println(node.getAttributes().item(0));
        }
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                listarNodos(currentNode);
            }
        }
    }
}
