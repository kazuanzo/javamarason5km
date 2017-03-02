package marason.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import marason.domain.Team;

public class DBmanager {
	private String driver = "com.mysql.jdbc.Driver";
	private String sql = "select * from baseball_teams where id =";
	private String url = "jdbc:mysql://localhost/data1";;
	private String user = "hoge";
	private String password = "adeba255@";
	private Connection connection;
	private Statement statement;
	private ResultSet rs;

	ArrayList<Team> teamlist = new ArrayList<>();
	Team team = new Team();

	public ArrayList<Team> allTeam() {

		try {
			
			Class.forName(driver);

			// DB接続処理
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			// sql文
			rs = statement.executeQuery(sql + "id;");

			while (rs.next()) {
				Team team = new Team();
				team.setId(rs.getInt("id"));
				team.setTeamName(rs.getString("team_name"));
				team.setLeagueName(rs.getString("league_name"));
				team.setHeadquarters(rs.getString("headquarters"));
				team.setInauguration(rs.getString("inauguration"));
				team.setHistory(rs.getString("history"));
				teamlist.add(team);
			}

		} catch (SQLException e) {
			System.out.println("SQLEROOR");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ERORR");
		}

		return teamlist;

	}

	public Team selectTeam(String JsTeam) {
		try {
			Class.forName(driver); // ドライバ登録処理

			// DB接続処理
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			// sql文
			rs = statement.executeQuery(sql + JsTeam + ";");
			
			while (rs.next()) {
				
				team.setId(rs.getInt("id"));
				team.setTeamName(rs.getString("team_name"));
				team.setLeagueName(rs.getString("league_name"));
				team.setHeadquarters(rs.getString("headquarters"));
				team.setInauguration(rs.getString("inauguration"));
				team.setHistory(rs.getString("history"));
			
			}
		} catch (SQLException e) {
			System.out.println("SQLEROOR");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ERORR");
		}

		return team;
		
	}
	
	public ArrayList<Team> getTeamlist() {
		return teamlist;
	}

	public Team getTeam() {
		return team;
	}

}
