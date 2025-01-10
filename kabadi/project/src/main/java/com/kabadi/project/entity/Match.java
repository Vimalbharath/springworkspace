package com.kabadi.project.entity;

import java.util.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="matches")
public class Match {
		@Id
	    @Column(name="matchid")
	    private int matchid;

	    @ManyToOne
	    @JoinColumn(name="team1id")  // Descriptive name for Team 1 relationship
	     Team team1;

	    @ManyToOne
	    @JoinColumn(name="team2id")  // Descriptive name for Team 2 relationship
	     Team team2;

	    private Date date;
	    
	    private int team1score;
	    private int team2score;
	    
	    private String stage;
	    private String ground;
		
		public Match() {
			super();
		}

		public Match(int matchid, Team team1, Team team2, Date date, int team1score, int team2score) {
			super();
			this.matchid = matchid;
			this.team1 = team1;
			this.team2 = team2;
			this.date = date;
			this.team1score = team1score;
			this.team2score = team2score;
		}
		

		public Match(int team1score, int team2score) {
			super();
			this.team1score = team1score;
			this.team2score = team2score;
		}

		public Match(int matchid, Team team1, Team team2, Date date) {
			super();
			this.matchid = matchid;
			this.team1 = team1;
			this.team2 = team2;
			this.date = date;
		}
		
		

		public Match(int matchid, Team team1, Team team2, Date date, String stage, String ground) {
			super();
			this.matchid = matchid;
			this.team1 = team1;
			this.team2 = team2;
			this.date = date;
			this.stage = stage;
			this.ground = ground;
		}

		public int getMatchid() {
			return matchid;
		}

		public void setMatchid(int matchid) {
			this.matchid = matchid;
		}

		public Team getTeam1() {
			return team1;
		}

		public void setTeam1(Team team1) {
			this.team1 = team1;
		}

		public Team getTeam2() {
			return team2;
		}

		public void setTeam2(Team team2) {
			this.team2 = team2;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public int getTeam1score() {
			return team1score;
		}

		public void setTeam1score(int team1score) {
			this.team1score = team1score;
		}

		public int getTeam2score() {
			return team2score;
		}

		public void setTeam2score(int team2score) {
			this.team2score = team2score;
		}

		public String getStage() {
			return stage;
		}

		public void setStage(String stage) {
			this.stage = stage;
		}

		public String getGround() {
			return ground;
		}

		public void setGround(String ground) {
			this.ground = ground;
		}
		
	    
	
	
}