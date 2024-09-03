import java.util.HashMap;
import java.util.Map;

public class Faturamento {

    public static void main(String[] args) {
        // Faturamento mensal por estado
        Map<String, Double> faturamento = new HashMap<>();
        faturamento.put("SP", 67836.43);
        faturamento.put("RJ", 36678.66);
        faturamento.put("MG", 29229.88);
        faturamento.put("ES", 27165.48);
        faturamento.put("Outros", 19849.53);

        // Cálculo do valor total
        double totalFaturamento = 0;
        for (double valor : faturamento.values()) {
            totalFaturamento += valor;
        }

        // Cálculo do percentual de representação e exibição dos resultados
        System.out.println("Percentual de representação por estado:");
        for (Map.Entry<String, Double> entry : faturamento.entrySet()) {
            String estado = entry.getKey();
            double valor = entry.getValue();
            double percentual = (valor / totalFaturamento) * 100;
            System.out.printf("%s: %.2f%%%n", estado, percentual);
        }
    }
}
