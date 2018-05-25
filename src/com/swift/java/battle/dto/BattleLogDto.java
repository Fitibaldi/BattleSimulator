/**
 * Data transfer object for holding the information from the database.
 * Works with table BATTLE_LOG
 */
package com.swift.java.battle.dto;

import com.swift.java.battle.characters.Race;

public class BattleLogDto {
	private int round;
	private int humanHealth;
	private int trollHealth;
	private Race attacker;
	private int humansRemaining;
	private int trollsRemaining;

	public BattleLogDto(int round, int humanHealth, int trollHealth, Race attacker, int humansRemaining,
			int trollsRemaining) {
		this.round = round;
		this.humanHealth = humanHealth;
		this.trollHealth = trollHealth;
		this.attacker = attacker;
		this.humansRemaining = humansRemaining;
		this.trollsRemaining = trollsRemaining;
	}

	public String print() {
		return round + "\t" + humanHealth + "\t" + trollHealth + "\t" + attacker + "\t" + humansRemaining + "\t"
				+ trollsRemaining;
	}

	public static String printHeader() {
		return "round\thuman\ttroll\tatt\tRem H\tRem T";
	}

	public int getRound() {
		return round;
	}

	public int getHumanHealth() {
		return humanHealth;
	}

	public int getTrollHealth() {
		return trollHealth;
	}

	public Race getAttacker() {
		return attacker;
	}

	public int getHumansRemaining() {
		return humansRemaining;
	}

	public int getTrollsRemaining() {
		return trollsRemaining;
	}
	
	

}
