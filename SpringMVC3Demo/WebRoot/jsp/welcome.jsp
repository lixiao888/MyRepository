<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
      <head>

	<base href="<%=basePath%>">

	     <title>Welcome</title>
	     <script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
		 <script type="text/javascript">
            $(function(){
                var inputStr = $("#inputStr");
                var textContent = $("#textContent");
                inputStr.bind("keyup",function(){
                	$.ajax({
                	    url: 'myInput.action',
                	    type: 'POST',
                	    data: {inputStr:$('#inputStr').val()},
                	    dataType: 'json',
                	    async: false,
                	    error: function(){
                	     alert('获取数据失败！');
                	    },
                	    success: function(obj){
                	    	textContent.text(obj.test);
                	    }
                	 });
                });
            });
         </script>

      </head>

      <body>
			Welcome
			请输入文字测试Ajax: <input type="text" id="inputStr" size="100"/> <br><br><br><br><br>
			
			
			<textarea rows="25" cols="70" id="textContent" ></textarea>
			
			<br><br><br>
			<c:forEach items="${strList}"  var="mymap"  >
			    <c:out  value="${mymap}"  /><br>
			</c:forEach>
			<br><br><br>
            
            <fmt:formatDate value="<%=new java.util.Date() %>" type="date" pattern="yyyy年MM月dd日 HH:mm:ss"/>
            <br><br><br>
            

        <fmt:formatDate value="<%=new java.util.Date() %>" type="date" />

		       格式化的结果是： 2007-5-27
		
		<fmt:formatDate value="<%=new java.util.Date() %>" type="time" />
		
		格式化的结果是： 9:25:11
		
		<fmt:formatDate value="<%=new java.util.Date() %>" type="both" />
		格式化的结果是： 2007-5-27 9:25:11
            
            JSTL截取字符串
			<c:choose>
			     <c:when test="${fn:length('33333333333333333') > 10}">
			      <c:out value="${fn:substring('33333333333333333', 0, 10)}......" />
			     </c:when>
			     <c:otherwise>
			      <c:out value="${log.logTitle}" />
			     </c:otherwise>
		   </c:choose>
			
      </body>

</html>
