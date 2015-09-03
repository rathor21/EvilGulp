import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Placeorder;
import model.Product;
import customTools.DBUtil;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Long> shoppingCartList = new ArrayList<Long>();
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	public List<Product> getProduct() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<model.Product> prod = em
				.createQuery("Select p from Product p order by p.custId asc",
						model.Product.class).setMaxResults(20).getResultList();
		return prod;
	}
	public List<Placeorder> getOrder(BigDecimal id) {
		
//		Query query = em.createQuery("SELECT p FROM Teacher t JOIN t.phones p WHERE t.firstName = :firstName");
//		 
//		query.setParameter("firstName", "Pranil");
//		List<Phone> phones = (List<Phone>) query.getResultList();
//		for (Phone phone : phones) {
//		System.out.println(phone.getNumber());
//		}
		
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String sql = "Select p from Placeorder p where p.userid ="+ id;
    	Query q = em.createQuery(sql, Product.class);
    	
    	List<Placeorder> order;
    	try{ order= q.getResultList();
    	if(order == null || order.isEmpty())
    		order= null;
    	}
    	finally
    	{
    		em.close();
    	}
    	return order;
  	
    	
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String output = "";
		List<Product> a = getProduct();
		output = "";
		output += "<form role=\"form\" action=\"CheckOut\" method=\"get\"><table class= \"table table-striped\">";
		output += "<tr><th>Name</th><th>Price</th></tr>";
		HttpSession session = request.getSession();
		long item;
		
		BigDecimal ID = new BigDecimal((int) session.getAttribute("userId"));
		List<Placeorder> order = getOrder(ID);
		
		double total=0;
		for (Placeorder p : order) 
		{
			String sql = "Select p from Product p where p.custId ="+ p.getProdid();
	    	Query q = em.createQuery(sql, Product.class);
	    	model.Product product;
	    	product = (model.Product) q.getSingleResult();
	    	output += "<tr><td>"+product.getDescription()+"</td><td>"+product.getPrice()+"</td></tr>";
	    	total += product.getPrice().doubleValue(); 
	    	
		}

		session.setAttribute("total", total);
		output += "</table>"+"<h2>Total: "+total+"</h2><input type=\"submit\" name = \"Checkout\" class=\"btn btn-info\" value=\"Checkout\"></form>";
		request.setAttribute("message", output);
		getServletContext().getRequestDispatcher("/shoppingcart.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
