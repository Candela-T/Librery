
package libreria.DAO;

import java.util.List;
import libreria.entidades.Autor;



public class AutorDAO extends DAO<Autor> {

    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }

    @Override
    public void editar(Autor autor) {
        super.editar(autor);
    }

    public void eliminar(Long id) throws Exception {
        Autor autor = buscarPorId(id);
        super.eliminar(autor);
    }

    public Autor buscarPorId(Long id) throws Exception {

        conectar();
        Autor autor = em.find(Autor.class, id);
        desconectar();
        return autor;
    }

    public Autor buscarPorNombre(String nombre) throws Exception {

        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                .setParameter("nombre", nombre)
                .getSingleResult();
        desconectar();
        return autor;
    }

//    public List<Autor> listarTodos() throws Exception {
//        conectar();
//        List<Autor> autores = em.createQuery("SELECT a FROM Autor a")
//                .getResultList();
//        desconectar();
//        return autores;
//    }

    
}
