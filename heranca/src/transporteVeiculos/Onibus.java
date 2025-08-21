package transporteVeiculos;

public class Onibus extends Veiculo {
	private int numero_paradas;

	public Onibus(float dist, float velo, int numero_paradas) {
		super(dist, velo);
		this.numero_paradas = numero_paradas;
	}

	public int getNumero_paradas() {
		return numero_paradas;
	}

	public void setNumero_paradas(int numero_paradas) {
		this.numero_paradas = numero_paradas;
	}

	public void calcularTempo() {
		System.out
				.println("Ônibus: " + (((super.getDist() / super.getVelo()) * 60) + numero_paradas * 15) + " minutos.");
	}

}
