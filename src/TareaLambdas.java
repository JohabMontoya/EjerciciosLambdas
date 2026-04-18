import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class TareaLambdas {
    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<String> remover = new ArrayList<>();
        ArrayList<String> palabras = new ArrayList<>();
        ArrayList<Integer> duplicados = new ArrayList<>();

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

        char letra = 'n';
        int tamanoCadena = 5;
        int factor = 5;

        multiplicador(numeros, factor);
        filtroSelectivo(remover, letra, tamanoCadena);
        conversorMayuscula(palabras);
        cuadrosUnicos(duplicados);
        HashMap<String, Integer> mapa = mapaLongitudes(palabras);
    }

    // Multiplica cada elemento de la lista por un factor dado
    public static void multiplicador(ArrayList<Integer> numeros, int factor){
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

    public static HashSet<Integer> cuadrosUnicos (ArrayList<Integer> numeros){

        System.out.println("Valores antes de modificarlos: " + numeros);
        // Crea un HashSet con los resultados del stream
        HashSet<Integer> duplicados = new HashSet<>(
        numeros.stream()
                // Filtra únicamente los números pares
                .filter(n -> n %2 == 0)
                // Convierte cada número par a su cuadrado
                .map(n -> n * n)
                // Recolecta los resultados en un Set
                .collect(Collectors.toSet()));
        // Imprime la lista original
        System.out.println("Valores después de modificarlos: " + duplicados );
        // Regresa la cadena modificada.
        return duplicados;
    }

    public static HashMap<String, Integer> mapaLongitudes(ArrayList<String> clave){
        System.out.println("Estas son las palabras que se usarán como clave "  + clave);
        HashMap<String, Integer> palabraClave = clave.stream()
                .collect(Collectors.toMap(
                        s -> s,
                        s -> s.length(),
                        (a, b) -> a, HashMap::new));
        System.out.println("Estas son las palabras con su respectiva clave: " + palabraClave);
        return palabraClave;
    }


}