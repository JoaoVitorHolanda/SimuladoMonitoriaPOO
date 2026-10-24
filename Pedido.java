
public class Pedido {
    private Cliente cliente;
    private CarrinhoDeCompras carrinho;

    public Pedido(Cliente cliente, CarrinhoDeCompras carrinho) {
        this.cliente = cliente;
        this.carrinho = carrinho;
    }

    public void finalizar(Pagamento pagamento) {
        try {
            double subtotal = carrinho.calcularTotal()
                    + carrinho.calcularFreteTotal(cliente.getCep());

            if (cliente instanceof ClienteVip) {
                ClienteVip vip = (ClienteVip) cliente;
                subtotal *= (1 - vip.getPercentualDesconto());
            }

            double valorFinal = pagamento.calcularValorFinal(subtotal);

            pagamento.exibirComprovante(subtotal);

            int pontos = (int) (valorFinal / 10);
            cliente.adicionarPontos(pontos);

        } catch (PagamentoRecusadoException e) {
            System.out.println("Pagamento recusado");
        } finally {
            System.out.println("Pedido encerrado");
        }
    }
}
