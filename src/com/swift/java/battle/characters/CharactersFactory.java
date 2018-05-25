/**
 * Factory class for returning Deques for the both races
 */
package com.swift.java.battle.characters;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public final class CharactersFactory {
	public static Queue<Human> createHumans(int count) {
		Queue<Human> list = new ArrayDeque<Human>();
		for (int i = 0; i < count; i++) {
			list.add(new Human());
		}
		return list;
	}
	public static Queue<Troll> createTrolls(int count) {
		Queue<Troll> list = new ArrayDeque<Troll>();
		for (int i = 0; i < count; i++) {
			list.add(new Troll());
		}
		return list;
	}

}
