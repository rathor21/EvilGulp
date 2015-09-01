import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import customTools.DBUtil;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String output = "", image = "";

		Long id = Long.valueOf(request.getParameter("CustId"));
		HttpSession session = request.getSession();
		session.setAttribute("ProdId", id);

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<model.Product> detail = em
				.createQuery("Select p from Product p where p.custId =:custId",
						model.Product.class).setParameter("custId", id)
				.setMaxResults(20).getResultList();

		if (id == 1) {
			image = "<img src=\"https://htechnews.com/wp-content/uploads/2015/07/48EAEED3-2ABB-DF30-F157-A6F881C63006_4K-TV-guide-How-to-buy-the-best-ultra-HD-television.jpg\" alt=\"W3Schools.com\" >";
		} else if (id == 2) {
			image = "<img src=\"http://cnet3.cbsistatic.com/hub/i/r/2015/02/26/3ce5a1c6-25ca-41e6-8707-fa26a0e9a594/thumbnail/770x433/00e6566ddead8d8f0e33130b84bbba20/batllo-0853.jpg\" alt=\"W3Schools.com\" >";

		} else if (id == 3) {
			image = "<img src=\"http://eu.audio-technica.com/en/images/ATHMSR7.jpg\" alt=\"W3Schools.com\" >";

		} else if (id == 4) {
			image = "<img src=\"http://core0.staticworld.net/images/idge/imported/article/cio/2013/09/18/nexus7and10tablets-100340358-orig.jpg\" alt=\"W3Schools.com\" >";

		} else if (id == 5) {
			image = "<img src=\"http://im.ziffdavisinternational.com/t/pcmag_uk/news/b/bose-speakers-return-to-apple-online-store-after-r/bose-speakers-return-to-apple-online-store-after-r_2z2e.640.jpg\" alt=\"W3Schools.com\" >";

		} else if (id == 6) {
			image = "<img src=\"http://www.lenovo.com/images/gallery/main/lenovo-laptop-essential-g585-brown-back-8L.jpg\" alt=\"W3Schools.com\" >";

		} else if (id == 7) {
			image = "<img src=\"https://9to5mac.files.wordpress.com/2013/10/samsung-840-evo-series-250gb-2-5-inch-sata-iii-internal-solid-state-drive1.jpg?w=1000\" alt=\"W3Schools.com\" >";

		} else if (id == 8) {
			image = "<img src=\"https://psmedia.playstation.com/is/image/psmedia/ps4-system-imageblock-vs-us-19jun15?$TwoColumn_Image$\" alt=\"W3Schools.com\" >";

		} else if (id == 9) {
			image = "<img src=\"http://www.kitguru.net/wp-content/uploads/2013/09/xbone.jpg\" alt=\"W3Schools.com\" >";

		} else if (id == 10) {
			image = "<img src=\"http://vignette2.wikia.nocookie.net/emulation-general/images/4/49/Original-Nintendo-64.jpg/revision/latest?cb=20130722015901\" alt=\"W3Schools.com\" >";

		}

		for (model.Product p : detail) {
			output += "<h1>" + p.getName() + "</h1><br>" + image + "<br><h2>"
					+ p.getDetails() + "</h2>";
		}
		output += "<br><form action = \"Details\" method = \"post\"><input type=\"submit\" class=\"btn btn-info\" value=\"Add to Cart\"></form></body>";
		request.setAttribute("message", output);
		getServletContext().getRequestDispatcher("/details.jsp").forward(
				request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ArrayList<String>cartList = new ArrayList<String>();
		cartList.add((String) session.getAttribute("ProdId"));
		session.setAttribute("ProductsInCart", cartList);

		String output = "";
		output = "Added to cart!";
		request.setAttribute("message2", output);
		getServletContext().getRequestDispatcher("/details.jsp").forward(
				request, response);

	}

}
