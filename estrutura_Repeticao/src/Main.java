import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Exercicio 1\n" + "--------------------------");
        for (int i =0; i <= 100; i++){
            if (i%2==0){
                System.out.println(i);
            }
        }

        System.out.println("\nExercicio 2\n" + "--------------------------");
        Random random = new Random();
        int numbSecreto = random.nextInt(5);
        int numUser = 0;

        do {
            System.out.println("Informe um número de 0 a 5: ");
            numUser = teclado.nextInt();
            if (numbSecreto == numUser){
                System.out.println("Parabéns! Você achou o número");
            } else if (numUser > numbSecreto) {
                System.out.println("O número secreto é MENOR");
            } else if (numUser < numbSecreto){
                System.out.println("O número secreto é MAIOR");
            }
        } while (numbSecreto != numUser);

        System.out.println("\nExercicio 3\n" + "--------------------------");
        System.out.println("Informe um número de 1 a 10: ");
        int numb = teclado.nextInt();
        for (int i = 1; i <= 10; i++){
            System.out.println(numb + " x " + i + " = " + (numb*i));
        }

        System.out.println("\nExercicio 4\n" + "--------------------------");
        int count = 0;
        for (int i= 1; i <= 5; i++){
            System.out.println("Informe a idade da pessoa " + i);
            int idade = teclado.nextInt();
            if (idade > 18){
                count++;
            }
        }
        System.out.println("O número de pessoas maiores de 18 anos é: " + count);

        System.out.println("\nExercicio 5\n" + "--------------------------");
        System.out.println("Informe um número: ");
        int number = teclado.nextInt();
        for(int i =0; i <= number; i++){
            if (i%2==0){
                System.out.println(i);
            }
        }
    }
}