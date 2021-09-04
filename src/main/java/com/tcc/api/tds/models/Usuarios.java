package com.tcc.api.tds.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuarios", nullable = false)
    private Long idUsuarios;

    @Column(name = "us_nome", nullable = false, length = 40)
    private static String us_nome;

    @Column(name = "us_email", nullable = false, length = 50)
    private String us_email;

    @Column(name = "us_senha", nullable = false, length = 32)
    private String us_senha;

    @Column(name = "us_fone", nullable = false, length = 20)
    private String us_fone;

    @Column(name = "us_status", nullable = false, length = 10)
    private String us_status;

    @Deprecated
    public Usuarios() {
    }
    private Usuarios(@NotNull String us_nome) {
        this.us_nome = Objects.requireNonNull(us_nome, "Nome não pode ser nulo");
    }

    public static Usuarios.UsuariosBuilder builder(@NotNull String us_nome) {
        return new Usuarios.UsuariosBuilder(us_nome);
    }

    public static class UsuariosBuilder {

        private final Usuarios usuarios;

        public UsuariosBuilder(@NotNull String us_nome) {
            this.usuarios = new Usuarios(us_nome);
        }

        public Usuarios.UsuariosBuilder us_email(String us_email) {
            this.usuarios.us_email = us_email;
            return this;
        }
        public Usuarios.UsuariosBuilder us_senha(String us_senha) {
            this.usuarios.us_senha = us_senha;
            return this;
        }

        public Usuarios.UsuariosBuilder us_fone(String us_fone) {
            this.usuarios.us_fone = us_fone;
            return this;
        }

        public Usuarios.UsuariosBuilder us_status(String us_status) {
            this.usuarios.us_status = us_status;
            return this;
        }

        public Usuarios build() {
            return this.usuarios;
        }

    }

    public Long getIdUsuarios() {
        return idUsuarios;
    }

    public static String getUs_nome() {
        return us_nome;
    }

    public String getUs_email() {
        return us_email;
    }

    public String getUs_senha() {
        return us_senha;
    }

    public String getUs_fone() {
        return us_fone;
    }

    public String getUs_status() {
        return us_status;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuarios usuarios = (Usuarios) o;
        return us_nome.equals(Usuarios.us_nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(us_nome);
    }

}
