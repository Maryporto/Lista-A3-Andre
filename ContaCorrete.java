public class ContaCorrente {
    private double saldo;

    public ContaCorrente(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double quantia) {
        if (quantia > 0) {
            saldo += quantia;
        }
    }

    public boolean sacar(double quantia) {
        double taxa = quantia * 0.005;
        if (quantia + taxa <= saldo) {
            saldo -= (quantia + taxa);
            return true;
        } else {
            return false;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public static void main(String[] args) {
       
        ContaCorrente conta1 = new ContaCorrente(1000.0);
        System.out.println("Saldo inicial (Conta Corrente): " + conta1.getSaldo());

        conta1.depositar(500.0);
        System.out.println("Após depósito de 500 (Conta Corrente): " + conta1.getSaldo());

        boolean saque1 = conta1.sacar(200.0);
        System.out.println("Tentativa de saque de 200 (Conta Corrente): " + (saque1 ? "Sucesso" : "Falhou"));
        System.out.println("Saldo após saque de 200 (Conta Corrente): " + conta1.getSaldo());

        ContaCorrenteEspecial conta2 = new ContaCorrenteEspecial(1000.0);
        System.out.println("\nSaldo inicial (Conta Corrente Especial): " + conta2.getSaldo());

        conta2.depositar(500.0);
        System.out.println("Após depósito de 500 (Conta Corrente Especial): " + conta2.getSaldo());

        boolean saque2 = conta2.sacar(200.0);
        System.out.println("Tentativa de saque de 200 (Conta Corrente Especial): " + (saque2 ? "Sucesso" : "Falhou"));
        System.out.println("Saldo após saque de 200 (Conta Corrente Especial): " + conta2.getSaldo());
    }
}

class ContaCorrenteEspecial extends ContaCorrente {

    public ContaCorrenteEspecial(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public boolean sacar(double quantia) {
        double taxa = quantia * 0.001;
        if (quantia + taxa <= getSaldo()) {
        
            depositar(-(quantia + taxa));
            return true;
        } else {
            return false;
        }
    }
}
