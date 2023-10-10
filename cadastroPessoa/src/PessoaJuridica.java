
import java.time.format.DateTimeFormatter;

public class PessoaJuridica extends Pessoa {
    public String cnpj;
    public float rendimento;

    public Endereco endereco;

    public float calcularImposto() {
        if (rendimento <= 3000) {
            return rendimento * 0.1f;
        } else if (rendimento <= 6000) {
            return rendimento * 0.15f;
        } else if (rendimento <= 10000) {
            return rendimento * 0.2f;
        } else {
            return rendimento * 0.25f;
        }
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Rendimento: " + rendimento);
        System.out.println("Imposto a ser pago: " + calcularImposto());
    }
}

