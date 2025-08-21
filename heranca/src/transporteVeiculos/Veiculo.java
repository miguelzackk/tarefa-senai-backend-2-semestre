package transporteVeiculos;

public class Veiculo {

	private float dist;
	private float velo;

	public Veiculo(float dist, float velo) {
		this.dist = dist;
		this.velo = velo;
	}

	public float getDist() {
		return dist;
	}

	public void setDist(float dist) {
		this.dist = dist;
	}

	public float getVelo() {
		return velo;
	}

	public void setVelo(float velo) {
		this.velo = velo;
	}

	public void calcularTempo() {
		System.out.println("O tempo estimado de chegada é:" + (dist / velo));
	}

}
