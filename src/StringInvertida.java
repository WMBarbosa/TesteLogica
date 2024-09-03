import java.util.Scanner;

public class StringInvertida {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string: ");
        String texto = scanner.nextLine();

        String textoInvertido = inverterString(texto);

        // Resultado
        System.out.println("String invertida: " + textoInvertido);
        }

        // Função para inverter a string
        public static String inverterString(String string) {
            int tamanho = string.length();
            StringBuilder stringInvertida = new StringBuilder();

            // Iterar sobre a string de trás para frente e construir a string invertida
            for (int i = tamanho - 1; i >= 0; i--) {
                stringInvertida.append(string.charAt(i));
            }

            return stringInvertida.toString();
        }
    }
