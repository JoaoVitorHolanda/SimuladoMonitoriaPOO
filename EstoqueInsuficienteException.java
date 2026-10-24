
public class EstoqueInsuficienteException extends Exception {
    public EstoqueInsuficienteException(String nome, int quantidade) {
        super("Estoque insuficiente para " + nome
              + ". Disponível: " + quantidade);
    }
}
