import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaEstoque {
    private static List<Produto> estoque = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 3) {
            System.out.println("===== Menu =====");
            System.out.println("1 - Inserir produto");
            System.out.println("2 - Consultar estoque");
            System.out.println("3 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("\nInserir Produto");
                    inserirProduto(scanner);
                    break;
                case 2:
                    System.out.println("\nConsultar Estoque");
                    consultarEstoque();
                    break;
                case 3:
                    System.out.println("\nSaindo do programa...");
                    break;
                default:
                    System.out.println("\nOpção inválida! Digite novamente.\n");
            }
        }

        scanner.close();
    }

    private static void inserirProduto(Scanner scanner) {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite a categoria do produto (Masculino/Feminino): ");
        String categoria = scanner.nextLine();
        System.out.print("Digite a descrição do produto: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite a quantidade do produto: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite a qualidade do produto: ");
        String qualidade = scanner.nextLine();
        System.out.print("Digite o valor do produto: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer

        LocalDateTime dataEntrada = LocalDateTime.now();

        Produto produto = new Produto(codigo, categoria, descricao, quantidade, qualidade, valor, dataEntrada);
        estoque.add(produto);

        System.out.println("\nProduto inserido no estoque!\n");
    }

    private static void consultarEstoque() {
        if (estoque.isEmpty()) {
            System.out.println("\nEstoque vazio!\n");
            return;
        }

        System.out.println("\nProdutos no estoque:");
        for (Produto produto : estoque) {
            System.out.println("-----------------------------------");
            System.out.println("Código: " + produto.getCodigo());
            System.out.println("Categoria: " + produto.getCategoria());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println("Qualidade: " + produto.getQualidade());
            System.out.println("Valor: " + produto.getValor());
            System.out.println("Data de entrada: " + produto.getDataEntrada().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            System.out.println("-----------------------------------");
        }
        System.out.println();
    }
}