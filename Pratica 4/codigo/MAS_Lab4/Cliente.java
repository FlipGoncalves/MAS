package MAS_Lab4;

public class Cliente {
	private static int x = 0;
	private int id;
	private String nome;
	private double desconto;
	
	public Cliente(String nome, double desconto) {
		this.id = ++x;
		this.nome = nome;
		this.desconto = desconto;
	}
	
	public Cliente(String nome) {
		this.id = ++x;
		this.nome = nome;
		this.desconto = 0; // mudar este valor se houver um desconto predefinido
	}
	
	public Cliente() {
		this.id = ++x;
		this.nome = "Cliente" + this.id ;
		this.desconto = 0;// mudar este valor se houver um desconto predefinido
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public double getDesconto() {
		return desconto;
	}

	public Pedido fazerPedido(Ementa ementa) {		
		return new Pedido(ementa, this);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", desconto=" + desconto + "]";
	}
	
	
}
