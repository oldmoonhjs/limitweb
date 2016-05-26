<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="java.text.*" %>       
<%@ taglib uri="http://www.opensymphony.com/oscache" prefix="cache" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); %>
	<div>
		<cache:cache key="cacheDate" scope="session" time="10"> 
			<h2>使用缓存，让时间在15秒内不进行更新</h2>
			<div><%
				String cacheTime = sdf.format(new Date());
				out.println(cacheTime);				
				%>
			</div>
		</cache:cache>
	</div>
	<hr>
	<div>
		
		</div>
	</div>
</body>
</html>