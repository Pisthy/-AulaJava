package poo;

import java.util.Scanner;
import poo.dao.PessoaDAO;
import poo.model.Cliente;
import poo.model.Funcionario;
import poo.model.Pessoa;
/* O código está com um bug no arquivo de configuração: hibernate.cfg.xml que está na presente na pasta target-classes.
    Toda as vezes que precisei fazer um git clone desse arquivo ele apaga um mapping class,
    e assim, dando erro no banco de dados.
    Por isso peço para que você entre nesse arquivo de configuração e ao final coloque (abaixo da linha 22):
     <mapping class="poo.model.Cliente"/>
    <mapping class="poo.model.Funcionario"/>
    e em seguida exclua o arquivo Banco_Dados_Clientes.sqlite.
 *
 * 
 * 
 */
public class Main {

    public static void main(String[] args) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        Scanner scanner = new Scanner(System.in);
        int escolhaPrincipal = 0;

        while (escolhaPrincipal != 3) {
            System.out.println("1-Gerenciar Cliente\n2-Gerenciar Funcionário\n3-Sair\nEscolha: ");
            escolhaPrincipal = scanner.nextInt();
            scanner.nextLine();

            switch (escolhaPrincipal) {
                case 1:
                    gerenciarCliente(pessoaDAO, scanner);
                    break;
                case 2:
                    gerenciarFuncionario(pessoaDAO, scanner);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        pessoaDAO.close();
        scanner.close();
    }

    private static void gerenciarCliente(PessoaDAO pessoaDAO, Scanner scanner) {
        int escolhaCliente = 0;

        while (escolhaCliente != 5) {
            System.out.println("1-Registrar Cliente\n2-Consultar Cliente\n3-Atualizar Cliente\n4-Excluir Cliente\n5-Voltar\nOpção: ");
            escolhaCliente = scanner.nextInt();
            scanner.nextLine();

            switch (escolhaCliente) {
                case 1:
                    registrarCliente(pessoaDAO, scanner);
                    break;
                case 2:
                    consultarCliente(pessoaDAO, scanner);
                    break;
                case 3:
                    atualizarCliente(pessoaDAO, scanner);
                    break;
                case 4:
                    excluirCliente(pessoaDAO, scanner);
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void gerenciarFuncionario(PessoaDAO pessoaDAO, Scanner scanner) {
        int escolhaFuncionario = 0;

        while (escolhaFuncionario != 5) {
            System.out.println("1-Registrar Funcionário\n2-Consultar Funcionário\n3-Atualizar Funcionário\n4-Excluir Funcionário\n5-Voltar\nOpção: ");
            escolhaFuncionario = scanner.nextInt();
            scanner.nextLine();

            switch (escolhaFuncionario) {
                case 1:
                    registrarFuncionario(pessoaDAO, scanner);
                    break;
                case 2:
                    consultarFuncionario(pessoaDAO, scanner);
                    break;
                case 3:
                    atualizarFuncionario(pessoaDAO, scanner);
                    break;
                case 4:
                excluirFuncionario(pessoaDAO, scanner);
                    break;    
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void registrarCliente(PessoaDAO pessoaDAO, Scanner scanner) {
        System.out.println("Informe o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println("Informe o CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.println("Informe o plano do cliente (1-Black / 2-Single): ");
        int plano = scanner.nextInt();
        scanner.nextLine();

        String planoDigitado = (plano == 1) ? "Black" : "Single";
        Pessoa cliente = new Cliente(cpf, nome, planoDigitado);
        pessoaDAO.salvarPessoa(cliente);
        System.out.println("Cliente registrado com sucesso!");
    }

    private static void consultarCliente(PessoaDAO pessoaDAO, Scanner scanner) {
        consultarPessoa(pessoaDAO, scanner, "cliente");
    }

    private static void atualizarCliente(PessoaDAO pessoaDAO, Scanner scanner) {
        System.out.println("Digite o CPF do cliente que deseja atualizar o plano: ");
        String procurarPessoa = scanner.nextLine();
        Pessoa pessoaEncontrada = pessoaDAO.getPessoaByCPF(procurarPessoa);
        if (pessoaEncontrada != null && pessoaEncontrada instanceof Cliente) {
            System.out.println("Informe o novo plano do cliente (1-Black / 2-Single): ");
            int novoPlano = scanner.nextInt();
            scanner.nextLine();

            String planoDigitado = (novoPlano == 1) ? "Black" : "Single";
            ((Cliente) pessoaEncontrada).setPlano(planoDigitado);
            pessoaDAO.atualizarPessoa(pessoaEncontrada);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void excluirCliente(PessoaDAO pessoaDAO, Scanner scanner) {
        System.out.println("Digite o CPF do cliente que deseja excluir: ");
        String procurarPessoa = scanner.nextLine();
        pessoaDAO.deletarPessoaByCPF(procurarPessoa);
        System.out.println("Cliente excluído com sucesso!");
    }

    private static void registrarFuncionario(PessoaDAO pessoaDAO, Scanner scanner) {
        System.out.println("Informe o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.println("Informe o CPF do funcionário: ");
        String cpf = scanner.nextLine();
        System.out.println("Informe a função do funcionário: ");
        String funcao = scanner.nextLine();

        Pessoa funcionario = new Funcionario(cpf, nome, funcao);
        pessoaDAO.salvarPessoa(funcionario);
        System.out.println("Funcionário registrado com sucesso!");
    }

    private static void consultarFuncionario(PessoaDAO pessoaDAO, Scanner scanner) {
        consultarPessoa(pessoaDAO, scanner, "funcionario");
    }

    private static void atualizarFuncionario(PessoaDAO pessoaDAO, Scanner scanner) {
        System.out.println("Digite o CPF do funcionário que deseja atualizar a função: ");
        String procurarPessoa = scanner.nextLine();
        Pessoa pessoaEncontrada = pessoaDAO.getPessoaByCPF(procurarPessoa);
        if (pessoaEncontrada != null && pessoaEncontrada instanceof Funcionario) {
            System.out.println("Informe a nova função do funcionário: ");
            String novaFuncao = scanner.nextLine();
            ((Funcionario) pessoaEncontrada).setFuncao(novaFuncao);
            pessoaDAO.atualizarPessoa(pessoaEncontrada);
            System.out.println("Funcionário atualizado com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private static void consultarPessoa(PessoaDAO pessoaDAO, Scanner scanner, String tipo) {
        System.out.println("Informe o CPF da pessoa que deseja consultar: ");
        String procurarPessoa = scanner.nextLine();
        Pessoa pessoaEncontrada = pessoaDAO.getPessoaByCPF(procurarPessoa);

        if (pessoaEncontrada != null) {
            if ("cliente".equalsIgnoreCase(tipo) && pessoaEncontrada instanceof Cliente) {
                System.out.println("Cliente encontrado: " + pessoaEncontrada);
            } else if ("funcionario".equalsIgnoreCase(tipo) && pessoaEncontrada instanceof Funcionario) {
                System.out.println("Funcionário encontrado: " + pessoaEncontrada);
            } else {
                System.out.println("Tipo de pessoa não corresponde ao informado.");
            }
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }

    private static void excluirFuncionario(PessoaDAO pessoaDAO, Scanner scanner) {
        System.out.println("Digite o CPF do funcionário que deseja excluir: ");
        String procurarPessoa = scanner.nextLine();
        pessoaDAO.deletarPessoaByCPF(procurarPessoa);
        System.out.println("Funcionário excluído com sucesso!");
    }
}
