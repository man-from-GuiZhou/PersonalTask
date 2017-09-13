package controller;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Player;
import dao.impl.PlayerDao;

/**
 * Servlet implementation class IndexController
 */ 

public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet exe!");
		PlayerDao pDao = new PlayerDao();
		LinkedList<Player> PlayList = pDao.selectPlayerList();
		System.out.println("servlet got: "+PlayList.getFirst().toString());
		HttpSession session = request.getSession(); 
		session.setAttribute("profileList", PlayList); 
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	
	public void init() throws ServletException {
		System.out.println("doGet exe!");
		PlayerDao pDao = new PlayerDao();
		LinkedList<Player> PlayList = pDao.selectPlayerList();
		System.out.println("servlet got: "+PlayList.getFirst().toString());
		HttpSession session = null; 
		session.setAttribute("profileList", PlayList); 
	}
}
