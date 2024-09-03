import java.util.ArrayList;
import java.util.Scanner;

public class SequenciaDeFibonacci {

    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int numero = leitura.nextInt();


        ArrayList<Integer> fibonacci = calcularSequenciaFibonacci(numero);


        if (isInFibonacciSequence(numero, fibonacci)) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
        }
    }


    public static ArrayList<Integer> calcularSequenciaFibonacci(int numero) {
        ArrayList<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(0);
        fibonacci.add(1);

        int i = 2;
        while (true) {
            int proximoNumero = fibonacci.get(i - 1) + fibonacci.get(i - 2);
            if (proximoNumero <= numero) {
                fibonacci.add(proximoNumero);
                i++;
            } else {
                break;
            }
        }
        return fibonacci;
    }

    public static boolean isInFibonacciSequence(int numero, ArrayList<Integer> fibonacci) {
        return fibonacci.contains(numero);
    }
}

