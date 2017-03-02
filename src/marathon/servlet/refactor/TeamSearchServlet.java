package marathon.servlet.refactor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import marathon.constant.Constant;
import marathon.dao.DBmanager;
import net.arnx.jsonic.JSON;

/**
 * Servlet implementation class TeamSearchServlet
 */
@WebServlet("/TeamSearchServlet")
public class TeamSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//FIXME: 以下を追加開発
				
				//Json形式の値
				String jsonValue;
				
				//リクエストパラメータから値を取得
				String searchType = request.getParameter("search_type");
				DBmanager dbm = new DBmanager();
				
				//値からチームリストかチーム詳細かを判断
				if(searchType==null){
					//全ての野球チームを取得
					dbm.allTeam();
					
					//値をJson形式にして格納
					jsonValue = JSON.encode(dbm.getTeamlist());
				}else {
					//IDを基に野球チームを取得
					dbm.selectTeam(searchType);
					
					//値をJson形式にして格納
					jsonValue = JSON.encode(dbm.getTeam());
				}

				
				//Javaのストリームの「Content-Type」を設定
				response.setContentType(Constant.ContentType); //FIXME: この値は他のサーブレットでも使っていますよね。こういうものは定数クラスを作成し、public static finalで宣言した変数を使用した方がいいです。
				//設定したJavaのストリームを取得
				PrintWriter out = response.getWriter();
				//Javaのストリームを利用しJsonの値を出力
				out.print(jsonValue);		
		
		//パラメータから、1チームのみを取得するか、すべてのチームを取得するかを判定
		//取得結果を返す
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
