package transporteVeiculos;

public class Bicicleta extends Veiculo{
	private int horas;
	private float timedec;
	private int minutos;

	public Bicicleta(float dist, float velo) {
		super(dist, velo);
	}
	
	@Override
	public void calcularTempo() {
		timedec = super.getDist() / super.getVelo();
		horas = (int) timedec;
		timedec = timedec - horas;
		timedec = timedec * 60;
		minutos = (int) timedec;

		System.out.println("Bicicleta: " + horas + " horas e " + minutos + " minutos.");
	}

}
