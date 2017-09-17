package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Player;
import dao.PlayerDaoInter;

/**
 * Servlet implementation class PlayerEdit
 */

@WebServlet("/PlayerEdit")
public class PlayerEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerEdit() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.functionWay(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		this.functionWay(request, response);
		//this.addPlayer(request, response);
		request.getRequestDispatcher("init.do").forward(request, response);
	}
	
	private void functionWay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operate = request.getParameter("operate");
		switch(operate) {
		case "add":this.addPlayer(request, response);
			break;
		case "remove":this.removePlayer(request, response);
			break;
		case "updatePage":
			//Player pInfo = request.getParameter("Player");
			//request.setAttribute("Player", pInfo);
			request.getRequestDispatcher("/PlayerEdit.jsp").forward(request, response);
			break;
		}
	}
	
	private void addPlayer(HttpServletRequest request, HttpServletResponse response) {
		String playerName = request.getParameter("PlayerName");
		String password = request.getParameter("password");
		PlayerDaoInter pdi;
		try {
			pdi = (PlayerDaoInter) Class.forName("dao.impl.PlayerDao").newInstance();
			pdi.addPlayer(playerName, password);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void removePlayer(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("PlayerId"));
		PlayerDaoInter pdi;
		try {
			pdi=(PlayerDaoInter) Class.forName("dao.impl.PlayerDao").newInstance();
			pdi.removePlayer(id);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
