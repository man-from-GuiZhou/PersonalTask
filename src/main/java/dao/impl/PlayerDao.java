package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;

import bean.Player;
import util.JDBCUtils;

public class PlayerDao {
	
	
	public LinkedList<Player> selectPlayerList(){
		LinkedList<Player> playList = new LinkedList<Player>();
		Player tempPlayer;
		try {
			java.sql.Connection conn = JDBCUtils.getConnection();
			String sql="select * from profile";
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) {
				tempPlayer = new Player();
				tempPlayer.setPlayerId(rs.getInt(1));
				tempPlayer.setPlayerName(rs.getString(2));
				tempPlayer.setPlayerId(rs.getInt(3));
				playList.add(tempPlayer);
				return playList;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
