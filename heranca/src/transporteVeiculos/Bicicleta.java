package transporteVeiculos;

public class Bicicleta extends Veiculo{

	public Bicicleta(float dist, float velo) {
		super(dist, velo);
	}
	
	@Override
	public void calcularTempo() {
		System.out.println("Bicicleta: " + ((super.getDist() / super.getVelo())* 60) + " minutos.");
	}

}
