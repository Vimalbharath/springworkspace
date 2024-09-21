//package com.htc.project.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name="captain")
//public class Captain extends Player {
//
//    @OneToOne
//    @JoinColumn(name="teamid")
//    private Team team;
//
//	public Captain(Team team) {
//		super();
//		this.team = team;
//	}
//
//	public Team getTeam() {
//		return team;
//	}
//
//	public void setTeam(Team team) {
//		this.team = team;
//	}
//
//	public Captain() {
//		super();
//	}
//
//	@Override
//	public String toString() {
//		return "Captain [team=" + team + "]";
//	}
//    
//    
//}