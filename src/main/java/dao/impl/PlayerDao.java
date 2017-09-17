package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;

import bean.Player;
import dao.PlayerDaoInter;
import util.JDBCUtils;

public class PlayerDao implements PlayerDaoInter{
	
	
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
				tempPlayer.setPassword(rs.getString(3));
				tempPlayer.setExp(rs.getInt(4));
				playList.add(tempPlayer);
			}
			JDBCUtils.release(conn, ps, rs);
			return playList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void addPlayer(String PlayerName, String password) {
		// TODO Auto-generated method stub
		java.sql.Connection conn = JDBCUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("INSERT into profile (PlayerName,password,exp) values(?,?,?)");
			//ps.setString(arg0, arg1);
			ps.setString(1, PlayerName);
			ps.setString(2, password);
			ps.setInt(3, 0);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtils.release(conn, ps, rs);
	}

	@Override
	public void removePlayer(int id) {
		// TODO Auto-generated method stub
		java.sql.Connection conn = JDBCUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps.getConnection().prepareStatement("DELETE FROM profile WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtils.release(conn, ps, rs);
	}

	@Override
	public void updatePlayer(String PlayerName, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Player findByName(String PlayerName) {
		// TODO Auto-generated method stub
		return null;
	}
}
