package MAS_Lab4;

public class Alimento {
	private double proteinas;
	private double calorias;
	private double peso;
	private boolean vegetariano;
	
	public Alimento(double proteinas, double calorias, double peso, boolean vegetariano) {
		this.proteinas = proteinas;
		this.calorias = calorias;
		this.peso = peso;
		this.vegetariano = vegetariano;
	}
	
	public Alimento(double proteinas, double calorias, double peso) {
		this.proteinas = proteinas;
		this.calorias = calorias;
		this.peso = peso;
		this.vegetariano = false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(calorias);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(proteinas);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (vegetariano ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		if (Double.doubleToLongBits(calorias) != Double.doubleToLongBits(other.calorias))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (Double.doubleToLongBits(proteinas) != Double.doubleToLongBits(other.proteinas))
			return false;
		if (vegetariano != other.vegetariano)
			return false;
		return true;
	}

	public double getProteinas() {
		return proteinas;
	}

	public double getCalorias() {
		return calorias;
	}

	public double getPeso() {
		return peso;
	}

	public boolean isVegetariano() {
		return vegetariano;
	}

	@Override
	public String toString() {
		if(vegetariano)
			return "proteinas=" + proteinas + ", calorias=" + calorias + ", peso=" + peso + ", vegetariano";
		else
			return "proteinas=" + proteinas + ", calorias=" + calorias + ", peso=" + peso;
	}
	
	
}
