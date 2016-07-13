/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Libro;

public class ServicioLibro {

    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void crear(Libro libro) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en insertar libro "+e);
        } finally {
            em.close();
        }

    }

    public void editar(Libro libro) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en actualizar libro");
        } finally {
            em.close();
        }

    }

    public void eliminar(Libro libro) {

        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.remove(em.merge(libro));
            em.getTransaction().commit();
            
        } catch (Exception e) {
            System.out.println("Error en eliminar  libro " + e);
        } finally {
            em.close();
        }

    }
    
    public Libro findByIdLibro(Integer id) {

		Libro libroEncontrado = new Libro();
		try {
			// Connection connection = em.unwrap(Connection.class);

			em = HelperPersistencia.getEMF();
			em.getTransaction().begin();
			Query query = em.createNamedQuery("Libro.findByIdLibro",Libro.class);
			query.setParameter("idLibro", id);
			libroEncontrado = (Libro) query.getSingleResult();

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error en lsa consulta Libro");
		} finally {
			em.close();
		}

		return libroEncontrado;
	}
   
}
