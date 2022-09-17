package com.DijigoVneuron.Enterprise.Repository;

import com.DijigoVneuron.Enterprise.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
   /*  List<Client> findClientByEnt(byte enterprise_id);*/
 /*  Optional<Client> findByName(String name);*/
Client findByMail(String mail);

  /* Client findByLogin(String login);*/

}
