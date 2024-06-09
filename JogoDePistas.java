import java.util.Scanner;

public class JogoDePistas {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Jogador 1, digite o nome do filme: ");
        String nomeFilme = scanner.nextLine().trim().toLowerCase();
        
        String[] pistas = new String[5];
        lerPistas(pistas, scanner);
        
        int tentativas = 5;
        int pontuacao = 0;
        boolean acertou = false;
        
        for (int i = 1; i <= tentativas; i++) {
            mostrarPistas(pistas, i);
            System.out.print("Jogador 2, qual é o filme? ");
            String palpite = scanner.nextLine().trim().toLowerCase();
            
            if (comparaFilme(nomeFilme, palpite)) {
                acertou = true;
                pontuacao = calcularPontuacao(i);
                break;
            } else {
                System.out.println("Errado. Tente novamente.");
            }
        }
        
        if (acertou) {
            System.out.println("Parabéns, você acertou o nome do filme!");
        } else {
            System.out.println("Você usou todas as suas tentativas. O filme era: " + nomeFilme);
        }
        
        System.out.println("Pontuação do Jogador 2: " + pontuacao);
        
        scanner.close();
    }
    
    public static void lerPistas(String[] pistas, Scanner scanner) {
        for (int i = 0; i < pistas.length; i++) {
            System.out.print("Jogador 1, digite a pista " + (i + 1) + ": ");
            pistas[i] = scanner.nextLine();
        }
    }
    
    public static void mostrarPistas(String[] pistas, int numPistas) {
        System.out.println("Pistas:");
        for (int i = 0; i < numPistas; i++) {
            System.out.println((i + 1) + ". " + pistas[i]);
        }
    }
    
    public static boolean comparaFilme(String nomeFilme, String palpite) {
        return nomeFilme.equalsIgnoreCase(palpite);
    }
    
    public static int calcularPontuacao(int numPistasUsadas) {
        switch (numPistasUsadas) {
            case 1:
                return 100;
            case 2:
                return 60;
            case 3:
                return 40;
            case 4:
                return 20;
            case 5:
                return 10;
            default:
                return 0;
        }
    }
}
