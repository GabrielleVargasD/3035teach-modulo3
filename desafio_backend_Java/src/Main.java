public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Jogo jogo = new Jogo();

        int opcao = 0;

        while (opcao != 4) {
            opcao = menu.mostrarMenu();

            switch (opcao){
                case 1:
                    System.out.println("Iniciando o jogo...\n" + "=======================\n");
                    jogo.iniciarJogo();
                    break;
                case 2:
                    menu.mostrarRegras();
                    break;

                case 3:
                    System.out.println("Mostrando histórico");
                    break;

                case 4:
                    System.out.println("Saindo do jogo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        }
    }
}