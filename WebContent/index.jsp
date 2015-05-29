<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.eq_in{
		width: 20px;
		font-size: 18pt;
		height: 40px;
	}
</style>
</head>
<body>
<h1>Ecuación Cuadrática</h1>
<form action="QuadraticEquationServlet">
<h1>y=<input type="text" class="eq_in" name="a" placeholder="a"/>x²+<input type="text" class="eq_in" name="b" placeholder="b"/>x+<input type="text" class="eq_in" name="c" placeholder="c"/></h1>
<div>
	<input type="submit" value="Calcular">
	<input type="reset" value="Limpiar">
</div>

<div id="messages">${msg}</div>
<div id="solutions">${solution}</div>
<div id="chart">${chart}</div>

</form>	
</body>
</html>