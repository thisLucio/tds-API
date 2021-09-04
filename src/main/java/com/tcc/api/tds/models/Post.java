package com.tcc.api.tds.models;


import com.sun.istack.NotNull;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE", nullable = false, length = 100)
    private String title;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED", nullable = false)
    private LocalDate lastModified;

    @Column(name = "SUMMARY", nullable = false)
    private String summary;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;



    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private final Set<PostUsuarios> usuarios = new HashSet<>();
    @Deprecated
    public Post() {
    }

    private Post(@NotNull String title, @NotNull String summary, @NotNull String description) {
        this.title = Objects.requireNonNull(title, "title must not be null").trim();
        this.summary = Objects.requireNonNull(summary, "summary must not be null");
        this.description = Objects.requireNonNull(description, "description must not be null");
        this.lastModified = LocalDate.now();
    }

    public static Post of(@NotNull String title, @NotNull String summary, @NotNull String description) {
        return new Post(title, summary, description);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getLastModified() {
        return lastModified;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }



    public Set<PostUsuarios> getUsuarios(){
        return Collections.unmodifiableSet(usuarios);
    }

    public Post addUsuarios(Usuarios usuarios){
        this.usuarios.add(PostUsuarios.of(usuarios, this));
        return this;
    }


    @PreUpdate
    public void preUpdate() {
        lastModified = LocalDate.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

}