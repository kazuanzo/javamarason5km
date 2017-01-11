package marason.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import marason.domain.Team;

public class DBmanager {
	//FIXME: このクラスがサーブレットと同じパッケージにあるのは不自然。
	private String driver = "com.mysql.jdbc.Driver";
	private String sql = "select * from baseball_teams where id =";
	private String url = "jdbc:mysql://localhost/data1";;
	private String user = "hoge";
	private String password = "adeba255@";
	private Connection connection;
	private Statement statement;
	private ResultSet rs;
	//FIXME: 謎の配列h...<削除しました。

	ArrayList<Team> teamlist = new ArrayList<>();
	Team team = new Team();

	public ArrayList<Team> allTeam() {
		//FIXME: 定数はここではなく、変数宣言時にセットされるべき<修正しました。

		try {
			
			Class.forName(driver);//FIXME: この行意味ある？<Driver自身をDriverManagerに登録する処理のため必要なようです。

			// DB接続処理
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			//FIXME: ここでnullを入れるのはなぜ？＜修正しました。
			// sql文
			rs = statement.executeQuery(sql + "id;");

			while (rs.next()) {
				Team team = new Team();//FIXME: 変数名がteaでは、別の意味（お茶）になる＜修正しました。
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
	 //FIXME: 謎の空白行＜修正しました
	
	public ArrayList<Team> getTeamlist() {
		return teamlist;
	}

	public Team getTeam() {
		return team;
	}

}