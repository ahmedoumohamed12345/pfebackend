package com.DijigoVneuron.Enterprise.Repository;


import com.DijigoVneuron.Enterprise.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Utilisateur findByLogin(String login);
}
