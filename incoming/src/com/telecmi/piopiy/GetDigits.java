package com.telecmi.piopiy;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;


@WebServlet("/GetDigits")
public class GetDigits extends HttpServlet {
 
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    String did = request.getParameter("did");
    String from = request.getParameter("from");
    System.out.println(from);
    System.out.println(did);
    JSONObject get = new JSONObject();
    JSONObject prop = new JSONObject();

    prop.put("min", 1);
    prop.put("max", 4);
    prop.put("retry", 3);
    prop.put("start", "http://8ed8c9c9.ngrok.io/table.wav");
    prop.put("invalid", "http://8ed8c9c9.ngrok.io/invalid.wav");
    prop.put("post", "http://8ed8c9c9.ngrok.io/nextivr");

    get.put("get",prop);
    
    response.setContentType("application/json");
    response.setCharacterEncoding("utf-8");
    
    PrintWriter out = response.getWriter();
    
    out.print(get);
    out.flush();
  }

}

    