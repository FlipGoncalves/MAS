package MAS_Lab4;

import java.util.ArrayList;

public class Tester {
	private static ArrayList<Alimento> ingredientes = new ArrayList<>();
	private static ArrayList<Prato> pratos = new ArrayList<>();
	private static ArrayList<Ementa> ementas = new ArrayList<>();
	
	public static void main(String[] args) {
		initializer(); // Só para tornar isto mais rápido, não faz o que a alínea c) pede
		
		Cliente cliente1 = new Cliente("cliente1", 0);
		
		Ementa ementa = ementas.get((int) (Math.random() * ementas.size()));
		
		Pedido pedido1 = cliente1.fazerPedido(ementa);
		
		int c;
		for (int i = 0; i < 2; i++) {
			boolean x;
			c = (int) (Math.random() * ementa.getDimLista());		
			do {
				x = pedido1.addPrato(ementa.getPrato(c));
			}while(!x);
		}		
		
		System.out.println(pedido1.checkOut());
	}
	
	public static void initializer() {
		for (int i = 0; i < 5; i++) {
			boolean x;
			do {
				x = false;
				Alimento al = randAlimento();
				if(!ingredientes.contains(al)) {
					ingredientes.add(al);
					x = true;
				}
			}while(!x);
		}
		
		for (int i = 0; i < 5; i++) {
			Prato prato = randPrato(i+1);
			for (int j = 0; j < 3; j++) {
				boolean x;
				int c = 0;
				do {
					x = prato.addIngrediente(ingredientes.get((int) (Math.random() * ingredientes.size())));
					c++;
				}while(!x || c == 5);
			}
			pratos.add(prato);
		}
		
		int c;
		for (int i = 0; i < 3; i++) {
			Ementa ementa = new Ementa("combinado n." + i+1);
			for (int j = 0; j < 3; j++) {
				boolean x;
				do {
					c = randNumber(pratos.size());
					x = ementa.addPrato(pratos.get(c));
				}while(!x);
			}
			ementas.add(ementa);
		}
		
	}
	
	public static int randNumber(int x) {
		return (int) (Math.random() * x);
	}
	
	public static Alimento randAlimento() {
		Alimento res = null;
		switch ((int) (Math.random() * 7)) {
		case 0:
			res = new Carne(VariedadeCarne.FRANGO, 22.3, 345.3, 300);
			break;
		case 1:
			res = new Carne(VariedadeCarne.PORCO, 22.3, 345.3, 300);
			break;
		case 2:
			res = new Carne(VariedadeCarne.VACA, 22.3, 345.3, 300);
			break;
		case 3:
			res = new Carne(VariedadeCarne.PERU, 22.3, 345.3, 300);
			break;
		case 4:
			res = new Peixe(TipoPeixe.CONGELADO, 31.3, 25.3, 200);
			break;
		case 5:
			res = new Peixe(TipoPeixe.FRESCO, 31.3, 25.3, 200);
			break;
		case 6:
			res = new Legume("Couve Flor", 21.3, 22.4, 150);
			break;
		case 7:
			res = new Cereal("Milho", 19.3, 32.4, 110);
			break;
		}
		return res;
	}
	
	public static Prato randPrato(int i) {
		Prato res = null;
		switch ((int) (Math.random() * 3)) {
		case 0:
			res = new Prato("combinado n." + i, (double) (Math.random() * 20));
			break;
		case 1:
			res = new PratoVegetariano("combinado n." + i, (double) (Math.random() * 20));
			break;
		case 2:
			res = new PratoDieta("combinado n." + i, (double) (Math.random() * 20), 90.8);
			break;
		}
		return res;
	}
}
