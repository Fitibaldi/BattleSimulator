/**
 * Main class for the game.
 * Holds the UI and simulate method
 */
package com.swift.java.battle.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.swing.LayoutFocusTraversalPolicy;

import com.swift.java.battle.characters.CharactersFactory;
import com.swift.java.battle.characters.Human;
import com.swift.java.battle.characters.Race;
import com.swift.java.battle.characters.Troll;
import com.swift.java.battle.db.DBOperations;
import com.swift.java.battle.dto.BattleDto;
import com.swift.java.battle.dto.BattleLogDto;

public class Battle {

	public static void main(String[] args) {
		simulateBattle(5, 6);

	}

	private static void simulateBattle(int humansCount, int trollsCount) {
		Queue<Troll> trolls = CharactersFactory.createTrolls(trollsCount);
		Queue<Human> humans = CharactersFactory.createHumans(humansCount);
		BattleDto battle = new BattleDto(humansCount, trollsCount);
		List<BattleLogDto> battleLog = new ArrayList<BattleLogDto>();
		Race attacker = Race.HUMANS;
		int round = 0;

		// first round - we are extracting the first enemies
		Troll troll = trolls.poll();
		Human human = humans.poll();
		while (true) {
			// changing the attacker
			attacker = Race.TROLLS.equals(attacker) ? Race.HUMANS : Race.TROLLS;

			// save log
			battleLog.add(new BattleLogDto(++round, human.getHealth(), troll.getHealth(), attacker, humans.size() + 1,
					trolls.size() + 1));

			// attack
			if (Race.TROLLS.equals(attacker)) {
				human.attacked(troll);
				if (human.isDeath()) {
					if (!humans.isEmpty()) {
						human = humans.poll();
					} else {
						battle.setWinner(Race.TROLLS);
						break;
					}
				}
			} else {
				troll.attacked(human);
				if (troll.isDeath()) {
					if (!trolls.isEmpty()) {
						troll = trolls.poll();
					} else {
						battle.setWinner(Race.HUMANS);
						break;
					}
				}
			}
		}

		// print in the console
		printLog(battle, battleLog);
		// save to the database
		DBOperations.saveToDatabase(battle, battleLog);
	}

	private static void printLog(BattleDto battle, List<BattleLogDto> battleLog) {
		System.out.println(battle.print());
		System.out.println(BattleLogDto.printHeader());
		for (BattleLogDto log : battleLog) {
			System.out.println(log.print());
		}
		System.out.println(battle.print());
	}

}
