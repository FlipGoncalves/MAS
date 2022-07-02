package MAS_Lab4;

public enum DiaSemana {
	Segunda("Segunda"),
	Terça("Terça"),
	Quarta("Quarta"),
	Quinta("Quinta"),
	Sexta("Sexta"),
	Sábado("Sábado"),
	Domingo("Domingo");
	
	private String dia;

	DiaSemana(String var) {
		this.dia = var;
	}
	
	public String getDia() {
		 return dia;
	 }

	public static String getEnum(int i) {
		DiaSemana dia = Segunda;
		switch (i) { 
	        case 1: 
	            dia = Segunda;
	            break;
	        case 2: 
	        	dia = Terça;
	            break; 
	        case 3:
	        	dia = Quarta; 
	            break;
	        case 4: 
	        	dia = Quinta; 
	            break;
	        case 5: 
	        	dia = Sexta; 
	            break;
	        case 6: 
	        	dia = Sábado; 
	            break;
	        case 7: 
	        	dia = Domingo; 
	            break;
        }
		return dia.getDia();
	}
}