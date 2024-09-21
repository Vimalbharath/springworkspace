package com.example.demosecurity.entity;
import java.util.Date;
import java.util.Timer;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

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
	    
	    private boolean isPlayed;
		public Match(int matchid, Date date,  boolean isPlayed) {
			super();
			this.matchid = matchid;
			this.date = date;
			
			this.isPlayed = isPlayed;
		}
		public Match() {
			super();
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
		
		public boolean isPlayed() {
			return isPlayed;
		}
		public void setPlayed(boolean isPlayed) {
			this.isPlayed = isPlayed;
		}

	    
	
	
}