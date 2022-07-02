package MAS_Lab4;

import java.util.ArrayList;

public class Prato {
	private String nome;
	private double price;
	private ArrayList<Alimento> composicao = new ArrayList<>();
	
	public Prato(String nome, double price) {
		this.nome = nome;
		this.price = price;
	}

	public String getNome() {
		return nome;
	}
	
	public double getPrice() {
		return price;
	}

	public ArrayList<Alimento> getComposicao() {
		return composicao;
	}
	
	public int existsIngrediente(Alimento al) {
		int i = -1;
		
		for (int j = 0; j < composicao.size(); j++) {
			if (composicao.get(j).equals(al)) {
				i = j;
				break;
			}
		}
		
		return i;
	}
	
	public boolean addIngrediente(Alimento al) {
		if (existsIngrediente(al) == -1) {
			this.composicao.add(al);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean removeIngrediente(Alimento al) {
		int i = existsIngrediente(al);
		if (i != -1) {
			this.composicao.remove(i);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((composicao == null) ? 0 : composicao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Prato other = (Prato) obj;
		if (composicao == null) {
			if (other.composicao != null)
				return false;
		} else if (!composicao.equals(other.composicao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prato '" + nome + "' composto por " + composicao.size() + " ingredientes";
	}
	
}
