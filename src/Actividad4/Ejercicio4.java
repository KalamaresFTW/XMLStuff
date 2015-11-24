package Actividad4;

import Actividad4.ClasesEjercicio4.*;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Ejercicio4 {

    public static void main(String[] args) {
        Modulo modulo = null;
        JAXBContext context;
        Unmarshaller m;
        File ficheroXML = new File("Modulo.xml");
        if (ficheroXML.exists()) {
            System.out.println("Fichero XML encontrado");
        } else {
            System.err.println("Fichero XML no encontrado.");
            System.exit(0);
        }
        try {
            context = JAXBContext.newInstance(Modulo.class);
            m = context.createUnmarshaller();
            modulo = (Modulo) m.unmarshal(ficheroXML);
        } catch (JAXBException e) {
            System.err.println("Error");
        }
        modulo.listarContidos();
    }
}
