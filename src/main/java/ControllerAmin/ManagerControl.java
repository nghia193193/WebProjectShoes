package ControllerAmin;

import entity.Category;
import entity.Product;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.CategoryServices;
import Services.ProductServices;
import ServicesImpl.CategoryServicesImpl;
import ServicesImpl.ProductServicesImpl;

@WebServlet(name = "ManagerControl", urlPatterns = { "/admin/manager" })
public class ManagerControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String index = request.getParameter("index");
		if (index == null) {
			index = "1";
		}
		int indexPage = Integer.parseInt(index);

		ProductServices productServices = new ProductServicesImpl();
		CategoryServices categoryServices = new CategoryServicesImpl();

		int count = productServices.countAllProduct();
		int endPage = count / 6;
		if (count % 6 != 0) {
			endPage++;
		}
		List<Product> listAll = productServices.pagingProduct(indexPage);
		List<Category> listCC = categoryServices.getAllCategory();

		request.setAttribute("listAll", listAll);
		request.setAttribute("endPage", endPage);
		request.setAttribute("tag", indexPage);
		request.setAttribute("listCC", listCC);

		request.getRequestDispatcher("/views/admin/QuanLySanPham.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}

}
