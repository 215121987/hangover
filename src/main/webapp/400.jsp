<%@ page import="org.springframework.security.acls.model.NotFoundException" %>
<%@ page import="org.springframework.security.core.userdetails.UsernameNotFoundException" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page language="java" isErrorPage="true" %>
<%@ include file="view/common/taglib.jsp" %>
<%--<page:applyDecorator name="default">--%>
<title><fmt:message key="errorPage.title"/></title>
<div class="content">
    <div class="header">
        <div class="title_text">
            <h1><fmt:message key="errorPage.title"/></h1>
        </div>
    </div>
    <div>
        <p>
            <fmt:message key="400.message"/>
        </p>
    </div>
</div>
<div style="display: none;">
    <%

        String error = "";
        if (exception == null) {
            exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        }
        if (exception != null) {
            final Logger log = Logger.getLogger(exception.getClass());
//                BerylAppUtil berylAppUtil = new BerylAppUtil();
            if (exception.getCause() instanceof NumberFormatException) {
                error = null;//berylAppUtil.getText("400.message", request.getLocale());
            } else if(exception.getCause() instanceof NotFoundException){
                //error = berylAppUtil.getText("error.no.record.found", request.getLocale());
                error  =exception.getCause().getMessage();
            }else if(exception.getCause() instanceof UsernameNotFoundException){
                error = null;//berylAppUtil.getText("error.invalid.credential", request.getLocale());
            }else {
                error=exception.toString();
            }
            log.error(exception.toString());
            exception.printStackTrace();
            exception.printStackTrace(new java.io.PrintWriter(System.out));
        }
    %>
</div>
<%--<p>
<pre><% System.out.print(exception);%>  </pre>
</p>--%>
<%--/page:applyDecorator>--%>