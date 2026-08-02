public class Main {
    public static void main(String[] args) {
        String nomeProduto = "Notebook";
        double preco = 3500.00;
        int estoque = 5;
        boolean disponivel = estoque > 0;

        System.out.println("=== Catálogo - Estruturas Básicas ===");
        System.out.println("Produto: " + nomeProduto);
        System.out.println("Preço original: R$ " + preco);
        System.out.println("Estoque: " + estoque);

        if (disponivel) {
            System.out.println("Status: disponível para venda");
        } else {
            System.out.println("Status: produto indisponível");
        }

        double precoFinal = aplicarDesconto(preco, 10);
        System.out.println("Preço com desconto de 10%: R$ " + precoFinal);

        System.out.println("\nSimulação de baixa no estoque:");
        for (int unidade = 1; unidade <= estoque; unidade++) {
            System.out.println("Venda simulada da unidade " + unidade);
        }
    }

    public static double aplicarDesconto(double preco, double percentual) {
        return preco - (preco * percentual / 100);
    }
}
