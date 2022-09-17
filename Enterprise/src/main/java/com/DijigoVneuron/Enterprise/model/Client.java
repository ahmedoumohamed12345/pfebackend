package com.DijigoVneuron.Enterprise.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Builder
@Entity
@Table(name ="client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "mail")
    private String mail;
    @Column(name = "tel")
    private String tel;
    @Column(name = "type")
    private String type;
    @Column(name = "id_client")
    private Long id_client;
    @Column(name = "typeid")
    private String typeid;
    @Column(name = "numid")
    private String numid;
    @Column(name = "natio")
    private String natio;
    @Column(name = "datenaissence")
    private String daten;
    @Column(name = "image_id", length = 100000)
    private byte[] imageid;





}
