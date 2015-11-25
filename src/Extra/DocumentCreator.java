/*
 */
package Extra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author pcostoubi
 */
public class DocumentCreator {

    private static int count = 0;
    private final String nombre;
    private final String cargo;
    private final String direccion;
    private final double aumento;
    private final char separador;

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

    private String reemplazo(String linea) {
        if (linea.contains("%Nombre%")) {
            return linea.replaceAll("%Nombre%", this.nombre);
        } else {
            if (linea.contains("%Cargo%")) {
                return linea.replaceAll("%Cargo%", this.cargo);
            } else {
                if (linea.contains("%Direccion%")) {
                    return linea.replaceAll("%Direccion%", this.direccion);
                } else {
                    if (linea.contains("%Aumento%")) {
                        return linea.replaceAll("%Aumento%", String.valueOf(this.aumento));
                    } else {
                        return linea;
                    }
                }
            }
        }
    }
}
