import java.util.Scanner;

public class CaixaSupermercado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean caixaAberto = true;

        while (caixaAberto) {
            System.out.println("Novo cliente");
            double totalCompra = 0.0;
            boolean maisItens = true;

            while (maisItens) {
                System.out.print("Digite o preço do item: ");
                double precoItem = scanner.nextDouble();
                totalCompra += precoItem;
                System.out.print("Há mais itens a serem processados? (sim/não): ");
                String resposta = scanner.next().trim().toLowerCase();
                if (!resposta.equals("s")) {
                    maisItens = false;
                }
            }

            System.out.printf("Total da compra: R$ %.2f%n", totalCompra);
            System.out.print("Deseja fechar o caixa? (sim/não): ");
            String respostaCaixa = scanner.next().trim().toLowerCase();
            if (respostaCaixa.equals("sim")) {
                caixaAberto = false;
            }
        }

        System.out.println("Caixa fechado.");
        scanner.close();
    }
}
