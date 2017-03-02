package marathon.domain;

public class Team {
	private int id;
	private String leagueName;
	private String teamName;
	private String headquarters;
	private String inauguration;
	private String history;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String league_name) {
		this.leagueName = league_name;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String team_name) {
		this.teamName = team_name;
	}
	public String getHeadquarters() {
		return headquarters;
	}
	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}
	public String getInauguration() {
		return inauguration;
	}
	public void setInauguration(String inauguration) {
		this.inauguration = inauguration;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	

}
