import java.util.ArrayList;

public class TareaLambdas {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        int factor = 5;
        multiplicador(numeros, factor);
    }

    public static void multiplicador(ArrayList<Integer> numeros, int factor){
       numeros.replaceAll(n -> n * factor);
       System.out.println(numeros);
    }


}
