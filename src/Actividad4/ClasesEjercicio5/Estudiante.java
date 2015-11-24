package Actividad4.ClasesEjercicio5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Estudiante extends Persona {

    @XmlElement(name = "Universidad")
    private String universidad;
    @XmlElement(name = "Carrera")
    private String carrera;

    public Estudiante() {
    }

    public Estudiante(String nombre, int edad, Informacion informacion, String universidad, String carrera) {
        super(nombre, edad, informacion);
        this.universidad = universidad;
        this.carrera = carrera;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return super.toString() + "Estudiante{" + "universidad=" + universidad + ", carrera=" + carrera + '}';
    }
}
