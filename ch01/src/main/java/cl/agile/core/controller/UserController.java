package cl.agile.core.controller;

import cl.agile.core.entity.User;
import cl.agile.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by famancil on 29-11-17.
 */
@Controller
@RequestMapping(value="/api")
public class UserController {

    /**
     * Servicio utilizado para el manejo del usuario
     */
    @Autowired
    private UserService userService;

    private static Logger logger = LoggerFactory.getLogger(APIController.class);

    //Atributos para el tipo de encriptación y la llave privada del servidor
    private static final String TypeKey = "AES";
    private static final byte[] keyValue =
            new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't','S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };


    /**
     * Obtener todos los {@link cl.agile.core.entity.User} en la base de datos.
     */
    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser() {

        List<User> user = userService.getAllUsers();
        return user;
    }

    /**
     * Obtener un {@link cl.agile.core.entity.User} en especifico de la base de datos.
     */
    @RequestMapping(value ="/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable Long id) {

        User user = userService.getUserById(id);
        return user;
    }

    /**
     * Guardar un {@link cl.agile.core.entity.User} en la base de datos.
     */
    @RequestMapping(value ="/users", method = RequestMethod.POST)
    @ResponseBody
    public User saveUser(@RequestBody User user) {

        try {
            String clave = encrypt(user.getPassword());
            user.setPassword(clave);
        } catch (Exception e) {
            e.printStackTrace();
        }

        userService.saveUsuario(user);
        return user;
    }

    /**
     * Modificar datos de un {@link cl.agile.core.entity.User} en especifico de la base de datos.
     */
    @RequestMapping(value ="/users/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public User updatePartialUser(@PathVariable Long id,@RequestBody User user) {

        User antiguo =  userService.getUserById(id);
        if(user.getUsername()!=null)
            antiguo.setUsername(user.getUsername());
        if(user.getPassword()!=null) {
            try {
                String clave = encrypt(user.getPassword());
                antiguo.setPassword(clave);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(user.getEmail()!=null)
            antiguo.setEmail(user.getEmail());

        userService.saveUsuario(antiguo);

        return antiguo;
    }

    /**
     * Borrar un {@link cl.agile.core.entity.User} en especifico de la base de datos.
     */
    @RequestMapping(value ="/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable Long id) {

        userService.deleteUsuarioById(id);
    }

    //Funciones para encriptar y desencriptar una contraseña.


    public static String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(TypeKey);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(TypeKey);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, TypeKey);
        return key;
    }
}
