package marason;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import marason.dao.DBmanager;
import net.arnx.jsonic.JSON;

/**
 * Servlet implementation class TeamDetail
 */
@WebServlet("/TeamDetailVerSession")
//FIXME: "2"って、何をするサーブレットなのかな・・・？一応、提出物なので、意味のわかる命名をしましょう。＜名称変更しました。
public class TeamDetailVerSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeamDetailVerSession() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String json = request.getParameter("template_id");
		DBmanager dbm = new DBmanager();
		dbm.selectTeam(json);

		String text = JSON.encode(dbm.getTeam());

		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(text);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
