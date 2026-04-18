package claseTodosLosMetodos;

import java.util.*;
import java.util.stream.Collectors;

public class TareaLambdas {
    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<String> remover = new ArrayList<>();
        ArrayList<String> palabras = new ArrayList<>();
        ArrayList<Integer> duplicados = new ArrayList<>();
        HashMap<String, Double> lista = new HashMap<>();

        numeros.add(4);
        numeros.add(5);
        numeros.add(6);

        remover.add("Número");
        remover.add("Nombre");
        remover.add("Hola");
        remover.add("Cirujano");

        palabras.add("Misterio");
        palabras.add("hermano");
        palabras.add("mono");

        duplicados.add(8);
        duplicados.add(8);
        duplicados.add(2);
        duplicados.add(2);
        duplicados.add(2);
        duplicados.add(5);
        duplicados.add(5);
        duplicados.add(-6);

        lista.put("Cheeseburger", 10.00);
        lista.put("Boneless", 6.00);
        lista.put("Papas a la francesa", 3.00);
        lista.put("Combo", 15.00);

        char letra = 'n';
        int tamanoCadena = 5;
        int factor = 5;

        multiplicador(numeros, factor);
        filtroSelectivo(remover, letra, tamanoCadena);
        conversorMayuscula(palabras);
        cuadrosUnicos(duplicados);
        HashMap<String, Integer> mapa = mapaLongitudes(palabras);
        modificadorInventario(lista);
    }

    // Multiplica cada elemento de la lista por un factor dado
    public static void multiplicador(ArrayList<Integer> numeros, int factor) {
        // Imprime la lista original y el factor
        System.out.println("Esta es la lista sin modificar.");
        System.out.println(numeros);
        System.out.println("Este es el factor.");
        System.out.println(factor);

        // Recorre la lista y reemplaza cada número por su valor * factor
        numeros.replaceAll(n -> n * factor);

        // Imprime la lista ya modificada
        System.out.println("Esta es la lista modificada.");
        System.out.println(numeros);
    }

    public static void filtroSelectivo(ArrayList<String> remover, char letra, int tamanoCadena) {
        // Muestra qué criterios de eliminación se van a aplicar
        System.out.println("Se eliminaran palabras que empiecen por: '" + letra + "'. O tengan una longitud de: " + tamanoCadena);

        // Imprime la lista antes de filtrar
        System.out.println("Cadena original: " + remover);

        // Pasa la letra a minúsculas para comparar sin importar mayúsculas
        char l = Character.toLowerCase(letra);

        // Elimina si: empieza por la letra O si su longitud es menor a tamanoCadena
        remover.removeIf(s -> s.toLowerCase().startsWith(String.valueOf(l)) || s.length() < tamanoCadena);

        // Imprime la lista después de filtrar
        System.out.println("Cadena con la letra " + letra + " removida: " + remover);
    }

    public static ArrayList<String> conversorMayuscula(ArrayList<String> palabras) {
        // Si la lista viene nula, regresamos una lista vacía
        if (palabras == null) return new ArrayList<>();

        // Muestra la cadena original antes de modificarla
        System.out.println("Palabras para transformar a mayusculas: " + palabras);

        // Creamos una nueva lista transformando cada elemento con stream + map
        ArrayList<String> nuevo = palabras.stream()
                .map(s -> (s == null) ? null : s.toUpperCase())
                .collect(Collectors.toCollection(ArrayList::new));

        // Imprimo la lista modificada
        System.out.println("Palabras en mayúsculas: " + nuevo);

        // Regresamos el resultado
        return nuevo;
    }

    public static HashSet<Integer> cuadrosUnicos(ArrayList<Integer> numeros) {

        System.out.println("Valores antes de modificarlos: " + numeros);
        // Crea un HashSet con los resultados del stream
        HashSet<Integer> duplicados = new HashSet<>(
                numeros.stream()
                        // Filtra únicamente los números pares
                        .filter(n -> n % 2 == 0)
                        // Convierte cada número par a su cuadrado
                        .map(n -> n * n)
                        // Recolecta los resultados en un Set
                        .collect(Collectors.toSet()));
        // Imprime la lista original
        System.out.println("Valores después de modificarlos: " + duplicados);
        // Regresa la cadena modificada.
        return duplicados;
    }

    public static HashMap<String, Integer> mapaLongitudes(ArrayList<String> clave) {
        // Muestra la lista original
        System.out.println("Estas son las palabras que se usarán como clave " + clave);

        // Crea un HashMap donde: palabra -> longitud
        HashMap<String, Integer> palabraClave = clave.stream()
                .collect(Collectors.toMap(
                        s -> s, // clave
                        s -> s.length(), // valor
                        (a, b) -> a, HashMap::new)); // si se repite la palabra, se queda con la primera

        // Muestra el mapa resultante
        System.out.println("Estas son las palabras con su respectiva clave: " + palabraClave);
        return palabraClave;
    }

    public static void modificadorInventario(HashMap<String, Double> productos) {
        // Descuento fijo del 10%
        double descuento = 0.10;
        System.out.println();
        // Recorre cada entrada del mapa:
        productos.forEach((producto, precio) -> {
            // Calcula el precio con descuento
            double precioConDescuento = precio * (1 - descuento);

            // Imprime el producto y su precio ya con el 10% aplicado
            System.out.println(producto + " -> $" + precioConDescuento + " (10% off)");
        });
    }
    public static HashMap<String, Integer> contadorFrecuencias(ArrayList<String> palabras){
        // Mapa: palabra -> cantidad de veces que aparece
        HashMap<String, Integer> frecuencia = new HashMap<>();

        // Recorre la lista y suma 1 por cada palabra (si no existe, empieza en 1)
        palabras.forEach(p -> {
            if(p != null)frecuencia.merge(p, 1, (p1, p2) -> p1 + p2);
        });
        // Imprime el resultado
        System.out.println("La frecuencia de las palabras es:  " + frecuencia);
        return frecuencia;
    }

    public static ArrayList<String> clasificadorPalabras(HashMap<String, Integer> map, int frecuencia) {

        // Stream sobre las entradas del mapa
        List<String> listaFiltrada = map.entrySet().stream()
                // Mantiene solo las palabras con frecuencia
                .filter(p -> p.getValue() < frecuencia)
                // Convierte cada entrada a la palabra
                .map(p -> p.getKey())
                // Guarda el resultado en una lista
                .collect(Collectors.toList());

        // Convertimos la lista a ArrayList para cumplir con el tipo de retorno
        ArrayList<String> resultado = new ArrayList<>(listaFiltrada);

        return resultado;
    }

    public static HashSet<String> deduplicacionPalabras(String frase, int N) {
        // mostrar la frase original
        System.out.println("\n Deduplicación de Palabras");
        System.out.println("\nFrase original: " + frase);

        // Manejo de frase nula o vacía
        if (frase == null || frase.isBlank()) {
            System.out.println("Palabras únicas filtradas: []");
            return new HashSet<>();
        }

        // Divide la frase ignorando signos de puntuación (separa por "no letras/números")
        String[] palabras = frase.split("[^\\p{L}\\p{N}]+");

        // Stream del array -> filtra por tamaño -> minúsculas -> HashSet (sin repetidos)
        HashSet<String> resultado = Arrays.stream(palabras)
                .filter(p -> !p.isBlank())
                .filter(p -> p.length() < N)
                .map(String::toLowerCase)
                .collect(Collectors.toCollection(HashSet::new));

        return resultado;
    }

    public static void topeFrecuencias(HashMap<String, Integer> map, int N) {
        System.out.println("\nTop Frecuencias");
        System.out.println("\nMapa antes: " + map);

        // Si el mapa es null, no hay nada que modificar
        if (map == null) return;

        // Modifica el mapa original: si frecuencia > N, se fija en N; si no, se deja igual
        map.replaceAll((palabra, frecuencia) -> (frecuencia > N) ? N : frecuencia);

        System.out.println("Mapa después: " + map);
    }
}