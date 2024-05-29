package generics;

/**
 * @author devMahaw
 */

import generics.fruta.Banana;
import generics.fruta.IFruta;
import generics.fruta.Maca;

import java.util.ArrayList;
import java.util.List;

public class ExemplosJavaGenerics {

    public static void main(String[] args) {
        List<String> lista = new ArrayList();
        lista.add("Marcelo");
        lista.add("Rodrigo");
        imprimir2(lista);

        List<Long> listaLong = new ArrayList();
        listaLong.add(1l);
        listaLong.add(2l);
        imprimir2(listaLong);

        System.out.println("------------------------------");

        String primeiroSt = pegarPrimeiroLista(lista);
        System.out.println(primeiroSt);

        Long primeiroSt1 = pegarPrimeiroLista(listaLong);
        System.out.println(primeiroSt1);

        Long primeiroSt2 = pegarPrimeiroListaLong(listaLong);
        System.out.println(primeiroSt2);

        imprimir3(listaLong);

        List<IFruta> frutas = new ArrayList();
        frutas.add(new Maca());
        frutas.add(new Banana());
        imprimirFrutas(frutas);
    }

    public static void imprimir(List<String> lista) {
        for (String st : lista) {
            System.out.println(st);
        }
    }

    public static void imprimir1(List<Long> lista) {
        for (Long st : lista) {
            System.out.println(st);
        }
    }

    public static <T> void imprimir2(List<T> lista) {
        for (T st : lista) {
            System.out.println(st);
        }
    }

    public static void imprimir3(List<?> lista) {
        for (Object st : lista) {
            System.out.println("Qualquer coisa" + st);
        }
    }

    public static <T> T pegarPrimeiroLista(List<T> lista) {
        return lista.get(0);
    }

    public static <T> Long pegarPrimeiroListaLong(List<Long> lista) {
        return lista.get(0);
    }

    public static void imprimirFrutas(List<? extends IFruta> lista) {
        for (IFruta fruta : lista) {
            System.out.println(fruta);
        }
    }
}
