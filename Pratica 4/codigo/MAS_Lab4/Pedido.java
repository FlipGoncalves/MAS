package MAS_Lab4;

import java.util.ArrayList;

public class Pedido {
	private ArrayList<Prato> carrinho = new ArrayList<Prato>();
	private Ementa ementa;
	private Cliente cliente;
	
	public Pedido(Ementa ementa, Cliente cliente) {
		this.ementa = ementa;
		this.cliente = cliente;
	}
	
	public boolean addPrato(Prato prato) {
		if (ementa.hasPrato(prato)) {
			carrinho.add(prato);
			return true;
		}
		else {
			return false;
		}
	}
	
	public double finalPrice() {
		double price = 0;
		for (Prato prato : carrinho) {
			price += prato.getPrice();
		}
		
		return price * ((100-this.cliente.getDesconto())/100);
	}

	public String checkOut() {
		String msg = "Pedido do cliente " + cliente + ": \n";
		for (Prato prato : carrinho) {
			msg += prato.toString() + "\n";
		}
		msg += String.format("Total: %.2f euros", finalPrice());
		return msg;
	}
	
}
