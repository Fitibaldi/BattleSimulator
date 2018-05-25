/**
 * Class holding static methods for database operations
 */
package com.swift.java.battle.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.swift.java.battle.dto.BattleDto;
import com.swift.java.battle.dto.BattleLogDto;

public class DBOperations {

	public static void saveToDatabase(BattleDto battle, List<BattleLogDto> battleLog) {
		try {
			DBConnector.open();
			// inserts a battle into the database
			String insertQuery = "INSERT INTO battle (\n" + "    humans,\n" + "    trolls,\n" + "    winner\n"
					+ ") VALUES (?, ?, ?)";
			PreparedStatement statement = DBConnector.conn.prepareStatement(insertQuery);
			statement.setInt(1, battle.getHumansCount());
			statement.setInt(2, battle.getTrollsCount());
			statement.setString(3, battle.getWinner().toString());
			statement.executeQuery();

			// selects id for the foreign key
			String selectMaxId = "select max(id) from battle";
			statement = DBConnector.conn.prepareStatement(selectMaxId);
			ResultSet rs = statement.executeQuery();
			rs.next();
			battle.setBattleId(rs.getInt(1));
			
			String insertBattleLog ="INSERT INTO battle_log (\n" + 
					"    battle_id,\n" + 
					"    round, human_health,\n" + 
					"    troll_health, attacker,\n" + 
					"    human_army, troll_army\n" + 
					") VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			for (BattleLogDto log : battleLog) {
				statement = DBConnector.conn.prepareStatement(insertBattleLog);
				statement.setInt(1, battle.getBattleId());
				statement.setInt(2, log.getRound());
				statement.setInt(3, log.getHumanHealth());
				statement.setInt(4, log.getTrollHealth());
				statement.setString(5, log.getAttacker().toString());
				statement.setInt(6, log.getHumansRemaining());
				statement.setInt(7, log.getTrollsRemaining());
				statement.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
