

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBUtil;
import model.Placeorder;
import model.Product;

/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = "";
		double total = 0;
		HttpSession session = request.getSession();
		total = (double) session.getAttribute("total");
		output += "<h2>Grand Total "+total+"</h2>";
		
		String sql = "Delete from Placeorder";
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Query q = em.createQuery(sql, Placeorder.class);
		EntityTransaction trans = em.getTransaction();
		trans.begin();
    	try {
    	q.executeUpdate();
    	trans.commit();
    	} catch (Exception e) {
    	System.out.println(e);
    	trans.rollback();
    	}
		
		request.setAttribute("message", output);
		getServletContext().getRequestDispatcher("/checkout.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
