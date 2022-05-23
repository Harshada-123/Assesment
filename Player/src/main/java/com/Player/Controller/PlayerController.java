package com.Player.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Player.Entity.Player;
import com.Player.Service.PlayerService;
import com.Player.dao.ResponseTemplateVO;

@RestController
@CrossOrigin(origins="*")
public class PlayerController {

	@Autowired
	private PlayerService service;
	
	@PostMapping("/saveData")
	public Player saveData(@RequestBody Player player) {
		return service.saveData(player);
	}
	@GetMapping("/player/{id}")
	public ResponseEntity<Player> getDataById(@PathVariable("id") Long playerId){
		return ResponseEntity.ok(service.getDataById(playerId));
	}
	@GetMapping("/getAllData")
	public ResponseEntity<List<Player>> getAllData(){
		return ResponseEntity.ok(service.getAllData());
	}
	@GetMapping("/byid/{id}")
	public ResponseTemplateVO getTeamByPlayerId(@PathVariable("id") Long playerId) {
		return service.getTeamByPlayerId(playerId);
	}
	}