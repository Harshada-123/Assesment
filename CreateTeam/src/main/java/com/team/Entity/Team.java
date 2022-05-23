package com.team.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Team {
 
	@Id
	@Column(unique=true)
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long teamId;
	private String teamName;
	private int maxBudget;
	
	public long getTeamId() {
		return teamId;
	}
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getMaxBudget() {
		return maxBudget;
	}
	public void setMaxBudget(int maxBudget) {
		this.maxBudget = maxBudget;
	}
	public Team(long teamId, String teamName, int maxBudget) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.maxBudget = maxBudget;
	}
	
	public Team() {
		
	}
	
}
