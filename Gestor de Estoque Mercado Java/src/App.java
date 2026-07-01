import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        List<String> estoque = new ArrayList<>();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- GESTOR DE ESTOQUE ---");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Remover Produto");
            System.out.println("4. Buscar Produto");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String novoProduto = leitor.nextLine().toUpperCase();

                    if (estoque.contains(novoProduto)) {
                        System.out.println("Produto já cadastrado!");
                    } else {
                        estoque.add(novoProduto);
                        System.out.println("Produto adicionado com sucesso!");
                    }
                    break;

                case 2:
                    if (estoque.isEmpty()) {
                        System.out.println("Estoque vazio.");
                    } else {
                        Collections.sort(estoque);
                        System.out.println("\nLista de produtos:");
                        for (int i = 0; i < estoque.size(); i++) {
                            System.out.println((i + 1) + ". " + estoque.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nome do produto para remover: ");
                    String removerProduto = leitor.nextLine().toUpperCase();

                    if (estoque.contains(removerProduto)) {
                        estoque.remove(removerProduto);
                        System.out.println("Produto removido com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Nome do produto para buscar: ");
                    String buscarProduto = leitor.nextLine().toUpperCase();

                    int indice = estoque.indexOf(buscarProduto);
                    if (indice != -1) {
                        System.out.println("Produto encontrado na posição: " + (indice + 1));
                    } else {
                        System.out.println("Produto não está no estoque.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        leitor.close();
    }
}