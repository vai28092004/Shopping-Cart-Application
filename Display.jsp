<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
        background-color: rgba(248, 217, 248, 0.914);
    }

</style>
</head>
<body>
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
</body>
</html>