package Actividad4;

import Actividad4.ClasesEjercicio1.Corredores;
import Actividad4.ClasesEjercicio1.Corredor;
import com.thoughtworks.xstream.XStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ejercicio1_inv {

    public static void main(String[] args) {
        Corredores corredores;
        FileInputStream input = null;
        try {
            input = new FileInputStream("Corredores.xml");
        } catch (IOException e) {
            System.err.println("IO error");
        }
        XStream xStream = new XStream();
        xStream.alias("corredores", Corredores.class);
        xStream.alias("corredor", Corredor.class);
        xStream.addImplicitCollection(Corredores.class, "listaCorredores", Corredor.class);
        xStream.useAttributeFor(Corredor.class, "dorsal");
        corredores = (Corredores) xStream.fromXML(input);
        corredores.listarCorredores();
    }
}
