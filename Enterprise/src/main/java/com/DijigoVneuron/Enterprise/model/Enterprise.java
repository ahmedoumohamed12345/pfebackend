package com.DijigoVneuron.Enterprise.model;


import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
@Builder
@Entity
@Table(name="entreprise_b2b")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Enterprise {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(name = "raison")
    private String raison;
    @Column(name = "nombre_certificat")
    private int nbcrtif;
    @Column(name = "respo_b2b_id")
    private String respo_b2b;
    @Column(name = "mail")
    private  String mail;














}
