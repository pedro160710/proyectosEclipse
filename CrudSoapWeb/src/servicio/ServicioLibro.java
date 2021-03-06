package servicio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Libro;

public class ServicioLibro {

	EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("JpaCrudSoapWeb");

	public void crearLibro(Libro libro) {
		System.out.println("SERVICIOLIBRO");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(libro);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("no se pudo insertar el libro " + e);
		} finally {
			em.close();
		}

	}

	public void editarLibro(Libro libro) {

		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(libro);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error en actualizar libro " + e);
		} finally {
			em.close();
		}

	}

	public void eliminarLibro(Libro libro) {

		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.merge(libro));
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Error al eliminar  libro " + e);
		} finally {
			em.close();
		}

	}

	public Libro findByIdLibro(Integer id) {

		EntityManager em = emf.createEntityManager();
		Libro libroEncontrado = new Libro();
		try {
			// Connection connection = em.unwrap(Connection.class);
			em.getTransaction().begin();
			Query query = em.createNamedQuery("Libro.findByIdLibro",
					Libro.class);
			query.setParameter("idLibro", id);
			libroEncontrado = (Libro) query.getSingleResult();

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error al consultar Libro");
		} finally {
			em.close();
		}

		return libroEncontrado;
	}

}
