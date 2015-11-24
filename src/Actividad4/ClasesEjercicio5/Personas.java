package Actividad4.ClasesEjercicio5;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Personas")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Personas {

    private ArrayList<Persona> listaPersonas;

    public Personas() {
        this.listaPersonas = new ArrayList<>();
    }

    public Personas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    @XmlElements({
        @XmlElement(name = "Estudiante", type = Estudiante.class),
        @XmlElement(name = "Trabajador", type = Trabajador.class)
    })
    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public void addPersona(Persona p) {
        if (p != null) {
            this.listaPersonas.add(p);
        }
    }
}
