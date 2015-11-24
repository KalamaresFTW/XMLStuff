package Actividad4;

import Actividad4.ClasesEjercicio5.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Ejercicio5 {

    public static void main(String[] args) {
        Direccion d1 = new Direccion("Entrecortiñas", 15, "Illa de Arousa", "Pontevedra");
        Informacion i1 = new Informacion(d1, new String[]{"123456789", "987654321"});
        Persona p1 = new Estudiante("Pablo", 21, i1, "UDC", "Informática");

        Direccion d2 = new Direccion("Calle falsa", 123, "Pontevedra", "Pontevedra");
        Informacion i2 = new Informacion(d2, new String[]{"41984119", "91981981"});
        Persona p2 = new Trabajador("Perico", 26, i2, "Empresa Random S.L", "Jefaso", 9999.15);


        Personas personas = new Personas();
        personas.addPersona(p1);
        personas.addPersona(p2);

        JAXBContext context;
        Marshaller m;
        FileOutputStream outputStream;
        try {
            context = JAXBContext.newInstance(Personas.class);
            m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            outputStream = new FileOutputStream("Personas.xml");
            m.marshal(personas, outputStream);
            m.marshal(personas, System.out);
        } catch (JAXBException ex) {
            System.err.println("Error");
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            System.err.println("Error al escribir en el fichero de Personas");
            ex.printStackTrace();
        }
    }
}
