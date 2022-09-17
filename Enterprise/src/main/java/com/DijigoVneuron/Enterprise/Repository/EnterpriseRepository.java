package com.DijigoVneuron.Enterprise.Repository;

import com.DijigoVneuron.Enterprise.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    /*Enterprise findByLogin(String login);
    Enterprise findByRaisonsocial(String enter);*/
Enterprise findByMail(String mail);
Enterprise findByRaison(String raison);
}
