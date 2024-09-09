package testeEstagio.src.main.java.testeEstagio;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Exercicio3 {
    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
            File inputFile = new File("C:\\Users\\vinic\\IdeaProjects\\testeEstagio2\\testeEstagio\\src\\main\\java\\testeEstagio\\exemplo.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("valor");
            List<Double> valores = new ArrayList<>();
            Double soma = 0.0;
            Double menor = Double.MAX_VALUE;
            Double maior = Double.MIN_VALUE;

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    try {
                        double valor = Double.parseDouble(eElement.getTextContent().trim());
                        valores.add(valor);
                        soma += valor;

                        if (valor < menor) {
                            menor = valor;
                        }

                        if (valor > maior) {
                            maior = valor;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido " + eElement.getTextContent());
                    }
                }
            }

            Double media = soma / valores.size();
            int diasQueAMediaFoiMaior = 0;

            for (Double valor : valores) {
                if (valor > media) {
                    diasQueAMediaFoiMaior++;
                }
            }

            System.out.printf("O menor valor de faturamento ocorrido em um dia do mês: %.2f%n", menor);
            System.out.printf("O maior valor de faturamento ocorrido em um dia do mês: %.2f%n", maior);
            System.out.println("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal: " + diasQueAMediaFoiMaior);

        } catch (Exception e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
    }
}
