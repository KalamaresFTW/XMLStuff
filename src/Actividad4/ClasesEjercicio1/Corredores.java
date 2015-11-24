package Actividad4.ClasesEjercicio1;

import java.util.ArrayList;
import java.util.List;

public class Corredores {

    private List<Corredor> listaCorredores;

    public Corredores() {
        listaCorredores = new ArrayList<>();
    }

    public Corredores(List<Corredor> corredores) {
        this.listaCorredores = corredores;
    }

    public List<Corredor> getListaCorredores() {
        return listaCorredores;
    }

    public void setListaCorredores(List<Corredor> listaCorredores) {
        this.listaCorredores = listaCorredores;
    }

    public void addCorredor(Corredor c) {
        listaCorredores.add(c);
    }

    public Corredor getCorredor(int i) {
        Corredor c = listaCorredores.get(i);
        if (c != null) {
            return c;
        } else {
            return null;
        }
    }

    public void listarCorredores() {
        if (!listaCorredores.isEmpty()) {
            for (Corredor corredor : listaCorredores) {
                System.out.println(corredor);
            }
        } else {
            System.out.println("No hay corredores en la lista");
        }
    }
}
