<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>

		<title>Capsule</title>
		<style type="text/css">
		
		</style>
	</head>
	
	<body>
		<div id="page">
			<div id="header">
				<h1>Team4's Project</h1>
			</div>

			
			<div id="content2">
				<div id="menu">
					<ul>
						<li><a href="login/log?result=" target="iframe">LOGIN</a></li>
						<li><a href="product/productList" target="iframe">PRODUCT</a></li>
						<li><a href="product/showCart" target="iframe">CART</a></li>
						<li><a href="order/list" target="iframe">ORDER</a></li>
					</ul>
				</div>
				<div id="content">
					<iframe name="iframe" height="100%" width="100%"></iframe>
				</div>
			</div>
			
			<div id="footer">
				<h5>Team4</h5>
			</div>
		</div>
	</body>
</html>
