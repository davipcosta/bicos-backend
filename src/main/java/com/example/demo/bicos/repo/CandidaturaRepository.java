package com.example.demo.bicos.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bicos.models.Bicos;
import com.example.demo.bicos.models.Candidatura;
import com.example.demo.bicos.models.User;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {
    boolean existsByUserAndBicos(User user, Bicos bicos);
}
