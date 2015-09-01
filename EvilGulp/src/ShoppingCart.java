

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import customTools.DBUtil;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public List<Product> getProduct() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<model.Product> prod = em
				.createQuery("Select p from Product p order by p.custId asc",
						model.Product.class).setMaxResults(20).getResultList();
		return prod;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output="";
		List<Product> a = getProduct();
		output = "";
		
		HttpSession session = request.getSession();
		output = session.getId();
		System.out.println(output);
		

		
	    getServletContext().getRequestDispatcher("/ProductList").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
