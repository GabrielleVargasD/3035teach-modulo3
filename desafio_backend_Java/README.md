# Jogo de Adivinhação — Java

## Enunciado

**O projeto consiste no desenvolvimento de um Jogo de Adivinhação em Java, executado através do console. O jogador deve tentar descobrir um número gerado aleatoriamente pelo computador, podendo escolher entre três níveis de dificuldade.**

**Cada nível possui uma quantidade diferente de tentativas, limite máximo para o número secreto e pontuação base. O jogo também possui um sistema de pontuação baseado na quantidade de tentativas utilizadas, um histórico das últimas partidas, um sistema de dicas e um sistema de recordes por dificuldade.**

**O objetivo principal da atividade é colocar em prática conceitos de lógica de programação, estruturas de repetição e seleção, arrays, métodos e interação com o usuário através do console.**

### Ferramentas utilizadas

* Java
* IntelliJ IDEA
* GitHub

---

## 1ª etapa: Compreendendo o projeto e organizando os passos necessários

**Antes de começar a programação, o projeto foi dividido em partes menores para facilitar a organização e o desenvolvimento.**

**Primeiramente, foram identificadas as principais funcionalidades solicitadas no enunciado:**

1. **Criar um menu principal;**
2. **Permitir a escolha do nível de dificuldade;**
3. **Gerar um número secreto aleatório;**
4. **Controlar as tentativas do jogador;**
5. **Informar se o palpite é maior ou menor que o número secreto;**
6. **Calcular a pontuação final;**
7. **Armazenar as pontuações no histórico;**
8. **Permitir a visualização das regras e do histórico;**
9. **Manter o menu funcionando até que o jogador escolha sair;**
10. **Adicionar um sistema de dicas;**
11. **Adicionar um sistema de recordes por dificuldade.**

**Para organizar melhor o código, as responsabilidades foram separadas em quatro classes:**

* **`Main` — responsável por iniciar o programa e controlar o menu principal;**
* **`Menu` — responsável pela exibição do menu, das regras e do menu de dicas;**
* **`Jogo` — responsável pela lógica das partidas, dificuldades, tentativas, dicas e pontuação;**
* **`Historico` — responsável por armazenar e exibir as últimas pontuações e os recordes.**

**Também foram utilizados arrays para armazenar as configurações dos níveis de dificuldade:**

| Dificuldade | Limite | Tentativas | Pontuação base |
| ----------- | ------ | ---------- | -------------- |
| Fácil       | 1–50   | 10         | 100            |
| Médio       | 1–100  | 7          | 200            |
| Difícil     | 1–200  | 5          | 300            |

**Essa organização foi escolhida para manter cada parte do programa com uma responsabilidade específica, facilitando a compreensão e a manutenção do código.**

---

## 2ª etapa: Colocando em prática a resolução da tarefa

**Após definir a estrutura do projeto, as funcionalidades foram implementadas gradualmente.**

### Menu principal

**Foi criado um menu com quatro opções:**

* **Iniciar um novo jogo;**
* **Ver as regras;**
* **Ver o histórico de pontuações;**
* **Sair.**

**O menu é executado dentro de um loop, permanecendo ativo até que o jogador escolha a opção de saída.**

### Níveis de dificuldade

**Na classe `Jogo`, foram utilizados arrays para armazenar as configurações de cada dificuldade:**

```java
int[] limites = {50, 100, 200};
int[] tentativas = {10, 7, 5};
int[] pontuacoes = {100, 200, 300};
String[] nomesDificuldades = {"Fácil", "Médio", "Difícil"};
```

**Dessa forma, a configuração utilizada durante a partida é selecionada de acordo com a dificuldade escolhida pelo jogador.**

### Geração do número secreto

**O número secreto é gerado utilizando a classe `Random`, respeitando o limite definido pela dificuldade escolhida.**

```java
return random.nextInt(limite) + 1;
```

### Tentativas

**Durante a partida, um loop controla a quantidade máxima de tentativas permitidas.**

**A cada palpite, o programa verifica se:**

* **O jogador acertou o número;**
* **O palpite é menor que o número secreto;**
* **O palpite é maior que o número secreto.**

**Quando o jogador acerta, a quantidade de tentativas utilizadas é retornada para ser utilizada no cálculo da pontuação.**

### Sistema de pontuação

**A pontuação é calculada considerando:**

* **A pontuação base da dificuldade;**
* **Um desconto de 5 pontos por tentativa utilizada;**
* **Um bônus de 50 pontos por tentativa não utilizada;**
* **Os pontos gastos na utilização das dicas.**

**Caso o jogador não consiga acertar o número secreto dentro do limite de tentativas, a pontuação da partida é `0`.**

**A fórmula utilizada é:**

```text
Pontuação final =
pontuação base
- (tentativas utilizadas × 5)
+ (tentativas restantes × 50)
- (pontos gastos com dicas)
```

### Sistema de dicas

**Foi desenvolvido um sistema de dicas que pode ser acessado durante a partida através do palpite `0`. A utilização de uma dica não consome uma tentativa do jogador.**

**O sistema possui três tipos de dicas:**

1. **Dica de paridade — desconto de 10 pontos**

   * Informa se o número secreto é par ou ímpar.

2. **Dica de intervalo — desconto de 20 pontos**

   * Informa se o número secreto está na metade inferior ou superior do intervalo da dificuldade.

3. **Dica de proximidade — desconto de 15 pontos**

   * Permite que o jogador informe um número para verificar se está próximo ou distante do número secreto.

**Os pontos utilizados nas dicas são armazenados durante a partida e descontados da pontuação final.**

### Histórico de pontuações

**Foi criado um sistema para armazenar as 10 últimas pontuações, juntamente com a dificuldade em que cada partida foi realizada.**

**Quando o histórico ainda possui espaço, uma nova partida é adicionada ao final. Quando as 10 posições já estão ocupadas, os registros mais antigos são deslocados e a nova pontuação é adicionada ao final.**

**Dessa forma, o sistema mantém sempre as 10 partidas mais recentes.**

### Sistema de recordes

**Foi desenvolvido um sistema para armazenar o melhor resultado obtido em cada nível de dificuldade.**

**Para isso, foi utilizado um array com três posições:**

```java
int[] recordes = {0, 0, 0};
```

**Cada posição representa uma dificuldade:**

* **`recordes[0]` — Fácil;**
* **`recordes[1]` — Médio;**
* **`recordes[2]` — Difícil.**

**Ao finalizar uma partida, a pontuação é comparada com o recorde atual da dificuldade. Caso a nova pontuação seja maior, o recorde é atualizado.**

**Os recordes podem ser visualizados junto ao histórico de pontuações.**

---

## 3ª etapa: Resultados e conclusões

**Ao final da implementação, foi desenvolvido um jogo de adivinhação funcional executado através do console.**

**O projeto atende às principais funcionalidades propostas no enunciado, incluindo:**

* **Menu principal;**
* **Três níveis de dificuldade;**
* **Geração aleatória do número secreto;**
* **Controle de tentativas;**
* **Mensagens indicando se o palpite é maior ou menor;**
* **Sistema de pontuação;**
* **Histórico das últimas 10 partidas;**
* **Armazenamento da pontuação junto à dificuldade;**
* **Visualização das regras;**
* **Sistema de dicas;**
* **Desconto de pontos pela utilização das dicas;**
* **Sistema de recordes por dificuldade.**

**Durante o desenvolvimento, foram realizados testes com diferentes situações, como acerto na primeira tentativa, acerto após várias tentativas, erro em todas as tentativas, diferentes níveis de dificuldade, utilização das diferentes dicas, preenchimento do histórico com várias partidas e atualização dos recordes.**

**Também foi testado o comportamento do sistema quando ainda não existem partidas registradas, verificando que o histórico permanece vazio e os recordes começam com `0` pontos.**

**O desenvolvimento permitiu praticar conceitos fundamentais de Java e lógica de programação, principalmente o uso de arrays, loops, estruturas condicionais, métodos, geração de números aleatórios, interação com o usuário e organização do código em diferentes classes.**

**Além das funcionalidades principais, os recursos adicionais de dicas e recordes também foram implementados, ampliando as funcionalidades do jogo e permitindo uma aplicação maior dos conceitos trabalhados durante a atividade.**
