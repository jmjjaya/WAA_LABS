package edu.mum;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculatorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		// Allocate a output writer to write the response message into the network
		// socket
		PrintWriter out = response.getWriter();
		// Write the response message, in an HTML page
		
		try {
			out.println("<!DOCTYPE html>");
			out.println("<html><head>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			out.println("<title>Calculator</title></head>");
			out.println("<body>");
			out.println("<h1>Hello, world!</h1>"); // says Hello
			// Echo client's request information
			out.println("<form action = \"CalculatorServlet\" method=\"post\">");
			out.println("<input type=\"text\" name=\"addNumberOne\" value=" + request.getAttribute("addNumberOne")
					+ "> + <input type=\"text\" name=\"addNumberTwo\" value = " + request.getAttribute("addNumberTwo")
					+ "> = <input type=\"text\" name=\"sum\" value= " + request.getAttribute("sum") + "><br>");
			out.println(
					"<input type=\"text\" name=\"mulNumberOne\" value=" + request.getAttribute("mulNumberOne") + "> * <input type=\"text\" name=\"mulNumberTwo\" value=" + request.getAttribute("mulNumberTwo") + "> = <input type=\"text\" name=\"mul\" value=" + request.getAttribute("mul") + "><br>");
			out.println("<input type=\"submit\" value=\"Submit\">");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close(); // Always close the output writer
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//addition
		Integer addNumOne = Integer.parseInt(request.getParameter("addNumberOne"));
		Integer addNumTwo = Integer.parseInt(request.getParameter("addNumberTwo"));
		if (addNumOne != null && addNumTwo != null) {
			request.setAttribute("addNumberOne", addNumOne);
			request.setAttribute("addNumberTwo", addNumTwo);
			int sum = addNumOne + addNumTwo;
			request.setAttribute("sum", sum);
		}
		
		Integer mulNumOne = Integer.parseInt(request.getParameter("mulNumberOne"));
		Integer mulNumTwo = Integer.parseInt(request.getParameter("mulNumberTwo"));
		if (mulNumOne != null && mulNumTwo != null) {
			request.setAttribute("mulNumberOne", mulNumOne);
			request.setAttribute("mulNumberTwo", mulNumTwo);
			int mul = mulNumOne * mulNumTwo;
			request.setAttribute("mul", mul);
		}
		doGet(request, response);
	}

}
