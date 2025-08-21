package transporteVeiculos;

public class Carro extends Veiculo {

	public Carro(float dist, float velo) {
		super(dist, velo);
	}

	@Override
	public void calcularTempo() {
		System.out.println("Carro: " + ((super.getDist() / super.getVelo())* 60) + " minutos.");
	}

}
