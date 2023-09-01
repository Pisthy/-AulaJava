import java.util.Scanner;

public class SistemaGerenciamentoEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0, rodagem = 0;
        String[] nomesProduto = new String[100]; 
        int[] quantidade = new int[100]; 
        String remover, removerQtd;

        while (opcao != 5) {
            System.out.println("1-Adicionar produto\n2-Remover Produto\n3-Listar produtos existentes\n4-Atualizar a quantidade de produtos\n5-Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                   
                System.out.println("Informe o nome do produto: ");
                    nomesProduto[rodagem] = scanner.nextLine();
                    System.out.println("Informe a quantidade do produto: ");
                    quantidade[rodagem] = scanner.nextInt();
                    scanner.nextLine(); 
                    rodagem++;
                    break;

             
                case 2:
                System.out.println("Informe o nome do produto que deseja remover: "); 
                remover = scanner.nextLine();  
                int posicaoRemover = -1; 
                
                for (int i = 0; i < rodagem; i++) {
                    if (remover.compareTo(nomesProduto[i]) == 0) {
                        posicaoRemover = i; 
                        break;
                    }
                }
                
                if (posicaoRemover != -1) {
                    for (int i = posicaoRemover; i < rodagem - 1; i++) {
                        nomesProduto[i] = nomesProduto[i + 1];
                        quantidade[i] = quantidade[i + 1];
                    }
                    
                    rodagem--; 
                    System.out.println("Produto removido.");
                } else {
                    System.out.println("Produto não encontrado.");
                }
                
                break;
            
                case 3:
                   for (int i = 0;i<rodagem;i++){
                        System.out.println("Nome: "+ nomesProduto[i]); 
                        System.out.println("Quantidade: "+ quantidade[i]);
                   }
                    break;
                case 4:
                System.out.println("Informe o nome do produto que queria atualizar o valor");
                removerQtd = scanner.nextLine();   
                
                for (int i = 0;i<rodagem;i++){
                        if (removerQtd.compareTo(nomesProduto[i])==0){
                            System.out.println("Produto encontrado");
                            System.out.println("Informe a quantidade atualizada do produto: ");
                            quantidade[i]=scanner.nextInt();
                            break;
                        } 
                        else {
                            System.out.println("Produto não encontrado encontrado");
                        }
                    }

    
                    
                   
                   scanner.nextLine(); 
                   break;

                case 5:
                    System.out.println("Saindo do programa.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }


}