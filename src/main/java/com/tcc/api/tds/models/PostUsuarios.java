package com.tcc.api.tds.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "POST_USUARIOS")
public class PostUsuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuarios")
    private Usuarios usuarios;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_POST")
    private Post post;

    @Deprecated
    public PostUsuarios() {
    }

    private PostUsuarios(@NotNull Usuarios usuarios, @NotNull Post post) {
        this.usuarios = Objects.requireNonNull(usuarios, "usuarios must not be null");
        this.post = Objects.requireNonNull(post, "post must not be null");
    }

    public static PostUsuarios of(@NotNull Usuarios usuarios, @NotNull Post post) {
        return new PostUsuarios(usuarios, post);
    }

    public Long getId() {
        return id;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public Post getPost() {
        return post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostUsuarios that = (PostUsuarios) o;
        return Objects.equals(usuarios, that.usuarios) && Objects.equals(post, that.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarios, post);
    }

}
