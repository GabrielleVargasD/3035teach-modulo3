import java.util.Scanner;

public class Menu {
    private Scanner teclado = new Scanner(System.in);
    public int mostrarMenu(){
        System.out.println("Olá, bem vindo ao Jogo de Adivinhação!\n" +
                "Escolha uma das opções a seguir: \n" +
                "(1) Iniciar Novo Jogo \n" +
                "(2) Ver Regras \n" +
                "(3) Ver Histórico de Pontuações \n" +
                "(4) Sair \n");

        int escolha = teclado.nextInt();
        return escolha;
    }

    public void mostrarRegras(){
        System.out.println(
                "\n===== REGRAS DO JOGO =====\n" +
                        "O computador irá gerar um número e você deverá tentar adivinhá-lo.\n" +
                        "Antes de começar, escolha um dos três níveis de dificuldade:\n\n" +

                        "Fácil:\n" +
                        "- Número entre 1 e 50\n" +
                        "- 10 tentativas\n" +
                        "- Pontuação base: 100 pontos\n\n" +

                        "Médio:\n" +
                        "- Número entre 1 e 100\n" +
                        "- 7 tentativas\n" +
                        "- Pontuação base: 200 pontos\n\n" +

                        "Difícil:\n" +
                        "- Número entre 1 e 200\n" +
                        "- 5 tentativas\n" +
                        "- Pontuação base: 300 pontos\n\n" +

                        "A cada tentativa utilizada, pontos são descontados.\n" +
                        "Você também recebe 50 pontos para cada tentativa não utilizada.\n" +
                        "As 10 últimas pontuações serão armazenadas no histórico.\n"
        );
    }
}
