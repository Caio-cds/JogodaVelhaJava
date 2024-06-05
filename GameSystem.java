import java.util.Scanner;

public class GameSystem {
    Scanner input = new Scanner(System.in);

    public GameSystem(){
        inicioJogo();
    }
    
    public void exibeTabela(char[][] v){
        System.out.println("  |1||2||3|");
        for (int i=0; i<3; i++){
            System.out.print((i+1) + "| ");
            for (int j=0; j<3; j++){
                System.out.print(v[i][j] + "  ");
            }
            System.out.println("");
        }
    }
    
    public char[][] inicioPadrao(){
        char [][] gameStart = new char[3][3];
        //Inicio do jogo zerado (espacos vazios)
        System.out.println("Inicio do jogo:");
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                gameStart[i][j] = "-".charAt(0);
            }
        }
        return gameStart;
    }

    public void marcaTabela(char[][] v, int linha, int coluna, char playerChar){
        //!sobreposição
        int valid = 0;
        do{
            if(v[linha][coluna] == "-".charAt(0)){
                valid = 1;
            }
            else{
                System.out.println("Espaco ocupado! Insira uma coordenada valida!");
                
                System.out.print("Linha: ");
                linha = input.nextInt() - 1;
                
                System.out.print("coluna: ");
                coluna = input.nextInt() - 1;
            }
        } while(valid != 1);

        v[linha][coluna] = playerChar;
    }
    
    public void inicioJogo(){
        char[][] v = inicioPadrao();
        exibeTabela(v);
        boolean continuar = true;
        char x = "X".charAt(0);
        char o = "O".charAt(0);
        
        while(continuar){    
            System.out.println("Jogador 1, informe a posicao do X: ");
            
            System.out.print("linha: ");
            int linhaP1 = input.nextInt() - 1;
            
            System.out.print("coluna: ");
            int colunaP1 = input.nextInt() - 1;
            
            marcaTabela(v, linhaP1, colunaP1, x);
            exibeTabela(v);
            
            continuar = resultado(v, continuar);
            if(continuar == false){
                break;
            }
            
            System.out.println("Jogador 2, informe a posicao do O: ");
            
            System.out.print("linha: ");
            int linhaP2 = input.nextInt() - 1;
            
            System.out.print("coluna: ");
            int colunaP2 = input.nextInt() - 1;
            
            marcaTabela(v, linhaP2, colunaP2, o);
            exibeTabela(v);
            
            continuar = resultado(v, continuar);
        }
        //Continue?
        System.out.println("~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=");
        System.out.println("Deseja continuar? (0 = nao/1 = sim)");
        int answer = input.nextInt();
        System.out.println("~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=");

        if(answer == 1){
            inicioJogo();
        }
        else{
            System.out.println("GameOver");
        }
    }
    
    public boolean resultado(char[][] v, boolean c){
        c = true;
        char x = "X".charAt(0);
        char o = "O".charAt(0);

        //Primeira linha completa
        if(v[0][0] == v[0][1] && v[0][0] == v[0][2]){
            if(v[0][0] == x){
                System.out.println("Jogador 1 venceu!!!");
                c = false;
            }
            if(v[0][0] == o){
                System.out.println("Jogador 2 venceu!!!");
                c = false;
            }
        }
        
        //Segunda linha completa
        if(v[1][0] == v[1][1] && v[1][0] == v[1][2]){
            if(v[1][0] == x){
                System.out.println("Jogador 1 venceu!!!");
                c = false;
            }
            if(v[1][0] == o){
                System.out.println("Jogador 2 venceu!!!");
                c = false;
            }
        }
        
        //terceira linha completa
        if(v[2][0] == v[2][1] && v[2][0] == v[2][2]){
            if(v[2][0] == x){
                System.out.println("Jogador 1 venceu!!!");
                c = false;
            }
            if(v[2][0] == o){
                System.out.println("Jogador 2 venceu!!!");
                c = false;
            }
        }
        
        //Primeira coluna completa
        if(v[0][0] == v[1][0] && v[0][0] == v[2][0]){
            if(v[0][0] == x){
                System.out.println("Jogador 1 venceu!!!");
                c = false;
            }
            if(v[0][0] == o){
                System.out.println("Jogador 2 venceu!!!");
                c = false;
            }
        }
        
        //Segunda coluna completa
        if(v[0][1] == v[1][1] && v[0][1] == v[2][1]){
            if(v[0][1] == x){
                System.out.println("Jogador 1 venceu!!!");
                c = false;
            }
            if(v[0][1] == o){
                System.out.println("Jogador 2 venceu!!!");
                c = false;
            }
        }
        
        //terceira coluna completa
        if(v[0][2] == v[1][2] && v[0][2] == v[2][2]){
            if(v[0][2] == x){
                System.out.println("Jogador 1 venceu!!!");
                c = false;
            }
            if(v[0][2] == o){
                System.out.println("Jogador 2 venceu!!!");
                c = false;
            }
        }
        
        //diagonal principal
        if(v[0][0] == v[1][1] && v[0][0] == v[2][2]){
            if(v[0][0] == x){
                System.out.println("Jogador 1 venceu!!!");
                c = false;
            }
            if(v[0][0] == o){
                System.out.println("Jogador 2 venceu!!!");
                c = false;
            }
        }
        
        //diagonal secundaria
        if(v[0][2] == v[1][1] && v[0][2] == v[2][0]){
            if(v[0][2] == x){
                System.out.println("Jogador 1 venceu!!!");
                c = false;
            }
            if(v[0][2] == o){
                System.out.println("Jogador 2 venceu!!!");
                c = false;
            }
        }
        
        //draw
        boolean draw = false;
        for(int i=0; i<v.length; i++){
            for(int j=0; j<v.length; j++){
                //se existe "-" então não há empate
                if(v[i][j] == "-".charAt(0)){
                    draw = false;
                    break;
                }
                if(i==v.length-1 && j==v.length-1){
                    /*Se c == false, alguém ja ganhou*/
                    if(c != false){
                        /*Se o for não é "quebrado" então tds espaços foram preenchidos
                        e, então, aconteceu o empate.*/
                        draw = true;
                        System.out.println("# Deu velha!!!");
                        c = !draw;
                    }
                }
            }
        }
        
        return c;
    }
}
