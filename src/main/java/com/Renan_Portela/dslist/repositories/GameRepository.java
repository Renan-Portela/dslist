package com.Renan_Portela.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Renan_Portela.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
