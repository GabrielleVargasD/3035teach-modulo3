import java.util.Scanner;
import java.util.Random;

public class Jogo {
    Scanner teclado = new Scanner(System.in);
    Random random = new Random();
    Historico historico;

    public Jogo(Historico historico) {
        this.historico = historico;
    }

    int[] limites = {50, 100, 200};
    int[] tentativas = {10, 7, 5};
    int[] pontuacoes = {100, 200, 300};
    String[] nomesDificuldades = {"Fácil", "Médio", "Difícil"};

    public void iniciarJogo(){

        int nivel = escolherDificuldade();
        String dificuldade = nomesDificuldades[nivel];
        int limite = limites[nivel];
        int numeroSecreto= gerarNumero(limite);

        int tentativasUsadas = fazerTentativas(numeroSecreto, tentativas[nivel]);

        int pontuacaoFinal;

        if (tentativasUsadas > 0) {
            pontuacaoFinal = calcularPontuacao(
                    pontuacoes[nivel],
                    tentativas[nivel],
                    tentativasUsadas
            );
        } else {
            pontuacaoFinal = 0;
        }

        System.out.println("Pontuação final: " + pontuacaoFinal + "\n");
        historico.adicionarPontuacao(pontuacaoFinal, dificuldade);

    }

    public int escolherDificuldade() {
        int nivel;
        do {
            System.out.println("Escolha a dificuldade:");
            System.out.println("(1) Fácil");
            System.out.println("(2) Médio");
            System.out.println("(3) Difícil");

            nivel = teclado.nextInt();

            if (nivel < 1 || nivel > 3) {
                System.out.println("Opção inválida!");
            }

        } while (nivel < 1 || nivel > 3);

        return nivel - 1; //Já q o índice do array começa com 0 e as opções em 1, a gente diminui pra poder pegar o valor certo
    }

    public int gerarNumero(int limite) {

        return random.nextInt(limite) + 1; //add +1 pra começarmos com 1 e n 0
    }

    public int fazerTentativas(int numeroSecreto, int quantTentativas) {

        for (int i = 0; i < quantTentativas; i++) {
            System.out.println("Digite o seu palpite: ");
            int palpite = teclado.nextInt();

            if (palpite == numeroSecreto) {
                System.out.println("\nParabéns! Você acertou!");
                return i + 1;
            } else if (palpite < numeroSecreto) {
                System.out.println("O número secreto é MAIOR!\n");
            } else {
                System.out.println("O número secreto é MENOR!\n");
            }

            if (i == quantTentativas - 1) {
                System.out.println("Suas tentativas acabaram :(");
            }
        }

        return 0; //se não acertou nada, vai retornar 0
    }

    public int calcularPontuacao(int pontuacaoBase, int quantTentativas, int tentativasUsadas) {
        int tentativasRestantes = quantTentativas - tentativasUsadas;
        int desconto = tentativasUsadas * 5;
        int bonus = tentativasRestantes * 50;
        int pontuacaoFinal = pontuacaoBase - desconto + bonus;

        return pontuacaoFinal;
    }

    }
