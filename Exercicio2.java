package testeEstagio.src.main.java.testeEstagio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> fibonacci = new ArrayList<Integer>();

        int soma = 0;
        fibonacci.add(0);
        fibonacci.add(1);


        int n = sc.nextInt();
        while (fibonacci.size() < n) {
            soma = fibonacci.get(fibonacci.size()-1) + fibonacci.get(fibonacci.size()-2);
            fibonacci.add(soma);
        }

        if (fibonacci.contains(n)){
            System.out.println("O numero pertence a sequencia");
        }else{
            System.out.println("O numero não pertence a sequencia");
        }


        sc.close();
    }
}
