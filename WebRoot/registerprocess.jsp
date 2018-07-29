
<%@page import="com.example.track.User"%>
<%@page import="com.example.track.UserDao"%><% 
String name=request.getParameter("name");
String uname=request.getParameter("uname");
String pass=request.getParameter("pass");
String dates=request.getParameter("dates");
String vnum=request.getParameter("vnum");

User u=new User();
u.setName(name);
u.setUname(uname);
u.setPass(pass);
u.setDates(dates);
u.setLat("");
u.setLon("");
u.setV_number(vnum);

UserDao ud=new UserDao();
int i=ud.insert(u);
if(i>0){
out.print("<center><h2>Successfully Registered</h2></center>");
%>
<jsp:include page="registration.html"></jsp:include>
<%
}else{
out.print("<center><h2>Registration Failed</h2></center>");
%>
<jsp:include page="registration.html"></jsp:include>
<%
}
%>