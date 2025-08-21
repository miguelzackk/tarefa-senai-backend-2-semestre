package transporteVeiculos;

public class Onibus extends Veiculo {
	private int numero_paradas;
	private float timeparadas;
	private int horas;
	private float timedec;
	private int minutos;

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

	@Override
	public void calcularTempo() {
		timeparadas = (float) (numero_paradas * 0.25);
		timedec = super.getDist() / super.getVelo();
		timedec = timedec + timeparadas;
		horas = (int) timedec;
		timedec = timedec - horas;
		timedec = timedec * 60;
		minutos = Math.round(timedec);
		System.out.println("Ônibus: " + horas + " horas e " + minutos + " minutos.");

	}

}
