
<% 
pageContext.setAttribute("customer","peter1");
request.setAttribute("customer","peter2");
session.setAttribute("customer","peter3");
application.setAttribute("customer","peter4");
%>
<html>
<head><title>Test_scope.jsp</title></head>
<body>
	
	

	
pageContext.customer=<%=pageContext.getAttribute("customer")%><br>
request.customer    =<%=request.getAttribute("customer")%><br>
session.customer    =<%=session.getAttribute("customer")%><br>
application.customer=<%=application.getAttribute("customer")%><br>
<br>
²Ä <%= ++count %> ¦¸³y³X
</body>
</html>

























<%! int count = 0;%><%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>