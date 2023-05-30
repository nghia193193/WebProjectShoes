package ControllerAmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.InvoiceServices;
import ServicesImpl.InvoiceServicesImpl;

@WebServlet(name = "DoanhThuTheoThuControl", urlPatterns = { "/admin/doanhThuTheoThu" })
public class DoanhThuTheoThuControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		InvoiceServices invoiceServices = new InvoiceServicesImpl();
		double totalMoney1 = invoiceServices.totalMoneyDay(1);
		double totalMoney2 = invoiceServices.totalMoneyDay(2);
		double totalMoney3 = invoiceServices.totalMoneyDay(3);
		double totalMoney4 = invoiceServices.totalMoneyDay(4);
		double totalMoney5 = invoiceServices.totalMoneyDay(5);
		double totalMoney6 = invoiceServices.totalMoneyDay(6);
		double totalMoney7 = invoiceServices.totalMoneyDay(7);

		request.setAttribute("totalMoney1", totalMoney1);
		request.setAttribute("totalMoney2", totalMoney2);
		request.setAttribute("totalMoney3", totalMoney3);
		request.setAttribute("totalMoney4", totalMoney4);
		request.setAttribute("totalMoney5", totalMoney5);
		request.setAttribute("totalMoney6", totalMoney6);
		request.setAttribute("totalMoney7", totalMoney7);

		request.getRequestDispatcher("/views/admin/DoanhThuTheoThu.jsp").forward(request, response);
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
