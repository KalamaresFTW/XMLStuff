package Actividad4;

import Actividad4.ClasesEjercicio1.Corredor;
import Actividad4.ClasesEjercicio1.Corredores;
import com.thoughtworks.xstream.XStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;

public class Ejercicio1 {
    
    private static final int NUM_CORREDORES = 100;

    public static void main(String[] args) {
        Corredores corredores = new Corredores();
        for (int i = 0; i < NUM_CORREDORES; i++) {
            corredores.addCorredor(new Corredor(i, "Corredor " + i, (long) (new Random().nextInt(NUM_CORREDORES))));
        }
        corredores.listarCorredores();

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("Corredores.xml");
        } catch (FileNotFoundException ex) {
            System.err.println("Fichero no encontrado");
        }
        XStream stream = new XStream();
        stream.alias("corredores", Corredores.class);
        stream.alias("corredor", Corredor.class);
        stream.addImplicitCollection(Corredores.class, "listaCorredores");
        stream.useAttributeFor(Corredor.class, "dorsal");
        stream.toXML(corredores, outputStream);
        String xml = stream.toXML(corredores);
        System.out.println(xml);
    }
}
