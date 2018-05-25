/**
 * Base class for the Characters in the game
 */

package com.swift.java.battle.characters;

public abstract class Character {
	private int power;
	private int health;
	private boolean death = false;


	public void attacked(Character attacker) {
		this.health -= attacker.power;
		if (health <= 0) {
			death = true;
		}
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	public boolean isDeath() {
		return death;
	}
}
