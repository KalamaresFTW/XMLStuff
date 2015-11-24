package Actividad4.ClasesEjercicio5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Trabajador extends Persona {

    @XmlElement(name = "Empresa")
    private String empresa;
    @XmlElement(name = "Puesto")
    private String puesto;
    @XmlElement(name = "Sueldo")
    private double sueldo;

    public Trabajador() {
    }

    public Trabajador(String nombre, int edad, Informacion informacion, String empresa, String puesto, double sueldo) {
        super(nombre, edad, informacion);
        this.empresa = empresa;
        this.puesto = puesto;
        this.sueldo = sueldo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return super.toString() + "Trabajador{" + "empresa=" + empresa + ", puesto=" + puesto + ", sueldo=" + sueldo + '}';
    }
}
