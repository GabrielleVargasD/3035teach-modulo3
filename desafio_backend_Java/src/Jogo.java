import java.util.Scanner;
import java.util.Random;

public class Jogo {
    Scanner teclado = new Scanner(System.in);
    Random random = new Random();
    Historico historico;
    Menu menu;
    int pontosDicas;

    public Jogo(Historico historico, Menu menu) {
        this.historico = historico;
        this.menu = menu;
    }

    int[] limites = {50, 100, 200};
    int[] tentativas = {10, 7, 5};
    int[] pontuacoes = {100, 200, 300};
    String[] nomesDificuldades = {"Fácil", "Médio", "Difícil"};

    public void iniciarJogo(){
        pontosDicas = 0;

        int nivel = escolherDificuldade();
        String dificuldade = nomesDificuldades[nivel];
        int limite = limites[nivel];
        int numeroSecreto= gerarNumero(limite);

        int tentativasUsadas = fazerTentativas(numeroSecreto, tentativas[nivel], limite);

        int pontuacaoFinal;

        if (tentativasUsadas > 0) {
            pontuacaoFinal = calcularPontuacao(
                    pontuacoes[nivel],
                    tentativas[nivel],
                    tentativasUsadas,
                    pontosDicas
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

    public int fazerTentativas(int numeroSecreto, int quantTentativas, int limite) {
        int tentativasUsadas = 0;

        while (tentativasUsadas < quantTentativas) {
            System.out.println("Digite seu palpite:\n" +
                    "(0 para pedir uma dica)");

            int palpite = teclado.nextInt();

            if (palpite == 0) {
                int dicaEscolha = menu.mostrarMenuDicas();

                switch (dicaEscolha) {
                    case 1:
                        if (numeroSecreto % 2 == 0) {
                            System.out.println("O número secreto é PAR!");
                        } else {
                            System.out.println("O número secreto é IMPAR!");
                        }
                        pontosDicas += 10;
                        break;

                    case 2:
                        if (numeroSecreto <= limite / 2) {
                            System.out.println("O número secreto está na METADE INFERIOR!");
                        } else {
                            System.out.println("O número secreto está na METADE SUPERIOR!");
                        }
                        pontosDicas += 20;
                        break;

                    case 3:
                        System.out.println("Digite um palpite para verificar a proximidade:");
                        int palpiteDica = teclado.nextInt();

                        int diferenca = Math.abs(numeroSecreto - palpiteDica); //Math.abs = numero n fica negativo

                        if (diferenca <= 10) {
                            System.out.println("Você está QUENTE!");
                        } else {
                            System.out.println("Você está FRIO!");
                        }
                        pontosDicas += 15;
                        break;

                    case 4:
                        System.out.println("Saindo do menu dicas...");
                        break;

                    default:
                        System.out.println("Opção inválida");
                        break;
                }

                continue; //Volta para o começo do while e pede o palpite de novo
            }

            tentativasUsadas++;

            if (palpite == numeroSecreto) {
                System.out.println("\nParabéns! Você acertou!");
                return tentativasUsadas;
            } else if (palpite < numeroSecreto) {
                System.out.println("O número secreto é MAIOR!\n");
            } else {
                System.out.println("O número secreto é MENOR!\n");
            }

            if (tentativasUsadas == quantTentativas) {
                System.out.println("Suas tentativas acabaram :(");
            }
        }

        return 0;
    }

    public int calcularPontuacao(int pontuacaoBase, int quantTentativas, int tentativasUsadas, int pontosDicas) {
        int tentativasRestantes = quantTentativas - tentativasUsadas;
        int desconto = tentativasUsadas * 5;
        int bonus = tentativasRestantes * 50;
        int pontuacaoFinal = pontuacaoBase - desconto + bonus - pontosDicas;

        return pontuacaoFinal;
    }

    }
