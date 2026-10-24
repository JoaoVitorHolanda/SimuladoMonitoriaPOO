
public class Main {
    public static void main(String[] args) {
        ClienteVip cliente = new ClienteVip(
            "Ana", "111", "ana@mail.com",
            "Rua A", 0.10
        );

        cliente.setCep("60000-000");

        ProdutoFisico teclado = new ProdutoFisico(
            "F01", "Teclado", 100.0, 5, 0.8
        );

        ProdutoDigital ebook = new ProdutoDigital(
            "D01", "E-book Java", 50.0, 999, 12
        );

        Assinatura streaming = new Assinatura(
            "S01", "Streaming", 20.0, 999, 6
        );

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        try {
            carrinho.adicionar(teclado, 1);
            carrinho.adicionar(ebook, 1);
            carrinho.adicionar(streaming, 1);
        } catch (EstoqueInsuficienteException e) {
            System.out.println(e.getMessage());
            return;
        }

        Pedido pedido = new Pedido(cliente, carrinho);

        System.out.println("=== Tentativa com Pix ===");
        pedido.finalizar(new PagamentoPix());

        System.out.println("=== Tentativa com cartão ===");
        pedido.finalizar(new PagamentoCartao(6, 50.0));

        System.out.println(
            "Pontos de fidelidade: " +
            cliente.getPontosFidelidade()
        );
    }
}
