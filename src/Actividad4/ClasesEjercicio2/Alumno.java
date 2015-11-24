/*
 */
package Actividad4.ClasesEjercicio2;

/**
 *
 * @author pcostoubi
 */
public class Alumno {

    private String nome;
    private int nota;

    public Alumno(String nombre, int nota) {
        this.nome = nombre;
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + this.nome + " - Nota: " + this.nota;
    }
}
