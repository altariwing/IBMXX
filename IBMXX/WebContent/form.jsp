<%@ page contentType="text/html; charset=Big5" pageEncoding="Big5"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=BIG5">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>form.html</TITLE>
</HEAD>
<BODY>




<table border="1" bordercolor="deeppink">
<%for(int i=0;i<5;i++){%>

<tr><td><%=i%></td><td><%=i*i%></td></tr>

<%}%>
</table>

  <FORM METHOD="get" ACTION="Hello">
      
    請輸入您的名字!
    <INPUT TYPE="TEXT" NAME="name" VALUE="peter1吳永志"><P>
    <INPUT TYPE="SUBMIT">
  </FORM>

  <img src="http://localhost:8081/IBM/images/tomcat.gif"> <!--(1) 寫死 交出去會扣薪水-->
  <img src="/IBM/images/tomcat.gif"> 	<!--(2) 寫死-->
<img src="IBM/images/tomcat.gif"> <!--[然而貓並不會出現]-->
  <img src="images/tomcat.gif"> <!--(3) 建議的寫法-->
<img src="/images/tomcat.gif"> <!--[然而貓並不會出現]-->
  <img src="/tomcat.gif"> <!--(4)騙你的貓(住在LOOT)-->
<img src="tomcat.gif"> <!--[然而貓並不會出現]--> 	
</BODY>
</HTML>
