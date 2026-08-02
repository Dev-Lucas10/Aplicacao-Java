public class App {
    public static void main(String[] args) {
        Produto produto = new Produto(1L, "Mouse sem fio", 120.00, 3);

        System.out.println("=== Catálogo - Classes e Objetos ===");
        System.out.println(produto);

        double precoPromocional = produto.calcularPrecoComDesconto(15);
        System.out.println("Preço com 15% de desconto: R$ " + precoPromocional);

        if (produto.estaDisponivel()) {
            produto.venderUmaUnidade();
            System.out.println("Venda realizada com sucesso.");
        }

        System.out.println("Estoque atualizado: " + produto.getEstoque());
    }
}
