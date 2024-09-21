package com.htc.project.model;

import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="details")
public class Details {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="detailsid")
    private int detailsid;

    @OneToOne
    @JoinColumn(name="matchid")
    private Match match;

    private String toss;
    private int innings1Score;
    private int innings2Score;
    @ManyToOne
    @JoinColumn(name="winner")
    private Team winner;
    @ManyToOne
    @JoinColumn(name="manofmatch")
    private Player manOfTheMatch ;
	public Details() {
		super();
	}
	public Details( Match match, String toss, int innings1Score, int innings2Score,
			Team winner, Player manOfTheMatch) {
		super();
		
		this.match = match;
		this.toss = toss;
		this.innings1Score = innings1Score;
		this.innings2Score = innings2Score;
		this.winner = winner;
		this.manOfTheMatch = manOfTheMatch;
	}

	public int getDetailsid() {
		return detailsid;
	}
	public void setDetailsid(int detailsid) {
		this.detailsid = detailsid;
	}
	public Match getMatch() {
		return match;
	}
	public void setMatch(Match match) {
		this.match = match;
	}
	public String getToss() {
		return toss;
	}
	public void setToss(String toss) {
		this.toss = toss;
	}
	public int getInnings1Score() {
		return innings1Score;
	}
	public void setInnings1Score(int innings1Score) {
		this.innings1Score = innings1Score;
	}
	public int getInnings2Score() {
		return innings2Score;
	}
	public void setInnings2Score(int innings2Score) {
		this.innings2Score = innings2Score;
	}
	public Team getWinner() {
		return winner;
	}
	public void setWinner(Team winner) {
		this.winner = winner;
	}
	public Player getManOfTheMatch() {
		return manOfTheMatch;
	}
	public void setManOfTheMatch(Player manOfTheMatch) {
		this.manOfTheMatch = manOfTheMatch;
	}
	@Override
	public String toString() {
		return "MatchPlayedDetails [playedMatchDetailsId=" + detailsid + ", match=" + match + ", toss="
				+ toss + ", innings1Score=" + innings1Score + ", innings2Score=" + innings2Score + ", winner=" + winner
				+ ", manOfTheMatch=" + manOfTheMatch + "]";
	}
	
    
}
