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
	public List<Placeorder> getOrder(int id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<model.Placeorder> order = em
				.createQuery("Select p from Placeorder p where p.userId =:userID")
    			.setParameter("userID", id)
    		    .setMaxResults(20)
    		    .getResultList();
		return order;
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String output = "";
		List<Product> a = getProduct();
		output = "";
		output += "<form role=\"form\" action=\"CheckOut\" method=\"get\"><table class= \"table table-striped\">";
		output += "<tr><th>Name</th><th>Price</th></tr>";
		HttpSession session = request.getSession();
		long item;
		double total = 0;
		int Id = (int) session.getAttribute("UserId");
		List<Placeorder> order = getOrder(Id);
		
		
		/*shoppingCartList = (ArrayList<Long>) session
				.getAttribute("ProductsInCart");
		for (int i = 0; i < shoppingCartList.size(); i++) {
			item = shoppingCartList.get(i);
			for (Product p : a) {
				Long match = p.getCustId();
				if (match == item) {
					total += p.getPrice().doubleValue();
					output += "<tr><td>" + p.getName() + "</td><td>"
							+ p.getPrice() + "</td></tr>";
					
				}
			}
		}
		*/
		session.setAttribute("total", total);
		output += "</table>"+"<h2>Total: "+total+"</h2><input type=\"submit\" class=\"btn btn-info\" value=\"Checkout\"></form>";
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
