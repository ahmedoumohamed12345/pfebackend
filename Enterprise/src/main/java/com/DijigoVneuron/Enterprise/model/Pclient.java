package com.DijigoVneuron.Enterprise.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Table(name="prepayee_client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pclient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "id_enterprise_b2b")
    private String identer;
    @Column (name="mail")
    private String mail;
    @Column (name = "tel")
    private String tel;
    @Column (name = "type")
    private String type;
    @Column (name = "sla")
    private String sla;

}
