package uacm.edu.mx.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import uacm.edu.mx.model.Noticia;

public interface NoticiaRepository extends CrudRepository<Noticia, Long> {
	@Query(value = "select = from noticia where id"+"=:id",nativeQuery=true)
	Noticia findById_noticia(@Param("id") Long id);
}
