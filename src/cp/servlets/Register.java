package cp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cp.controllers.ConnectionDB;
import cp.helpers.Hashing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * Servlet implementation class Register
 */
@MultipartConfig()
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter();
		out.print(" esto es la respuesta para el cliente");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.addHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String ci = request.getParameter("cedula");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		System.out.println("nombre: "+name);
		System.out.println(pass);
		String h = Hashing.hashPass(pass);
		System.out.println(h);
		
		
		try {

			Connection conexion = ConnectionDB.startConn();
			PreparedStatement ps1 = conexion.prepareStatement("INSERT INTO usuarios VALUES (?, ?, ?, ?, ?, ?)");
			ps1.setString(1, name);
			ps1.setString(2, age);
			ps1.setString(3, ci);
			ps1.setString(4, username);
			ps1.setString(5, email);
			ps1.setString(6, h);
			ps1.execute();
			out.println("{\"message\":\"Usuario creado satisfactoriamente\", \"status\": 200}");
			ps1.close();
		 } catch (SQLException e) {
			out.println("{\"message\":\"error\"}");	
		 }
	}

	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
}
