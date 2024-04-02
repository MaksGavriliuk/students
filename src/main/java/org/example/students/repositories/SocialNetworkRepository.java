package org.example.students.repositories;

import org.example.students.entities.SocialNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SocialNetworkRepository extends JpaRepository<SocialNetwork, Long> {
}