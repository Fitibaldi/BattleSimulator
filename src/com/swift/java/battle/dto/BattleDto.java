/**
 * Data transfer object for holding the information from the database.
 * Works with table BATTLE
 */
package com.swift.java.battle.dto;

import com.swift.java.battle.characters.Race;

public class BattleDto {
	private int battleId;
	private int humansCount;
	private int trollsCount;
	private Race winner;

	public BattleDto(int humansCount, int trollsCount) {
		this.humansCount = humansCount;
		this.trollsCount = trollsCount;
	}

	public String print() {
		return "BattleId: " + battleId + " [" + humansCount + " : " + trollsCount + "]\n" + "Winner:\t" + winner;
	}

	public int getBattleId() {
		return battleId;
	}

	public void setBattleId(int battleId) {
		this.battleId = battleId;
	}

	public int getHumansCount() {
		return humansCount;
	}

	public void setHumansCount(int humansCount) {
		this.humansCount = humansCount;
	}

	public int getTrollsCount() {
		return trollsCount;
	}

	public void setTrollsCount(int trollsCount) {
		this.trollsCount = trollsCount;
	}

	public Race getWinner() {
		return winner;
	}

	public void setWinner(Race winner) {
		this.winner = winner;
	}
}
