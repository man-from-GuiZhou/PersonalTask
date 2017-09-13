package bean;

public class Player {
	
	private int playerId;
	private String playerName;
	private int Exp;
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getExp() {
		return Exp;
	}
	public void setExp(int exp) {
		Exp = exp;
	}
	
	public String toString() {
		return ""+this.playerId+" "+this.playerName+" "+this.Exp;
	}
	
}
