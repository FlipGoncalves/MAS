package MAS_Lab4;

import java.util.ArrayList;

public class Ementa {
	private String nome;
	private String local;
	private ArrayList<Prato> listaPratos = new ArrayList<Prato>();
	
	public Ementa(String nome, String local) {
		this.nome = nome;
		this.local = local;
	}
	
	public Ementa(String nome) {
		this.nome = nome;
		this.local = "";
	}
	
	public int getDimLista() {
		return this.listaPratos.size();
	}
	
	public Prato getPrato(int i) {
		return this.listaPratos.get(i);
	}
	
	public boolean hasPrato(Prato prato) {;
		for (Prato pratoLista : listaPratos) {
			if (prato.equals(pratoLista)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean addPrato(Prato prato) {
		if (!hasPrato(prato)) {	
			this.listaPratos.add(prato);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean removePrato(Prato prato) {
		if (hasPrato(prato)) {	
			this.listaPratos.remove(prato);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		String msg = "Ementa '" + nome + "' a apresentar em " + local + "\n";
		for (Prato prato : listaPratos) {
			msg += prato.toString() + "\n"; 
		}
		return msg;
	}	
}
