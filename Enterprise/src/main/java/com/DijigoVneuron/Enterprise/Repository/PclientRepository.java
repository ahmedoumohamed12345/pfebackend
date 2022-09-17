package com.DijigoVneuron.Enterprise.Repository;

import com.DijigoVneuron.Enterprise.model.Pclient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PclientRepository extends JpaRepository<Pclient,Long> {
Pclient findByMail(String mail);
List<Pclient> findByIdenter(String identer);
}
