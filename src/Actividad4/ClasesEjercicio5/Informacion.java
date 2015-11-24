package Actividad4.ClasesEjercicio5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;

@XmlAccessorType(XmlAccessType.FIELD)
public class Informacion {

    @XmlElement(name = "Dirección")
    private Direccion direccion;
    @XmlElement(name = "Telefonos")
    @XmlList
    private String[] telefonos;

    public Informacion() {
    }

    public Informacion(Direccion direccion, String[] telefonos) {
        this.direccion = direccion;
        this.telefonos = telefonos;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String[] getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String[] telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public String toString() {
        return "Informacion{" + "direccion=" + direccion + ", telefonos=" + telefonos + '}';
    }
}
