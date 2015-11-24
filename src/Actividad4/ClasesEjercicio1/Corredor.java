package Actividad4.ClasesEjercicio1;

public class Corredor {

    private int dorsal;
    private String nombre;
    private long tiempo;

    public Corredor() {
    }

    public Corredor(int dorsal, String nombre, long tiempo) {
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Dorsal: " + this.dorsal + " - Nombre: " + this.nombre + " - Tiempo: " + this.tiempo;
    }
}
