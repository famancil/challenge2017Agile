package cl.agile.core.repository;

import cl.agile.core.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by famancil on 29-11-17.
 */
public interface UserRepository extends CrudRepository<User, Long> {


    /**
     * Retorna todos los  {@link cl.agile.core.entity.User}.
     */

    List<User> findByOrderByIdAsc();

    /**
     * Retorna un {@link cl.agile.core.entity.User} que posean un id igual al parametro.
     * id.
     */

    User findById(Long id);

    /**
     * Elimina un {@link cl.agile.core.entity.User} segun los id especificados como parametro.
     *
     */
    @Modifying
    @Query(value = "DELETE FROM User AS u WHERE u.id = :idBuscar")
    void eliminar(@Param("idBuscar") Long idBuscar);

}
