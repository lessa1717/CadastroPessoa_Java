import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<PessoaFisica> listaPf = new ArrayList<>();
        PessoaFisica metodoPF = new PessoaFisica();
        ArrayList<PessoaJuridica> listaPj = new ArrayList<>();
        Scanner leitor = new Scanner(System.in);

        String opcao;

        do {
            System.out.println("Bem vindo ao sistema de cadastro de pessoas Fisicas e Juridicas");
            System.out.println("Escolha uma opção:\n1 - Pessoa Física\n2 - Pessoa Jurídica\n0 - Sair");
            opcao = leitor.nextLine();

            switch (opcao) {
                case "1":
                    String opcaoPf;

                    do {
                        System.out.println("Escolha uma opção:\n1 - Cadastrar PF\n2 - Listar PF\n0 - Voltar");
                        opcaoPf = leitor.nextLine();

                        switch (opcaoPf) {
                            case "1":
                                PessoaFisica novaPF = new PessoaFisica();
                                novaPF.endereco = new Endereco();

                                System.out.println("Digite o nome:");
                                novaPF.nome = leitor.nextLine();

                                System.out.println("Digite o cpf:");
                                novaPF.cpf = leitor.nextLine();

                                System.out.println("Digite o rendimento:");
                                novaPF.rendimento = Float.parseFloat(leitor.nextLine());

                                System.out.println("Digite a data de nascimento (dd/mm/aaaa):");
                                String dataNascimento = leitor.nextLine();
                                novaPF.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                                Period idade = Period.between(novaPF.dataNascimento, LocalDate.now());
                                if (idade.getYears() >= 18) {
                                    System.out.println("Idade Válida!");
                                } else {
                                    System.out.println("Idade inválida!");
                                    break;
                                }

                                System.out.println("Digite o logradouro:");
                                novaPF.endereco.logradouro = leitor.nextLine();

                                System.out.println("Digite o número:");
                                novaPF.endereco.numero = Integer.parseInt(leitor.nextLine());

                                System.out.println("Este endereço é comercial? S/N:");
                                String endCom = leitor.nextLine();
                                novaPF.endereco.endComercial = endCom.equalsIgnoreCase("S") || endCom.equalsIgnoreCase("s");

                                listaPf.add(novaPF);

                                System.out.println("Cadastro realizado com sucesso!");
                                break;

                            case "2":
                                if (listaPf.size() > 0) {
                                    for (PessoaFisica cadaPf : listaPf) {
                                        System.out.println("Nome: " + cadaPf.nome + " ,CPF: " + cadaPf.cpf
                                                + " ,Data de Nascimento: "
                                                + cadaPf.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                                                + " ,Imposto a ser pago: " + metodoPF.CalcularImposto(cadaPf.rendimento)
                                                + " ,Endereco: " + cadaPf.endereco.logradouro + " - " + cadaPf.endereco.numero);
                                        System.out.println();
                                        System.out.println("Aperte ENTER para continuar!");
                                        leitor.nextLine();
                                    }
                                } else {
                                    System.out.println("Lista vazia");
                                }
                                break;

                            case "0":
                                System.out.println("Voltar");
                                break;

                            default:
                                System.out.println("Opção inválida!\nTente novamente");
                                break;
                        }

                    } while (!opcaoPf.equals("0"));

                    break;

                case "2":
                    String opcaoPj;

                    do {
                        System.out.println("Escolha uma opção:\n1 - Cadastrar PJ\n2 - Listar PJ\n0 - Voltar");
                        opcaoPj = leitor.nextLine();

                        switch (opcaoPj) {
                            case "1":

                                PessoaJuridica novaPJ = new PessoaJuridica();
                                novaPJ.endereco = new Endereco();

                                System.out.println("Digite a razão social da Pessoa Jurídica:");
                                novaPJ.nome = leitor.nextLine();

                                System.out.println("Digite o CNPJ da Pessoa Jurídica:");
                                novaPJ.cnpj = leitor.nextLine();

                                System.out.println("Digite o rendimento da Pessoa Jurídica:");
                                novaPJ.rendimento = Float.parseFloat(leitor.nextLine());



                                System.out.println("Digite o logradouro:");
                                novaPJ.endereco.logradouro = leitor.nextLine();

                                System.out.println("Digite o número:");
                                novaPJ.endereco.numero = Integer.parseInt(leitor.nextLine());

                                System.out.println("Este endereço é comercial? S/N:");
                                String endComPJ = leitor.nextLine();

                                if (endComPJ.equalsIgnoreCase("S") || endComPJ.equalsIgnoreCase("s")) {
                                    novaPJ.endereco.endComercial = true;
                                } else {
                                    novaPJ.endereco.endComercial = false;
                                }

                                listaPj.add(novaPJ);

                                System.out.println("Cadastro de Pessoa Jurídica realizado com sucesso!");

                                break;

                            case "2":
                                if (listaPj.size() > 0) {
                                    for (PessoaJuridica cadaPJ : listaPj) {
                                        System.out.println("Razão Social: " + cadaPJ.nome + " ,CNPJ: " + cadaPJ.cnpj
                                                + " ,Imposto a ser pago: " + cadaPJ.calcularImposto()
                                                + " ,Endereco: " + cadaPJ.endereco.logradouro + " - " + cadaPJ.endereco.numero);
                                        System.out.println();
                                    }
                                } else {
                                    System.out.println("Lista de Pessoa Jurídica vazia");
                                }
                                break;
                            case "0":
                                System.out.println("Voltar");
                                break;

                            default:
                                System.out.println("Opção inválida!\nTente novamente");
                                break;
                        }

                    } while (!opcaoPj.equals("0"));
                    break;
                case "0":
                    System.out.println("case3");
                    break;
                default:
                    System.out.println("default");
                    break;
            }
        } while (!opcao.equals("0"));
    }
}