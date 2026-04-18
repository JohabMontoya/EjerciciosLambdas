import claseTodosLosMetodos.TareaLambdas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Pruebas {
    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        int factor = 5;

        ArrayList<String> remover = new ArrayList<>();

        remover.add("Número");
        remover.add("Nombre");
        remover.add("Hola");
        remover.add("Cirujano");
        char letra = 'n';
        int tamanoCadena = 5;

        ArrayList<String> palabras = new ArrayList<>();

        palabras.add("Misterio");
        palabras.add("hermano");
        palabras.add("mono");

        ArrayList<Integer> duplicados = new ArrayList<>();

        duplicados.add(8);
        duplicados.add(8);
        duplicados.add(2);
        duplicados.add(2);
        duplicados.add(2);
        duplicados.add(5);
        duplicados.add(5);
        duplicados.add(-6);
        HashMap<String, Double> lista = new HashMap<>();

        lista.put("Cheeseburger", 10.00);
        lista.put("Boneless", 6.00);
        lista.put("Papas a la francesa", 3.00);
        lista.put("Combo", 15.00);

        ArrayList<String> frecuencia = new ArrayList<>();
        frecuencia.add("Abrir");
        frecuencia.add("Estatua");
        frecuencia.add("Abrir");
        frecuencia.add("Abrir");

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Abrir", 3);
        map.put("Estatua", 1);
        map.put("Hola", 2);
        int frec = 2;

        String frase = "Yo soy un robotin, soy un robotin que le encanta bailar";
        int N = 5;

        int NTope = 2; // máximo permitido

        UtileriaNumeros.multiplicador(numeros, factor);
        UtileriaCadenas.filtroSelectivo(remover, letra, tamanoCadena);
        UtileriaCadenas.conversorMayuscula(palabras);
        UtileriaNumeros.cuadradosUnicos(duplicados);
        HashMap<String, Integer> mapa = UtileriaCadenas.mapaLongitudes(palabras);
        UtileriaNumeros.modificadorInventario(lista);
        HashMap<String, Integer> contador = UtileriaCadenas.contadorFrecuencias(frecuencia);
        ArrayList<String> resultado = UtileriaCadenas.clasificadorPalabras(map, frec);
        System.out.println("Mapa original: " + map);
        System.out.println("Palabras con frecuencia menor a " + frecuencia + ": " + resultado);
        HashSet<String> result = UtileriaCadenas.deduplicacionPalabras(frase, N);
        System.out.println("Resultado: " + result);
        UtileriaCadenas.topeFrecuencias(contador, NTope);
    }
}
