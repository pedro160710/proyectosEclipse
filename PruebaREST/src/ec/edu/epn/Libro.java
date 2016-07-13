package ec.edu.epn;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name = "Libro")
public class Libro {
	private int id;
	private String autor;
	private String titulo;
	private int stock;

	public Libro() {
		super();
	}

	public Libro(int id, String autor, String titulo, int stock) {
		super();
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.stock = stock;
	}

//	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
//	@XmlElement
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
//	@XmlElement
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
//	@XmlElement
	public int getStock() {
		return stock;
	}

	public void setStock(int stok) {
		this.stock = stok;
	}

}
