package Actividad3;

//Imports
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Ejercicio1 {
    
    private static final String hojaEstilos = "ActoresTablaHTML.xsl";
    private static final String datosActores = "Actores.xml";
    private static final String paginaHTML = "Tabla Actores.html";

    public static void main(String[] args) {
        TransformerFactory transFact;
        Transformer trans;
        StreamSource estilos;
        StreamSource datos;
        try {
            transFact = TransformerFactory.newInstance();
            estilos = new StreamSource(hojaEstilos);
            datos = new StreamSource(datosActores);
            trans = transFact.newTransformer(estilos);
            StreamResult resultado = new StreamResult(new FileWriter(paginaHTML));
            trans.transform(datos, resultado);
        } catch (TransformerFactoryConfigurationError | TransformerConfigurationException e) {
            System.err.println("Error al obtener el transformador");
        } catch (IOException ex) {
            System.err.println("Error de lectura/escritura");
        } catch (TransformerException ex) {
            System.err.println("Error al transformar");
        }
    }
}