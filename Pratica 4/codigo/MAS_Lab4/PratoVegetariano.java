package MAS_Lab4;

public class PratoVegetariano extends Prato{
	
	public PratoVegetariano(String nome, double price) {
		super(nome, price);
	}
	
	@Override
	public boolean addIngrediente(Alimento al) {
		if (al.isVegetariano()) {
			super.addIngrediente(al);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Vegetariano " + super.toString();
	}
}
