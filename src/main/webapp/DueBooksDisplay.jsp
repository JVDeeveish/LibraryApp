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
<th><b>Due Days</b></th>

</tr>
<%ArrayList<ArrayList<Object>> DueBooksList= (ArrayList<ArrayList<Object>>)request.getAttribute("DueBooksList");
int totalPenalty=0;
for(ArrayList BookDetails : DueBooksList){%>
	<tr>
	<td><%=BookDetails.get(0)%></td>
	<td><%=BookDetails.get(1)%></td>
	<td><%=BookDetails.get(2)%></td>
	<td><%=BookDetails.get(3)%></td>
	<td><%=BookDetails.get(4)%></td>
	</tr>
	<%}%>

</table>
</body>
</html>