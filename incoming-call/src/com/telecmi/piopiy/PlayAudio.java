package com.telecmi.piopiy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class PlayAudio
 */
@WebServlet("/PlayAudio")
public class PlayAudio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayAudio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String did = request.getParameter("did");
		String from = request.getParameter("from");
		System.out.println(from);
		System.out.println(did);
		JSONObject play = new JSONObject();
		JSONObject url = new JSONObject();
		
		url.put("url", "http://8ed8c9c9.ngrok.io/telecmi/waiting.wav");
		play.put("play",url);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(play);
		out.flush();
	}
	
	

}
