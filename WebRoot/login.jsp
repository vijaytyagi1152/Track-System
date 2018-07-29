
<%@page import="com.example.track.UserDao"%>
<%@page import="com.example.track.User"%>
<%@page import="com.google.gson.Gson"%>
<%

String uname=request.getParameter("uname");
String pass=request.getParameter("pass");

if(uname!=null&&pass!=null){
UserDao ud=new UserDao();
User u=ud.login(uname,pass);
if(u!=null){
Gson g=new Gson();
out.print(g.toJson(u));
}else{
out.print("Login Failed");
}
}
%>