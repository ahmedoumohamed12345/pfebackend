package com.DijigoVneuron.Enterprise.Repository;

import com.DijigoVneuron.Enterprise.model.Clientpro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientproRepository extends JpaRepository<Clientpro, Long> {

Clientpro findByMail(String mail);
}
