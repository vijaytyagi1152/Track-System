
<%@page import="com.example.track.UserDao"%>
<%@page import="com.example.track.User"%><%
String uname=request.getParameter("uname");

UserDao ud=new UserDao();
User u=ud.getUser(uname);
out.print("<a href=#>"+u.getLat() + " : " + u.getLon()+"</a>");
%>
<a href="http://maps.google.com/?q=<%=u.getLat() %>,<%=u.getLon() %>">See in Google Map</a>
