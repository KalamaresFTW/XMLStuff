package Actividad4.ClasesEjercicio2;

import java.util.ArrayList;

public class Alumnos {

    private ArrayList<Alumno> listaAlumnos;

    public Alumnos() {
        this.listaAlumnos = new ArrayList<>();
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void addAlumno(Alumno alumno) {
        this.listaAlumnos.add(alumno);
    }

    public void listarAlumnos() {
        for (Alumno alumno : listaAlumnos) {
            System.out.println(alumno);
        }
    }

    public double notaMedia() {
        double media = 0;
        for (Alumno alumno : listaAlumnos) {
            media += alumno.getNota();
        }
        return media / listaAlumnos.size();
    }
}
