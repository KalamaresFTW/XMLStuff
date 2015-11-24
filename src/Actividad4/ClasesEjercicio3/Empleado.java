package Actividad4.ClasesEjercicio3;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = {"dni", "nombre", "edad"})
public class Empleado {
    
    private String dni;
    private String nombre;
    private int edad;
    
    public Empleado() {
    }

    public Empleado(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    @XmlElement
    public String getDni() {
        return dni;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    @XmlElement
    public int getEdad() {
        return edad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "DNI: " + this.dni + " - Nombre: " + this.nombre + " - Edad: " + this.edad;
    }
}
