package carros;

import java.util.ArrayList;
import java.util.List;

/**
 * @author devMahaw
 */

public abstract class Carros<T extends Carros<T>> {

    public abstract void acelerar();

    public static void main(String[] args) {
        List<Carros<?>> listaCarros = new ArrayList<>();

        listaCarros.add(new Ford());
        listaCarros.add(new Honda());
        listaCarros.add(new Peugeot());

        for (Carros<?> carro : listaCarros) {
            carro.acelerar();
        }
    }
}
