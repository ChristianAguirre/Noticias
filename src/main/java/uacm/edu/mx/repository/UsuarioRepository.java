package uacm.edu.mx.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import uacm.edu.mx.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	@Query(value="select * from user where id =:id", nativeQuery = true)
	Usuario byId_usuario(@Param("id") Long id);
	
	@Query(value="select * from user where nombre =:nombre", nativeQuery = true)
	Usuario byName_usuario(@Param("nombre") String nombre);
}
