import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.println("Bem vindo ao sistema de cadastro de pessoas Fisicas e Juridicas");

        Scanner leitor = new Scanner(System.in);

        String opcao ;

        do {
            System.out.println("Escolha uma opção:\n1 - Pessoa Física\n2 - Pessoa Jurídica\n0 - Sair");
        opcao = leitor.nextLine();

        switch (opcao){
            case "1":
            break;
            case "2":
                break;
            case "0":
                break;
            default:
                break;

        }

        }while(!opcao.equals("0"));
    }
}