package Actividad4.ClasesEjercicio3;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlRootElement(name = "empresa")
@XmlType(propOrder = {"cif", "nombre", "listaEmpleados"})
public class Empresa {

    private String cif;
    private String nombre;
    private ArrayList<Empleado> listaEmpleados;

    public Empresa() {
    }

    public Empresa(String cif, String nombre) {
        this.cif = cif;
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<>();
    }

    @XmlAttribute
    public String getCif() {
        return cif;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void addEmpleado(Empleado empleado) {
        this.listaEmpleados.add(empleado);
    }

    @XmlElementWrapper(name = "empleados")
    @XmlElement(name = "empleado")
    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void listarEmpleados() {
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado.toString());
        }
    }
}
