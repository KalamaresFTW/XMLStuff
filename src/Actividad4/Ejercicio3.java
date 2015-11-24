package Actividad4;

import Actividad4.ClasesEjercicio3.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Ejercicio3 {

    public static void main(String[] args) {
        JAXBContext context;
        Marshaller m;
        Empresa empresa = new Empresa("A58818501", "TECNOMUR S.L");
        empresa.addEmpleado(new Empleado("35598802T", "Pablo", 21));
        empresa.addEmpleado(new Empleado("12345678R", "Pepe", 22));
        empresa.addEmpleado(new Empleado("11811651Y", "Nerd", 23));
        try {
            context = JAXBContext.newInstance(Empresa.class);
            m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(empresa, System.out);
        } catch (JAXBException e) {
            System.err.println("Error");
        }
    }
}
