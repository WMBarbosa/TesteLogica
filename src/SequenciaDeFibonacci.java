import java.util.ArrayList;
import java.util.Scanner;

public class SequenciaDeFibonacci {

    public static void main(String[] args) {

    // Irá obter o número informado pelo usuário por meio do scanner
        Scanner leitura = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int numero = leitura.nextInt();

    // Calculará a sequência de Fibonacci até o número informado
        ArrayList<Integer> fibonacci = calcularSequenciaFibonacci(numero);

    // Verificação de número para ver se pertence à sequência de Fibonacci
        if (isInFibonacciSequence(numero, fibonacci)) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
        }
    }

    // Função para calcular a sequência de Fibonacci até o número informado
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

    // Função para verificar se um número pertence à sequência de Fibonacci
    public static boolean isInFibonacciSequence(int numero, ArrayList<Integer> fibonacci) {
        return fibonacci.contains(numero);
    }
}

