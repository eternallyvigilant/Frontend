

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class SendReceive
 */
public class SendReceive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendReceive() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		PrintWriter pw=response.getWriter();
		
		Enumeration e1=request.getParameterNames();
		Set s1=new LinkedHashSet();
		Set s2=new LinkedHashSet();
		
		while(e1.hasMoreElements())
		{	System.out.println("Hi");
			String name=(String) e1.nextElement();
			String value=request.getParameter(name);
			System.out.println(name + " : "+value);
			s1.add(value);
			s2.add(name);
		
		}
		List a=new ArrayList(s1);
		List b=new ArrayList(s2);
		System.out.println(a);
		System.out.println(b);
		System.out.println(a.get(0));
		DAO d1=new DAO();
		d1.instantiate();
		d1.addEmployee(Integer.parseInt(a.get(0).toString()),a.get(1).toString(),a.get(2).toString(),a.get(3).toString(),a.get(4).toString(),a.get(5).toString(),a.get(6).toString(),a.get(7).toString(),a.get(8).toString(),a.get(9).toString(),a.get(10).toString(),a.get(11).toString(),a.get(12).toString());
		
	}

}
