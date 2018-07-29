
<%@page import="com.example.track.UserDao"%>
<%@page import="java.util.List"%>
<%@page import="com.example.track.User"%>
<%
UserDao ud=new UserDao();
List<User> list=ud.getAllUser();
%>
<form action="map.jsp">
<div style="padding: 15px;" align="center">
Select Vehicle Number<select name="uname">
<%
if(list.size()>0){
for(int i=0;i<list.size();i++){
User u=list.get(i);
%>
<option value="<%=u.getUname()%>"><%=u.getV_number()%></option>
<%
}
}else{
out.print("<center><h2>There is no Information !</h2></center>");
}
%>
</select></div>
<div style="padding: 15px;" align="center"><input type="submit" value="Submit"></div>
</form>