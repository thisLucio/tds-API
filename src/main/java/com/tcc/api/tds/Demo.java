package com.tcc.api.tds;

import com.tcc.api.tds.models.Post;
import com.tcc.api.tds.models.Usuarios;
import com.tcc.api.tds.repository.PostRepository;
import com.tcc.api.tds.repository.UsuariosRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Repository;

@Repository
public class Demo implements ApplicationRunner {


    private final PostRepository postRepository;
    private final UsuariosRepository usuariosRepository;

    public Demo( PostRepository postRepository, UsuariosRepository usuariosRepository) {
        this.postRepository = postRepository;
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var post = Post.of(
                "Banco de dados MySQL com Spring Boot",
                "O MySQL é um sistema de gerenciamento de banco de dados...",
                "O MySQL é um sistema de gerenciamento de banco de dados, que utiliza a linguagem SQL como interface. É atualmente um dos sistemas de gerenciamento de bancos de dados mais populares..."
        );


        var usuarios = Usuarios.builder("xicao")
                .us_email("xicao2.top@gmail.com")
                .us_fone("xxxx")
                .us_senha("123")
                .us_status("1")
                .build();
        usuariosRepository.save(usuarios);
        post.addUsuarios(usuarios);

        postRepository.save(post);


    }

}
