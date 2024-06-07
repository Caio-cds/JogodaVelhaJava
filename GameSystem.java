import java.util.Scanner;

public class GameSystem {
    Scanner input = new Scanner(System.in);

    public GameSystem(){
        gameStart();
    }

    public char[][] standardStart(){
        //Inicio do jogo zerado (espacos vazios)
        char [][] gameStart = new char[3][3];
        System.out.println("Inicio do jogo:");

        for (int i=0; i<gameStart.length; i++){
            
            for (int j=0; j<gameStart.length; j++){
            
                gameStart[i][j] = '-';
            }
        }
        showTable(gameStart);
        return gameStart;
    }
    
    public void gameStart(){
        char[][] v = standardStart();
        boolean running = true;
        
        while(running){    
            
            for (int i=1; i<3; i++){
                //index 1 & 2 - Player1 & Player2
                System.out.printf("Jogador %d, informe a posicao do X: %n", i);
            
                //"-1" pois a tabela começa do 1 e o indice em 0
                System.out.print("linha: ");
                int line = input.nextInt() - 1;
            
                System.out.print("coluna: ");
                int column = input.nextInt() - 1;
                
                //Player 1
                if(i == 1){
                    tableMarker(v, line, column, 'X');
                }
                //Player 2
                else{
                    tableMarker(v, line, column, 'O');
                }

                showTable(v);
                running = resultado(v, running);

                //Caso o jogador 1 vença, impede continuação do for
                if(running == false){
                    break;
                }
            }
        }

        //Continue?
        restart();
    }

    public void showTable(char[][] v){
        System.out.println("  |1||2||3|");
        for (int i=0; i<v.length; i++){

            System.out.print((i+1) + "| ");
            
            for (int j=0; j<v.length; j++){

                System.out.print(v[i][j] + "  ");
            }

            System.out.println("");
        }
    }
    
    public void tableMarker(char[][] v, int line, int column, char playerChar){
        //!sobreposição
        int valid = 0;
        do{
            //Se a coordenada escolhida não for um espaço vazio ('-'),
            //significa que aquela coordenada já foi usada
            if(v[line][column] == '-'){
                valid = 1;
            }
            else{
                System.out.println("Espaco ocupado! Insira uma coordenada valida!");
                
                System.out.print("Linha: ");
                line = input.nextInt() - 1;
                
                System.out.print("coluna: ");
                column = input.nextInt() - 1;
            }
        } while(valid != 1);

        v[line][column] = playerChar;
    }
    
    public boolean resultado(char[][] v, boolean running){
        running = true;

        //Primeira linha completa
        if(v[0][0] == v[0][1] && v[0][0] == v[0][2]){
            if(v[0][0] == 'X'){
                System.out.println("Jogador 1 venceu!!!");
                running = false;
            }
            if(v[0][0] == 'O'){
                System.out.println("Jogador 2 venceu!!!");
                running = false;
            }
        }
        
        //Segunda linha completa
        if(v[1][0] == v[1][1] && v[1][0] == v[1][2]){
            if(v[1][0] == 'X'){
                System.out.println("Jogador 1 venceu!!!");
                running = false;
            }
            if(v[1][0] == 'O'){
                System.out.println("Jogador 2 venceu!!!");
                running = false;
            }
        }
        
        //terceira linha completa
        if(v[2][0] == v[2][1] && v[2][0] == v[2][2]){
            if(v[2][0] == 'X'){
                System.out.println("Jogador 1 venceu!!!");
                running = false;
            }
            if(v[2][0] == 'O'){
                System.out.println("Jogador 2 venceu!!!");
                running = false;
            }
        }
        
        //Primeira coluna completa
        if(v[0][0] == v[1][0] && v[0][0] == v[2][0]){
            if(v[0][0] == 'X'){
                System.out.println("Jogador 1 venceu!!!");
                running = false;
            }
            if(v[0][0] == 'O'){
                System.out.println("Jogador 2 venceu!!!");
                running = false;
            }
        }
        
        //Segunda coluna completa
        if(v[0][1] == v[1][1] && v[0][1] == v[2][1]){
            if(v[0][1] == 'X'){
                System.out.println("Jogador 1 venceu!!!");
                running = false;
            }
            if(v[0][1] == 'O'){
                System.out.println("Jogador 2 venceu!!!");
                running = false;
            }
        }
        
        //terceira coluna completa
        if(v[0][2] == v[1][2] && v[0][2] == v[2][2]){
            if(v[0][2] == 'X'){
                System.out.println("Jogador 1 venceu!!!");
                running = false;
            }
            if(v[0][2] == 'O'){
                System.out.println("Jogador 2 venceu!!!");
                running = false;
            }
        }
        
        //diagonal principal
        if(v[0][0] == v[1][1] && v[0][0] == v[2][2]){
            if(v[0][0] == 'X'){
                System.out.println("Jogador 1 venceu!!!");
                running = false;
            }
            if(v[0][0] == 'O'){
                System.out.println("Jogador 2 venceu!!!");
                running = false;
            }
        }
        
        //diagonal secundaria
        if(v[0][2] == v[1][1] && v[0][2] == v[2][0]){
            if(v[0][2] == 'X'){
                System.out.println("Jogador 1 venceu!!!");
                running = false;
            }
            if(v[0][2] == 'O'){
                System.out.println("Jogador 2 venceu!!!");
                running = false;
            }
        }
        
        //draw
        boolean draw = false;

        for(int i=0; i<v.length; i++){

            for(int j=0; j<v.length; j++){
                //se existe "-" então não há empate
                if(v[i][j] == '-'){
                    draw = false;
                    break;
                }
                else if(i==v.length-1 && j==v.length-1){
                    //Se continuar == false, alguém ja ganhou
                    if(running != false){
                        //Se o for anterior não é "quebrado" então tds espaços
                        //foram preenchidos e, então, aconteceu o empate.
                        draw = true;
                        System.out.println("# Deu velha!!!");
                        running = !draw;
                    }
                }
            }
        }
        
        return running;
    }
    //Restart?
    public void restart (){
        System.out.println("~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=");
        System.out.println("Deseja recomeçar o jogo? (0 = no/1 = yes)");
        int answer = input.nextInt();
        System.out.println("~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=");

        if(answer == 1){
            gameStart();
        }
        else{
            System.out.println("GameOver");
        }
    }
}