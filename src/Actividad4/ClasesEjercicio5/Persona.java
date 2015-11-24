package Actividad4.ClasesEjercicio5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Estudiante.class, Trabajador.class})
public abstract class Persona {

    @XmlElement(name = "Nombre")
    private String nombre;
    @XmlElement(name = "Edad")
    private int edad;
    @XmlElement(name = "Informacion")
    private Informacion informacion;

    public Persona() {
    }

    public Persona(String nombre, int edad, Informacion informacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.informacion = informacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Informacion getInformacion() {
        return informacion;
    }

    public void setInformacion(Informacion informacion) {
        this.informacion = informacion;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", informacion=" + informacion + '}';
    }
}
