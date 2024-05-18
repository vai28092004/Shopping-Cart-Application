package product.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Date; // Import Date class to get the current date

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.model.Bill;
import product.model.Product;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DisplayServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        HttpSession session = request.getSession(true);
        List<Product> lstProd=(List)session.getAttribute("prod"); 
        pw.print("<h1>Shopping Bill</h1>");
        pw.print("<table>");
        pw.print("<tr><th>Product Id</th><th>Product Name</th><th>Product Price</th><th>Product Qty</th></tr>");
        for (Product p : lstProd) {
            pw.print("<tr><td>" + p.getProdId() + "</td>");
            pw.print("<td>" + p.getProdName() + "</td>");
            pw.print("<td>" + p.getProdPrice() + "</td>");
            pw.print("<td>" + p.getProdQty() + "</td></tr>");
        }
        pw.print("</table>");
        Bill bill = (Bill) session.getAttribute("bill");
        pw.print("<h1>FINAL BILL</h1>");
        pw.print("<h3>Bill No: " + bill.getBillNo() + "</h3>");

        // Display the current date as the bill date
        Date currentDate = new Date();
        pw.print("<h3>Bill Date: " + currentDate + "</h3>");

        pw.print("<h3>Bill Total: " + bill.getTotal() + "</h3>");
        pw.print("<h3>Bill CGST: " + bill.getCgst() + "</h3>");
        pw.print("<h3>Bill SGST: " + bill.getSgst() + "</h3>");
        pw.print("<h3>Bill FINAL: " + bill.getFinaltotal() + "</h3>");

        pw.print("<h1>..........THANK YOU</h1>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
