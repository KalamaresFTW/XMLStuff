package Actividad4.ClasesEjercicio4;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Bloque {

    @XmlAttribute(name = "sesions")
    private int sesions;
    @XmlAttribute(name = "num")
    private int num;
    @XmlElement(name = "Titulo")
    private String titulo;
    @XmlElement(name = "Descricion")
    private String descricion;

    public Bloque() {
    }

    public Bloque(int sesions, int num, String titulo, String descricion) {
        this.sesions = sesions;
        this.num = num;
        this.titulo = titulo;
        this.descricion = descricion;
    }

    public int getSesions() {
        return sesions;
    }

    public void setSesions(int sesions) {
        this.sesions = sesions;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    @Override
    public String toString() {
        return "Sesións: " + this.sesions + " - Num: " + this.sesions + " - Título: " + this.titulo + " - Descricion: " + this.descricion;
    }
}
