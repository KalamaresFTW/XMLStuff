/*
 */
package Extra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author pcostoubi
 */
public class DocumentCreator {

    private static int count = 0;
    private String nombre;
    private String cargo;
    private String direccion;
    private double aumento;
    private char separador;

    public DocumentCreator(String nombre, String cargo, String direccion, double aumento, char separador) {
        count++;
        this.nombre = nombre;
        this.cargo = cargo;
        this.direccion = direccion;
        this.aumento = aumento;
        this.separador = separador;

    }

    public void createDocument() {
        try {
            File plantilla = new File("Plantilla.txt");
            if (!plantilla.exists()) {
                throw new FileNotFoundException("No existe la plantilla");
            }
            BufferedReader r = new BufferedReader(new FileReader(plantilla));
            BufferedWriter w = new BufferedWriter(new FileWriter(new File("Carta-" + count + ".txt")));

            String linea = r.readLine();
            while (linea != null) {
                System.out.println(linea);
                w.write(reemplazo(linea));
                w.write(System.lineSeparator());
                linea = r.readLine();
            }

            w.close();
            r.close();
        } catch (IOException ex) {
            System.err.println("Error de I/O");
        }
    }

    @Override
    public String toString() {
        return "DocumentCreator{" + "nombre=" + nombre + ", cargo=" + cargo + ", direccion=" + direccion + ", aumento=" + aumento + ", separador=" + separador + '}';
    }

    private String reemplazo(String linea) {
        String replaceAll = linea.replaceAll(separador + "Nombre" + separador, linea);
        return replaceAll;
    }
}
