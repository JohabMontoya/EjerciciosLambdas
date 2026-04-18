import java.util.*;
import java.util.stream.Collectors;

public class UtileriaCadenas {

    public static void filtroSelectivo(ArrayList<String> remover, char letra, int tamanoCadena){
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

    public static ArrayList<String> conversorMayuscula(ArrayList<String> palabras){
        // Si la lista viene nula, regresamos una lista vacía
        if (palabras == null) return new ArrayList<>();

        // Muestra la cadena original antes de modificarla
        System.out.println("Palabras para transformar a mayusculas: " + palabras);

        // Creamos una nueva lista transformando cada elemento con stream + map
        ArrayList<String> nuevo = palabras.stream()
                .map(s -> (s == null) ? null : s.toUpperCase())
                .collect(Collectors.toCollection(ArrayList :: new));

        // Imprimo la lista modificada
        System.out.println("Palabras en mayúsculas: " + nuevo);

        // Regresamos el resultado
        return nuevo;
    }

    public static HashMap<String, Integer> mapaLongitudes(ArrayList<String> clave){
        // Muestra la lista original
        System.out.println("Estas son las palabras que se usarán como clave "  + clave);

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
