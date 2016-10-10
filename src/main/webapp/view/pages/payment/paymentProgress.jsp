<%@ include file="/view/common/taglib.jsp" %>
<head>
    <title></title>
    <script type="text/javascript">
        document.go_for_payment.submit();
    </script>
</head>
<body>
<center><h1>Please do not refresh this page...</h1></center>
<div style="display: none;">
    <form action="${gatewayDetail.actionURL}" method="POST" name="go_for_payment">
       <c:forEach items="${gatewayDetail.param}" var="param">
           <input type="hidden" name="${param.name}" value="${param.value}"/>
       </c:forEach>
       <input type="submit"/>
    </form>
</div>
</body>