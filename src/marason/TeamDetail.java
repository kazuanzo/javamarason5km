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
@WebServlet("/TeamDetail")
public class TeamDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TeamDetail() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// jsonの値を取得
		String json = request.getParameter("template_id");
		
		// DBmanagerインスタンス作成
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
