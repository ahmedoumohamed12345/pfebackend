package com.DijigoVneuron.Enterprise.model;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name ="demande")
public class Demande {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "id_client")
    private Long idc;
    @Column(name = "sla")
    private String sla;
    @Column(name = "type")
    private String type;
    @Column(name = "rendezvous")
    private String rendezvous;
    @Column(name = "statut_demande")
    private String statud;
    @Column(name = "statut_rendez")
    private String statur;
    @Column(name = "date")
    private String date;
    @Column(name = "lien")
    private String lien;
}
