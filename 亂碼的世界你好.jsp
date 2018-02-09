<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType = "text/html; charset=utf-8 " pageEncoding = "utf-8" %>
<html>
<head>



<meta charset="utf-8">


</head>


<body>
<h2>Hello World!亂碼的世界你好</h2>
<br>
123123123123123123123123123123123
<br>

      <c:forEach var = "i" begin = "1" end = "5">
         Item <c:out value = "${i}"/><p>
      </c:forEach>

<br>

<select>
<c:forEach var = "i" begin = "1" end = "50">
  <option value="Knuckles love u">Knuckles love u</option>
  <option value="Knuckles love u">hehehehehehe</option>
</c:forEach>
</select>

<br>

<c:forEach var = "i" begin = "1" end = "30">
 \ / \ / \ /
</c:forEach>

<br>
(╯°□°）╯︵ ┻━┻
<br>

<p>後端工程師就是這樣, 明明寫了無聊得要死的html5<br>
<q>哦哦哦哦有顏色會動欸</q><br>
脫離了黑和白色就是票釀的審美觀.
<br>前端走過來跟說： 喔你喜歡嗎我可以做10個彩色的給你
<br><strike>原來這些東西只需要５分鐘，好像聽到什麼玻璃碎掉的聲音</strike>
</p>

<br>

<ruby>
喵 <rt>ㄇㄧㄠ</rt>
</ruby>

<br>
<br>
<br>
醜死的DEEP PINK
<br>
<table border="1" bordercolor="deeppink">
<% for(int i=1 ; i<10 ; i++) {%>
<tr>
	<% for (int j =1; j<10;j++) { %>

    <td> <%= i %> * <%= j %> = <%= i*j %> </td>
    <% } %>
</tr>
<% } %>
</table>
<br>
</body>
</html>
