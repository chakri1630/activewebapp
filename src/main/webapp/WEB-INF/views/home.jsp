<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form action="orders">
	Normal call : <input type="submit" name="order"/>
</form>

Customer Information : <button type="button" id="customerInfo">Get Customer info</button>
<br><br>

Order Information <button type="button" id="orderInfo">Get Order info</button>

<br><br><br>

Result : <div id="info"></div>

</body>

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>


</html>
