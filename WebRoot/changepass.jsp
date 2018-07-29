
<%@page import="com.example.track.UserDao"%>
<%
String pass=request.getParameter("pass");
String uname=request.getParameter("uname");

if(pass!=null&&uname!=null){
UserDao ud=new UserDao();
int i=ud.changePass(uname,pass);
if(i>0){
out.print("Successfully Change Password");
}else{
out.print("password not change");
}
}

%>