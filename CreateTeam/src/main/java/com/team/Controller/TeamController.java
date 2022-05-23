package com.team.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.Entity.Team;
import com.team.Service.TeamService;

@RestController
@RequestMapping("/team")
@CrossOrigin(origins="*")

public class TeamController {

	@Autowired
	private TeamService service;
	@PostMapping("/saveTeam")
	public ResponseEntity<String> saveData(@RequestBody Team team){
		service.saveTeam(team);
		return ResponseEntity.ok("Data Saved");
		
	}
	@GetMapping("/getAllTeam")
	public ResponseEntity<List<Team>> getAllData(){
		return  ResponseEntity.ok(service.getAllTeam());
			
		}
	@GetMapping("/{teamName}")
	public Team findTeamByName(@PathVariable("teamName") String teamName) {
		return service.FindTeamByName(teamName);
	}
	
}

