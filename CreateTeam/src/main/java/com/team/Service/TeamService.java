package com.team.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.Entity.Team;
import com.team.Repository.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository repository;
	
	public Team saveTeam(Team team) {
		return repository.save(team);
		
	}
	public List<Team> getAllTeam(){
		return (List<Team>) repository.findAll();
	}
	public Team FindTeamByName(String teamName) {
		return repository.findByTeamName(teamName);
	}
}

