public class Historico {
    int[] pontuacoes = new int[10];
    String[] dificuldades = new String[10];
    int quantidade = 0;
    int[] recordes = {0, 0, 0};

    public void adicionarPontuacao(int pontuacao, String dificuldade){
        int indiceDificuldade;

        if (dificuldade.equals("Fácil")) {
            indiceDificuldade = 0;
        } else if (dificuldade.equals("Médio")) {
            indiceDificuldade = 1;
        } else {
            indiceDificuldade = 2;
        }

        if (pontuacao > recordes[indiceDificuldade]) {
            recordes[indiceDificuldade] = pontuacao;
        }

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

    public void mostrarRecordes() {
        System.out.println("===== RECORDES =====");
        System.out.println("Fácil: " + recordes[0] + " pontos");
        System.out.println("Médio: " + recordes[1] + " pontos");
        System.out.println("Difícil: " + recordes[2] + " pontos\n");
    }
}
