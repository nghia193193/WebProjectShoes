package ControllerWeb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.InvoiceServices;
import Services.InvoiceShopServices;
import ServicesImpl.InvoiceServicesImpl;
import ServicesImpl.InvoiceShopServicesImpl;
import entity.InvoiceShop;

@WebServlet(urlPatterns = { "/login/orderConfirm" })
public class OrderConfirmEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		InvoiceServices invoiceServices = new InvoiceServicesImpl();
		InvoiceShopServices invoiceShopServices = new InvoiceShopServicesImpl();

		String maHD = request.getParameter("maHD");

		int ma = Integer.parseInt(maHD);

		invoiceServices.updateInvoice(ma, 2);

		List<InvoiceShop> listInvoiceShops = invoiceShopServices.getListInvoiceShopByOrderID(ma);
		for (InvoiceShop i : listInvoiceShops) {
			invoiceShopServices.updateInvoice(i.getMaHD(), 2);
		}

		request.getRequestDispatcher("/views/web/InvoiceConfirm.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
