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
      
    �п�J�z���W�r!
    <INPUT TYPE="TEXT" NAME="name" VALUE="peter1�d�ç�"><P>
    <INPUT TYPE="SUBMIT">
  </FORM>

  <img src="http://localhost:8081/IBM/images/tomcat.gif"> <!--(1) �g�� ��X�h�|���~��-->
  <img src="/IBM/images/tomcat.gif"> 	<!--(2) �g��-->
<img src="IBM/images/tomcat.gif"> <!--[�M�ӿߨä��|�X�{]-->
  <img src="images/tomcat.gif"> <!--(3) ��ĳ���g�k-->
<img src="/images/tomcat.gif"> <!--[�M�ӿߨä��|�X�{]-->
  <img src="/tomcat.gif"> <!--(4)�F�A����(���bLOOT)-->
<img src="tomcat.gif"> <!--[�M�ӿߨä��|�X�{]--> 	
</BODY>
</HTML>