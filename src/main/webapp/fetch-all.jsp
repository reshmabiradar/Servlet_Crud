<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="java.util.Arrays"%>
<%@page import="MovieDetais.Movies"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Movies> movie = (List<Movies>) request.getAttribute("M");
	%>

	<div align="center">
		<table border="1">
			<tr>
				<th>Moviename</th>
				<th>Description</th>
				<th>poster</th>
				<th>Language</th>
				<th>Rating</th>
				<th>Genre</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<%
			for (Movies mv : movie) {
			%>
			<tr>
				<td><%=mv.getMoviename()%></td>
				<td><%=mv.getDescription()%></td>
				
            
				<td><img height="80px" width="80px" alt="<%=mv.getMoviename()%>" src="data:image/png;base64,<%=Base64.encodeBase64String(mv.getPoster())%>"></td>
				<td><%=mv.getLanguage()%></td>
				<td><%=mv.getRating()%></td>
				<td><%=Arrays.toString(mv.getGenre()) %></td>
                <td> <a href="edit?id=<%=mv.getId()%>"><button>Edit</button></a></td>
                <td> <a href="delete?id=<%=mv.getId()%>"><button>Delete</button></a></td>
			</tr>
        
              <%
                }
                %>
        
        </table>
    </div>
</body>
</html>