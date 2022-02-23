package com.dardell.businesscard.repo;

import com.dardell.businesscard.model.Me;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MeRepo extends JpaRepository<Me, Long> {
    void deleteMeById(Long id);

    Optional<Me> findMeById(Long id);
}
