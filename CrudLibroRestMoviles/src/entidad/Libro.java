package entidad;

public class Libro {
	private String titulo;
	private String autor;
	private int stock;
	private int id;

	public Libro() {

	}

	public Libro(String titulo, String autor, int stock) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.stock = stock;
	}

	public Libro(String titulo, String autor, int stock, int id) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.stock = stock;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
