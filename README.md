# Pokemao
Este é um jogo de pokemão criado para a disciplina de mac0321, sobre programação orientada a objetos.

Os objetivos são:
Criar um runner que realize uma batalha pokemon seguindo as regras do jogo original;
Gerar um mapa que tenha batalhas aleatórias conforme o personagem anda, tendo a opção de capturar pokemons selvagens com uma pokebola.

As mains para esses dois objetivos podem ser encontradas, respectivamente, na classe Runner e na classe RunnerMapa.
As instruções para jogar são printadas na tela, e as regras de batalha são as seguintes:
O jogo é feito em rodadas, e a cada rodada cada treinador ou pokemon selvagem escolhe uma ação. As ações são FUGIR, TROCAR POKEMON, USAR ITEM e ATACAR, listadas em ordem de prioridade. Ou seja, se o treinador 1 escolhe ATACAR e o treinador 2 escolhe usar USAR ITEM, a ação do treinador 2 é resolvida primeiro. Em caso de empate, o treinador 1 vence (a ação do jogador resolve primeiro). O treinador que tiver todos os seus pokemons derrotados é derrotado.
No caso do mapa, há dois tipos de terreno: grama baixa e grama alta. Na grama baixa o jogador não encontra pokemons selvagens, enquanto na grama alta, há uma chance de ocorrer uma batalha. O oponente é um treinador, com o nome do pkemon selvagem, com apenas um pokemon, gerado aleatoriamente de uma lista, que não usa itens nem foge. As regras dessa batalha são as mesmas da explicada anteriormente, com a inclusão do item "pokesfera", que permite ao jogador capturar o pokemon selvagem, com as chances de captura aumentando linearmente conforme o pokemon selvagem perde vida.

Adicionalmente, foi adicionada uma interface gráfica, que pode ser acessada pela main da classe MapPanel, que utiliza das libraries JPanel, JFrame e JButton.
Nessa versão, apenas a parte do mapa é realizada no JPanel, assim que houver uma batalha, o Jpanel vai congelar, e o usuário deve usar o console para batalhar, pois não conseguimos esconder a tela durante a batalha. Assim que a batalha for concluída, o JPanel volta a funcionar normalmente.
