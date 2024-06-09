import java.util.Scanner;

public class NumeroSucessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();

        int sucessor = numero + 1;

        System.out.println("O sucessor do número " + numero + " é: " + sucessor);

        scanner.close();
    }
}
