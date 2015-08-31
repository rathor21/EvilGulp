

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import customTools.DBUtil;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductList() {
        super();
        // TODO Auto-generated constructor stub
    }

    public List<Product> getProduct(){
    	EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<model.Product> prod = em.createQuery("Select p from Product p order by p.custId asc",model.Product.class)
	    .setMaxResults(20)
	    .getResultList();
		return prod;	
    }
    
 
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String output="";
	
		output+="<table class= \"table table-striped\">";
		output+="<tr><th>Name</th><th>Description</th><th>Price</th></tr>";
		List<Product> a = getProduct();
		for(Product p : a){
			output+= "<tr><td><a href = Details.java?"+p.getCustId()+"=>" + p.getName()+"</td><td></a>" +p.getDescription()+"</td><td>"+p.getPrice()+"</td></tr>";
		}
		
		request.setAttribute("message", output);
	    getServletContext().getRequestDispatcher("/productlist.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
