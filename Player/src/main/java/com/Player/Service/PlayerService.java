package com.Player.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Player.Entity.Player;
import com.Player.Repository.PlayerRepository;
import com.Player.dao.ResponseTemplateVO;
import com.Player.dao.Team;


@Service
public class PlayerService {

	@Autowired
	private PlayerRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Player saveData(Player player) {
		return repository.save(player);
	}
	public Player getDataById(Long playerId) {
		return repository.findByPlayerId(playerId);
	}
	public List<Player>getAllData(){
		return (List<Player>) repository.findAll();
	}
	
	public ResponseTemplateVO getTeamByPlayerId(Long playerId) {
		ResponseTemplateVO vo=new ResponseTemplateVO();
		Player player=repository.findByPlayerId(playerId);
		
		Team team = restTemplate.getForObject("http://localhost:8999/team/"+player.getTeamName(),Team.class);
		vo.setPlayer(player);
		vo.setTeam(team);
		return vo;
	}
	
	}