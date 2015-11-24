package Actividad4.ClasesEjercicio4;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Modulo")
@XmlType(propOrder = {"nome", "listaContidos"})
public class Modulo {

    @XmlElement(name = "Nome")
    private String nome;
    @XmlElementWrapper(name = "Contidos")
    @XmlElement(name = "Bloque")
    private ArrayList<Bloque> listaContidos;

    public Modulo() {
    }

    public Modulo(String nome) {
        this.nome = nome;
        this.listaContidos = new ArrayList<>();
    }

    public Modulo(String nome, ArrayList<Bloque> contidos) {
        this.nome = nome;
        this.listaContidos = contidos;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Bloque> getContidos() {
        return listaContidos;
    }

    public void addContido(Bloque contido) {
        if (listaContidos != null) {
            this.listaContidos.add(contido);
        } else {
            System.err.println("Lista no inicializada");
        }
    }

    public void listarContidos() {
        System.out.println(this);
        System.out.println("Lista de contidos: ");
        for (Bloque bloque : listaContidos) {
            System.out.println("\t" + bloque);
        }
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome;
    }
}
