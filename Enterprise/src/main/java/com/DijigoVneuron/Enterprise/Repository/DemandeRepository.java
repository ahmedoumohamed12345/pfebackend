package com.DijigoVneuron.Enterprise.Repository;

import com.DijigoVneuron.Enterprise.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
    Optional<Demande> findById(Long id);
    Demande findByIdc(Long id);
}
