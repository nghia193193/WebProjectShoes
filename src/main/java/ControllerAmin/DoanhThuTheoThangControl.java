package ControllerAmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.InvoiceServices;
import ServicesImpl.InvoiceServicesImpl;

@WebServlet(name = "DoanhThuTheoThangControl", urlPatterns = { "/admin/doanhThuTheoThang" })
public class DoanhThuTheoThangControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		InvoiceServices invoiceServices = new InvoiceServicesImpl();
		double totalMoneyMonth1 = invoiceServices.totalMoneyMonth(1);
		double totalMoneyMonth2 = invoiceServices.totalMoneyMonth(2);
		double totalMoneyMonth3 = invoiceServices.totalMoneyMonth(3);
		double totalMoneyMonth4 = invoiceServices.totalMoneyMonth(4);
		double totalMoneyMonth5 = invoiceServices.totalMoneyMonth(5);
		double totalMoneyMonth6 = invoiceServices.totalMoneyMonth(6);
		double totalMoneyMonth7 = invoiceServices.totalMoneyMonth(7);
		double totalMoneyMonth8 = invoiceServices.totalMoneyMonth(8);
		double totalMoneyMonth9 = invoiceServices.totalMoneyMonth(9);
		double totalMoneyMonth10 = invoiceServices.totalMoneyMonth(10);
		double totalMoneyMonth11 = invoiceServices.totalMoneyMonth(11);
		double totalMoneyMonth12 = invoiceServices.totalMoneyMonth(12);

		request.setAttribute("totalMoneyMonth1", totalMoneyMonth1);
		request.setAttribute("totalMoneyMonth2", totalMoneyMonth2);
		request.setAttribute("totalMoneyMonth3", totalMoneyMonth3);
		request.setAttribute("totalMoneyMonth4", totalMoneyMonth4);
		request.setAttribute("totalMoneyMonth5", totalMoneyMonth5);
		request.setAttribute("totalMoneyMonth6", totalMoneyMonth6);
		request.setAttribute("totalMoneyMonth7", totalMoneyMonth7);
		request.setAttribute("totalMoneyMonth8", totalMoneyMonth8);
		request.setAttribute("totalMoneyMonth9", totalMoneyMonth9);
		request.setAttribute("totalMoneyMonth10", totalMoneyMonth10);
		request.setAttribute("totalMoneyMonth11", totalMoneyMonth11);
		request.setAttribute("totalMoneyMonth12", totalMoneyMonth12);

		request.getRequestDispatcher("/views/admin/DoanhThuTheoThang.jsp").forward(request, response);
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
