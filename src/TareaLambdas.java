import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TareaLambdas {
    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<String> remover = new ArrayList<>();
        ArrayList<String> palabras = new ArrayList<>();
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
        char letra = 'n';
        int tamanoCadena = 5;
        int factor = 5;
        multiplicador(numeros, factor);
        filtroSelectivo(remover, letra, tamanoCadena);
        conversorMayuscula(palabras);
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

    public static ArrayList conversorMayuscula(ArrayList<String> palabras){
        // Muestra la cadena original antes de modificarla
        System.out.println("Palabras para transformar a mayusculas: " + palabras);
        ArrayList<String> nuevo = palabras.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toCollection(ArrayList :: new));
        System.out.println("Palabras en mayusculas: " + nuevo);
        return nuevo;
    }
}