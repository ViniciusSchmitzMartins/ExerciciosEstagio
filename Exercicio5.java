package testeEstagio.src.main.java.testeEstagio;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma palavra: ");
        String palavra = sc.nextLine();

        char[] letras = palavra.toCharArray();

        for (int i = letras.length - 1; i >= 0 ; i--) {
            System.out.print(letras[i]);
        }
    }
}
