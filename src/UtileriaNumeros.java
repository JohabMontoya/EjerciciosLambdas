import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class UtileriaNumeros {
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

    public static HashSet<Integer> cuadradosUnicos (ArrayList<Integer> numeros){

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

}
