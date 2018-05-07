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
@WebServlet("/DesignIVR")
public class DesignIVR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DesignIVR() {
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
		 //IVR Music
		

		    //Welcome Music 
		    JSONObject welcome = new JSONObject();
		    JSONObject wmplay = new JSONObject();
		    JSONObject wmurl = new JSONObject();
		    
		    wmurl.put("url", "http://8ed8c9c9.ngrok.io/telecmi/welcomw.wav");
		    wmplay.put("play",wmurl);
		    welcome.put("welcome",wmplay);

		    //Invalid Music 
		    JSONObject invalid = new JSONObject();
		    JSONObject implay = new JSONObject();
		    JSONObject imurl = new JSONObject();
		    
		    imurl.put("url", "http://8ed8c9c9.ngrok.io/telecmi/welcomw.wav");
		    implay.put("play",imurl);
		    invalid.put("invalid",implay);

		  //If options
		  JSONObject ifopt = new JSONObject();
		    
		  //Queue
		    JSONObject queue = new JSONObject();
		    JSONObject queueProp = new JSONObject();
		    
		    queueProp.put("record", true);
		    queueProp.put("ringback","https://example.com/music/waiting.wav");
		    JSONArray call = new JSONArray();
		    call.add(9894);
		    call.add(3939);
		    call.add(9194);

		    queueProp.put("call",call);
		    queue.put("queue",queueProp);


		  //Play Audio
		   JSONObject mplay = new JSONObject();
		   JSONObject murl = new JSONObject();
		    
		    murl.put("url", "http://8ed8c9c9.ngrok.io/telecmi/waiting.wav");
		    mplay.put("play",murl);


		  // Get DTMF
		    JSONObject http = new JSONObject();
		    JSONObject dtmfurl = new JSONObject();

		    dtmfurl.put("method", "POST");
		    dtmfurl.put("url", "http://8ed8c9c9.ngrok.io/nextivr");

		    http.put("http",dtmfurl);


		  // Repeat IVR
		  JSONObject replay = new JSONObject();
		  replay.put("replay",true);

		  // Hangup 
		  JSONObject hangup = new JSONObject();
		  hangup.put("hangup",true);

		  ifopt.put("1",queue);
		  ifopt.put("2",mplay);
		  ifopt.put("3",http);
		  ifopt.put("9",replay);

		//IVR Design
		JSONObject ivr = new JSONObject();
		ivr.put("min",1);
		ivr.put("max",2);
		ivr.put("retry",2);
		ivr.put("welcome",welcome);
		ivr.put("invalid",invalid);
		ivr.put("if",ifopt);
		
		//Design IVR
		JSONObject designIVR = new JSONObject();
		
		designIVR.put("ivr", ivr);
	    
	    response.setContentType("application/json");
	    response.setCharacterEncoding("utf-8");
	    
	    PrintWriter out = response.getWriter();
	    
	    out.print(ivr);
		out.flush();
	}
	
	

}
