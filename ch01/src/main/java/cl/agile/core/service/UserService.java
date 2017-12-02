package cl.agile.core.service;

import cl.agile.core.entity.User;
import cl.agile.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.List;

/**
 * Created by famancil on 29-11-17.
 */
@Component
public class UserService {

    /**
     * Repositorio para el manejo CRUD de la entidad {@link cl.agile.core.entity.User}.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Obtiene el {@link cl.agile.core.entity.User} segun el id que se pase como parametro.
     */

    public User getUserById(Long idUser){
        User user = userRepository.findById(idUser);
        if(user!=null){
            return user;
        }
        else return null;

    }

    /**
     * Obtiene el {@link cl.agile.core.entity.User} segun el id que se pase como parametro.
     */

    public List<User> getAllUsers(){
        List<User> user = userRepository.findByOrderByIdAsc();
        if(user!=null){
            return user;
        }
        else return null;

    }

    /**
     * Guarda un {@link cl.agile.core.entity.User} nuevo en la base de datos.
     */
    public void saveUsuario(User user){

        Date fechaActual = new java.util.Date();

        user.setUsername(user.getUsername());

        // si email es vacio se setea como nulo
        if ( user.getEmail().compareTo("") == 0 ) {
            user.setEmail(null);
        }

        // si password esta vacio se setea como nulo
        if ( user.getPassword().compareTo("") == 0 ) {
            user.setPassword(null);
        }

        user.setFechaRegistro(fechaActual);

        userRepository.save(user);
    }

    @Transactional
    public void deleteUsuarioById(Long id) {

        userRepository.eliminar(id);
    }
}
