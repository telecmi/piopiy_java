package com.telecmi.piopiy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * Servlet implementation class PlayAudio
 */
@WebServlet("/RouteCall")
public class RouteCall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RouteCall() {
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
		JSONObject queue = new JSONObject();
	    JSONObject queueProp = new JSONObject();
	    
	    JSONArray call = new JSONArray();
	    call.add(9894);
	    call.add(9677);
	    queueProp.put("record", true);
	    queueProp.put("ringback","https://example.com/music/waiting.wav");
	    queueProp.put("call",call);
	    queue.put("queue",queueProp);
	    
	    response.setContentType("application/json");
	    response.setCharacterEncoding("utf-8");
	    
	    PrintWriter out = response.getWriter();
	    
	    out.print(queue);
		out.flush();
	}
	
	

}
