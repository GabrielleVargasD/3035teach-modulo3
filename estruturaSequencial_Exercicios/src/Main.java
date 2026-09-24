import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Exercicio 1\n" + "--------------------------");
        System.out.println("Olá, informe o seu nome:");
        String nome = teclado.next();
        System.out.println("Agora informe a sua idade:");
        int idade = teclado.nextInt();

        System.out.printf("Nome: %s\n", nome);
        System.out.printf("Idade: %d", idade);

        System.out.println("\n\nExercicio 2\n" + "--------------------------");
        System.out.println("Olá, informe o primeiro número");
        double n1 = teclado.nextDouble();
        System.out.println("Informe o segundo número");
        double n2 = teclado.nextDouble();
        double calculo = n1 * n2;
        System.out.printf("Resutado: %.2f", calculo);


        System.out.println("\n\nExercicio 3\n" + "--------------------------");
        System.out.println("Olá, informe o seu salário:");
        double sal = teclado.nextDouble();
        System.out.printf("Salario: R$ %.2f", sal);
    }
}