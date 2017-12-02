package cl.agile.core.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by famancil on 29-11-17.
 */
@Entity
@Table(name = "usuario")
public class User {

    private Long id;
    private String username;
    private String email;
    private String password;
    private Date fechaRegistro;

    public User(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "usuario_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long usuaexId) {
        this.id = usuaexId;
    }

    @Column(name = "username")
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date newFechaRegistro) {
        this.fechaRegistro = newFechaRegistro;
    }

}
