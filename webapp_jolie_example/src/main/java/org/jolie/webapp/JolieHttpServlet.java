package org.jolie.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jolie.ejb.Types.GreetingsRequest;
import org.jolie.ejb.Types.GreetingsResponse;
import org.jolie.ejb.interfaces.MyServiceInterface;

import jolie.runtime.FaultException;



@WebServlet("/test")
public class JolieHttpServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB(lookup="ejb:ear-jolie-example-ear-test-jolie/ejb-jolie-example-0.0.1/MyServiceImpl!org.jolie.ejb.interfaces.MyServiceInterface")
	private MyServiceInterface myServiceImpl;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GreetingsRequest greq = new GreetingsRequest();
		
		GreetingsResponse gres ;
	    try {
	    	gres = myServiceImpl.greetings(greq);
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<h1>" + gres.getGreetings() + "</h1>");
		} catch (FaultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
