package com.api.redesocial.entity.usuario;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String email;
    private String senha;

    @Enumerated
    private Roles role;

    public Usuario (String email, String senha, Roles role){
        this.email = email;
        this.senha = senha;
        this.role = role;
    }
}
