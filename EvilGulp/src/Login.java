

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.Storeuser;
import customTools.DBUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    public List<Storeuser> getUser() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<model.Storeuser> user = em
				.createQuery("Select s from Storeuser s order by s.username desc",
						model.Storeuser.class).setMaxResults(20).getResultList();
		return user;
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String output = "";
		String user = "";
		String pwd = "";
		
		List<Storeuser> userdata = getUser();
		
		user = request.getParameter("user");
		pwd = request.getParameter("pwd");
		int userId = 0;
		int counter = 0;
		for (Storeuser s:userdata){
			if (s.getUsername().equals(user) && s.getPwd().equals(pwd) ){
				output += "Login Successful";
				userId = (int) s.getUserid();
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);
				counter++;
			}
			
		}
		
		if (counter!=1){
			output += "Wrong username or password";
		}
		
		
		
		request.setAttribute("message", output);
		getServletContext().getRequestDispatcher("/login.jsp").forward(
				request, response);
	}
	  public static void insertProfile(Storeuser user) 
	    {
	    	EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    	EntityTransaction profile = em.getTransaction();
	    	profile.begin();
	    	try {
	    	em.persist(user);
	    	profile.commit();
	    	} catch (Exception e) {
	    	System.out.println(e);
	    	profile.rollback();
	    	} finally {
	    
	    	}
	    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = "";
		String username = "";
		String pwd = "";
	
		username = request.getParameter("user");
		pwd = request.getParameter("pwd");

		
		model.Storeuser user = new Storeuser();
		
		user.setUsername(username);
		user.setPwd(pwd);
		insertProfile(user);
		
		request.setAttribute("message", output);
		getServletContext().getRequestDispatcher("/login.jsp").forward(
				request, response);
	}

}
