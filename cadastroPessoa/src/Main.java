import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        ArrayList<PessoaFisica> listaPf = new ArrayList<>();



        System.out.println("Bem vindo ao sistema de cadastro de pessoas Fisicas e Juridicas");

        Scanner leitor = new Scanner(System.in);

        String opcao ;

        do {
            System.out.println("Escolha uma opção:\n1 - Pessoa Física\n2 - Pessoa Jurídica\n0 - Sair");
        opcao = leitor.nextLine();

        switch (opcao){
            case "1":
                String opcaoPf;

                do {
                    System.out.println("Escolha uma opção:\n1 - Cadastrar PF\n2 - Listar PF\n0 - Voltar");
                    opcaoPf = leitor.nextLine();

                    switch (opcaoPf){
                        case "1":
                            PessoaFisica novaPF = new PessoaFisica();
                            Endereco novoEndPf = new Endereco();

                            System.out.println("Digite o nome do: ");
                            novaPF.nome = leitor.nextLine();

                            System.out.println("Digite o cpf: ");
                            novaPF.cpf = leitor.nextLine();

                            System.out.println("Digite o rendimento: ");
                            String rendimentoStr = leitor.nextLine();
                            novaPF.rendimento = Float.parseFloat(rendimentoStr);

//                            System.out.println("Digite a data de nascimento: (dd/mm/aaaa) ");
//                            novaPF.dataNascimento = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                            System.out.println("Digite a data de nascimento (dd/mm/aaaa): ");
                            String dataNascimentoStr = leitor.nextLine();
                            novaPF.dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                            System.out.println("Digite o logradouro");
                            novoEndPf.logradouro = leitor.nextLine();

                            System.out.println("Digite o número: ");
                            novoEndPf.numero = leitor.nextInt();

                            System.out.println("Este endereço é comercial? S/N:");
                            String endCom = leitor.nextLine();

                            if (endCom.equals("S")){
                                novoEndPf.endComercial=true;
                            }else {
                                novoEndPf.endComercial=false;
                            }

                            novaPF.endereco = novoEndPf;
                            listaPf.add(novaPF);

                            System.out.println("Cadastro realizado com sucesso!");


                            break;
                        case "2":
                           
                            if (listaPf.size() > 0){
                                for (PessoaFisica cadaPf : listaPf) {
                                    System.out.println("Nome: \n"+cadaPf.nome+" CPF: "+cadaPf.cpf+" Data de Nascimento: "
                                            +cadaPf.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"))
                                    +" Endereco: "+ cadaPf.endereco.logradouro +" -"+cadaPf.endereco.numero);
                                    System.out.println();
                                    System.out.println("Aperte ENTER para continuar!");
                                    leitor.nextLine();
                                }
                            }else {
                                System.out.println("Lista vazia");
                            }
                            
                            break;
                        case "0":
                            System.out.println("Voltar");
                            break;
                        default:
                            System.out.println("Opçao inválida!\nTente novamente");
                            break;

                    }

                }while(!opcaoPf.equals(0));
            break;
            case "2":
                System.out.println("case2");
                break;
            case "0":
                System.out.println("case3");
                break;
            default:
                System.out.println("default");
                break;

        }

        }while(!opcao.equals("0"));
    }
}