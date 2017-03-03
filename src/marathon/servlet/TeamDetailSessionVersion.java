package marathon.servlet;
//FIXME: パッケージ名のスペルが違います。それと、サーブレットクラスは、servletパッケージなど、別のパッケージに入れた方がいいのでは？

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import marathon.dao.DBmanager;
import net.arnx.jsonic.JSON;

/**
 * Servlet implementation class TeamDetail
 */
@WebServlet("/TeamDetailSessionVersion")
//FIXME: "Ver"Sessionって、どういう意味・・・？意味の通じないクラス名は適切ではありません。
public class TeamDetailSessionVersion extends HttpServlet {
	//TeamDetailServlet_SessionVersion
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeamDetailSessionVersion() {
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
