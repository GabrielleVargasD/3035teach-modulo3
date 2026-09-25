import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
        System.out.println("Exercicio 1\n" + "--------------------------");
        System.out.println("Informe 3 números inteiros: ");
        int a = teclado.nextInt();
        int b = teclado.nextInt();
        int c = teclado.nextInt();
        if ((a+b)<c){
            System.out.println("A soma de " + a + " + " + b + " é menor que " + c );
        }


        System.out.println("\nExercicio 2\n" + "--------------------------");
        System.out.println("Informe seu nome, sexo(F ou M) e estado civil seguindo a ordem");
        String nome = teclado.next();
        String sexo = teclado.next();
        String estado_civil = teclado.next();

        if (sexo.equalsIgnoreCase("F") && estado_civil.equalsIgnoreCase("CASADA")){
            System.out.println("Informe o tempo de casada: ");
            int tempo = teclado.nextInt();
        }

        System.out.println("\nExercicio 3\n" + "--------------------------");
        System.out.println("Informe um número: ");
        int n1 = teclado.nextInt();

        if (n1%2 == 0){
            System.out.println("Número par");
        } else {
            System.out.println("Número impar");
        }

        System.out.println("\nExercicio 4\n" + "--------------------------");
        System.out.println("Informe dois números: ");
        int a2 = teclado.nextInt();
        int b2 = teclado.nextInt();

        if (a2 == b2){
            int c2 = a2 + b2;
            System.out.println(c2);
        } else{
            int c2 = a2 * b2;
            System.out.println(c2);
        }

        System.out.println("\nExercicio 5\n" + "--------------------------");
        System.out.println("informe um número: ");
        int num = teclado.nextInt();

        if (num >= 1){
            int duplo = num * 2;
            System.out.println(duplo);
        } else if (num <= -1) {
            int triplo = num * 3;
            System.out.println(triplo);
        }

        System.out.println("\nExercicio 6\n" + "--------------------------");
        System.out.println("Informe um número: ");
        int n3 = teclado.nextInt();

        if (n3%2 == 0){
            int soma = n3 + 5;
            System.out.println(soma);
        } else {
            int soma = n3 + 8;
            System.out.println(soma);
        }

        System.out.println("\nExercicio 7\n" + "--------------------------");
        System.out.println("informe três numeros: ");
        int x = teclado.nextInt();
        int y = teclado.nextInt();
        int z = teclado.nextInt();

        if (x > y && x > z) {
            if (y > z) {
                System.out.println(x + " " + y + " " + z);
            } else {
                System.out.println(x + " " + z + " " + y);
            }
        } else if (y > x && y > z) {
            if (x > z) {
                System.out.println(y + " " + x + " " + z);
            } else {
                System.out.println(y + " " + z + " " + x);
            }
        } else {
            if (x > y) {
                System.out.println(z + " " + x + " " + y);
            } else {
                System.out.println(z + " " + y + " " + x);
            }
        }

        }
    }