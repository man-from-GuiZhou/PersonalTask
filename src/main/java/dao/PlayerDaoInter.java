package dao;

import java.util.LinkedList;

import bean.Player;

public interface PlayerDaoInter {
	//查找全部的用户
	public LinkedList<Player> selectPlayerList();
	//增加用户
	public void addPlayer(String PlayerName,String password);
	//删除用户
	public void removePlayer(int id);
	//修改用户
	public void updatePlayer(String PlayerName,String password);
	//查询一个用户
	public Player findByName(String PlayerName); 
} 
