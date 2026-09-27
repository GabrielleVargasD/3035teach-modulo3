public class Historico {
    int[] pontuacoes = new int[10];
    String[] dificuldades = new String[10];
    int quantidade = 0;

    public void adicionarPontuacao(int pontuacao, String dificuldade){

        if (quantidade < 10) {
            pontuacoes[quantidade] = pontuacao;
            dificuldades[quantidade] = dificuldade;

            quantidade++;
        } else {
            for (int i = 0; i < 9; i++) {
                pontuacoes[i] = pontuacoes[i + 1];
                dificuldades[i] = dificuldades[i + 1];
            }
            pontuacoes[9] = pontuacao;
            dificuldades[9] = dificuldade;
        }
    }

    public void mostrarHistorico(){
        if (quantidade == 0) {
            System.out.println("Sem histórico de pontuações.\n");
            return;
        }

        for (int i = 0; i < quantidade; i++){
            System.out.println((i+1) + " lugar:\n" +
                    "Pontuação: " + pontuacoes[i] + "\n" +
                    "Dificuldade: " + dificuldades[i] + "\n");
        }
    }

}
