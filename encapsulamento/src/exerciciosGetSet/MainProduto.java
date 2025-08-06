package exerciciosGetSet;

public class MainProduto {
    public static void main(String[] args) {
        Produto p = new Produto("Camiseta", 100.0);

        System.out.println("Produto: " + p.getNome());
        System.out.println("Preço antes do desconto: R$" + p.getPreco());

        p.aplicarDesconto(20);

        System.out.println("Preço com desconto: R$" + p.getPreco());
    }
}
