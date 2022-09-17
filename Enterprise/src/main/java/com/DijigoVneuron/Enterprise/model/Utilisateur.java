package com.DijigoVneuron.Enterprise.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Table(name ="utilisateur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String passw;
    @Column(name = "role")
    private String role;
    @Column (name="id_utilisateur")
    private Long idutili;

}
