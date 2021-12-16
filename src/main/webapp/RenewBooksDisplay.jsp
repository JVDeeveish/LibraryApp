<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Search results</h1>
<table border="1"width="500"align="center">
<tr bgcolor="00FF7F">
<th><b>BookName</b></th>
<th><b>Author Name</b></th>
<th><b>Issued Date</b></th>
<th><b>Due Date</b></th>
</tr>
<%ArrayList<ArrayList<Object>> BooksRenewal= (ArrayList<ArrayList<Object>>)request.getAttribute("BooksRenewal");
for(ArrayList BookDetails : BooksRenewal){%>
	<tr>
	<td><%=BookDetails.get(0)%></td>
	<td><%=BookDetails.get(1)%></td>
	<td><%=BookDetails.get(2)%></td>
	<td><%=BookDetails.get(3)%></td>
	</tr>
	<%}%>

</table><br>
<button onclick = "window.location.href='http://localhost:8080/LibraryMgmtApp/RenewServiceServlet'" type="submit">Renew</button>
</body>
</html>