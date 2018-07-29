
<%@page import="com.example.track.UserDao"%>
<%@page import="com.example.track.User"%>
<%

String lat=request.getParameter("lat");
String lon=request.getParameter("lon");
String uname=request.getParameter("uname");

if(uname!=null&&lon!=null){
UserDao ud=new UserDao();
int i=ud.updateLocation(uname,lat,lon);
if(i>0){
System.out.print("update");
out.print("update");
}else{
System.out.print("not update");
}
}
%>