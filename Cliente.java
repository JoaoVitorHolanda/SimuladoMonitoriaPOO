
public class Cliente extends Pessoa {
    private String endereco;
    private int pontosFidelidade;
    private String cep;


    public Cliente(String nome, String cpf, String email, String endereco) {
        super(nome, cpf, email);
        this.endereco = endereco;
        this.pontosFidelidade = 0;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getPontosFidelidade() {
        return pontosFidelidade;
    }
    
    public String getCep() {
    return cep;
}

public void setCep(String cep) {
    this.cep = cep;
}

    public void adicionarPontos(int pontos) {
        if (pontos > 0) {
            pontosFidelidade += pontos;
        }
    }
}
