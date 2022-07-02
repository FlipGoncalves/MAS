package MAS_Lab4;

public enum TipoPeixe {
	CONGELADO("congelado"),
	FRESCO("fresco");
	
	private String tipo;

	TipoPeixe(String var) {
		this.tipo = var;
	}
	
	 public String getTipo() {
		 return tipo;
	 }
}
