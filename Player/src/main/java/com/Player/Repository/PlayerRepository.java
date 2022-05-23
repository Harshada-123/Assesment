package com.Player.Repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.Player.Entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long>{

	public Player findByPlayerId(Long playerId);
}