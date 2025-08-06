package exerciciosGetSet;

public class Produto {
   
    private String nome;
    private double preco;

  
    public Produto(String nome, double preco) {
        this.nome = nome;
        if (preco >= 0) {
            this.preco = preco;
        } else {
            this.preco = 0;
        }
    }


    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }


    public void aplicarDesconto(double percentual) {
        if (percentual < 0) {
            System.out.println("Desconto inválido!");
            return;
        }

        double desconto = preco * (percentual / 100);
        preco -= desconto;

    
        if (preco < 0) {
            preco = 0;
        }
    }
}
