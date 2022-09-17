package com.DijigoVneuron.Enterprise.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client_pro")
public class Clientpro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "ent_raison")
    private String raison;
    @Column(name = "ent_matricule")
    private String matricule;
    @Column(name = "ent_image_rne",length = 100000)
    private byte[] imagerne;
    @Column(name = "ent_rep_nom")
    private String repnom;
    @Column(name = "ent_rep_prenom")
    private String repprenom;
    @Column(name = "ent_rep_mail")
    private String repmail;
    @Column(name = "ent_rep_tel")
    private String reptel;
    @Column(name = "ent_rep_type_id")
    private String reptypeid;
    @Column(name = "ent_rep_numid")
    private String repnumid;
    @Column(name = "ent_rep_natio")
    private String renatio;
    @Column (name = "ent_rep_paysenrg")
    private String reppaysenrg;
    @Column (name = "ent_rep_image_id",length = 100000)
    private byte[] imagerepid;
    @Column(name = "mail")
    private String mail;



}
