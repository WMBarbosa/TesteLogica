import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FaturamentoDistribuidora {

    public static void main(String[] args) {
        String filePath = "C:\\temp\\dados.json";
        List<Double> valores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            String jsonString = sb.toString();
            jsonString = jsonString.substring(1, jsonString.length() - 1);
            String[] jsonObjects = jsonString.split("\\},\\{");

            for (String jsonObject : jsonObjects) {
                jsonObject = jsonObject.replace("{", "").replace("}", "");
                String[] keyValuePairs = jsonObject.split(",");
                for (String pair : keyValuePairs) {
                    String[] entry = pair.split(":");
                    String key = entry[0].trim().replace("\"", "");
                    String value = entry[1].trim();

                    if ("valor".equals(key)) {
                        double valor = Double.parseDouble(value);
                        if (valor > 0) {
                            valores.add(valor);
                        }
                    }
                }
            }

            if (!valores.isEmpty()) {
                double menorValor = Collections.min(valores);
                double maiorValor = Collections.max(valores);

                double soma = valores.stream().mapToDouble(Double::doubleValue).sum();
                double mediaMensal = soma / valores.size();

                long diasAcimaDaMedia = valores.stream().filter(v -> v > mediaMensal).count();

                System.out.println("Menor valor de faturamento ocorrido em um dia do mês: " + menorValor);
                System.out.println("Maior valor de faturamento ocorrido em um dia do mês: " + maiorValor);
                System.out.println("Número de dias com faturamento acima da média mensal: " + diasAcimaDaMedia);
            } else {
                System.out.println("Não há dados de faturamento disponíveis.");
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}