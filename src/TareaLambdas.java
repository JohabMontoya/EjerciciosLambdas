import java.util.ArrayList;

public class TareaLambdas {
    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<String> remover = new ArrayList<>();
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        remover.add("Número");
        remover.add("Nombre");
        remover.add("Hola");
        String letra = "n";
        int factor = 5;
        multiplicador(numeros, factor);
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

    public static void filtroSelectivo(ArrayList<String> remover, String letra){
        remover.removeIf(n -> n.startsWith(letra));
    }




}
