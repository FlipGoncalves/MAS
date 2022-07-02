package MAS_Lab4;

public enum VariedadeCarne {
	VACA("vaca"),
	PORCO("porco"),
	PERU("peru"),
	FRANGO("frango"),
	OUTRA("outra");
	
	private String tipo;

	VariedadeCarne(String var) {
		this.tipo = var;
	}
	
	 public String getTipo() {
		 return tipo;
	 }
}
