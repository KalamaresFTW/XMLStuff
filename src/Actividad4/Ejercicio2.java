package Actividad4;

import Actividad4.ClasesEjercicio2.Alumno;
import Actividad4.ClasesEjercicio2.Alumnos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import com.thoughtworks.xstream.XStream;

public class Ejercicio2 {

    public static void main(String[] args) {
        Alumnos alumnos = null;
        FileInputStream input = null;
        try {
            input = new FileInputStream("Alumnos.xml");
        } catch (FileNotFoundException ex) {
            System.err.println("Fichero XML no encontrado");
        }
        XStream xStream = new XStream();
        xStream.alias("alumnos", Alumnos.class);
        xStream.alias("alumno", Alumno.class);
        xStream.addImplicitCollection(Alumnos.class, "listaAlumnos", Alumno.class);
        if (input != null) {
            alumnos = (Alumnos) xStream.fromXML(input);
        }
        alumnos.listarAlumnos();
        System.out.println("Nota media: "+alumnos.notaMedia());
    }
}
