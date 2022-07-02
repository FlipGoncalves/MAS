package MAS_Lab4;

public class PratoDieta extends Prato{
	private double maxCal;
	private double curCal = 0;
	
	public PratoDieta(String nome, double price, double maxCal) {
		super(nome, price);
		this.maxCal = maxCal;
	}

	public double getMaxCal() {
		return maxCal;
	}

	public double getCurCal() {
		return curCal;
	}
	
	@Override
	public boolean addIngrediente(Alimento al) {
		if (al.getCalorias() + this.curCal < this.maxCal) {
			super.addIngrediente(al);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(curCal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(maxCal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PratoDieta other = (PratoDieta) obj;
		if (Double.doubleToLongBits(curCal) != Double.doubleToLongBits(other.curCal))
			return false;
		if (Double.doubleToLongBits(maxCal) != Double.doubleToLongBits(other.maxCal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dieta (" + this.maxCal + " calorias) " + super.toString();
	}
	
	
}
