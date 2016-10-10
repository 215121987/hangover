<%@ include file="/view/common/taglib.jsp" %>
<div class="motopress-wrapper content-holder clearfix">
    <div class="container">
        <div class="row">
            <div class="span12">
                <div class="row">
                    <div class="span9 right right" id="content">
                        <div>
                            <c:choose>
                                <c:when test="${'SUCCESS' eq payment.status}">
                                    <%--<img src="" alt="">--%>
                                    <h2>You're all set!</h2>
                                    <div style="border: 1px solid #e8e8e8"><span>Order Number: ${payment.orderNumber}</span></div>
                                    <div style="display: block;">
                                        Thanks for being awesome,
                                        <br/>
                                        We hope you enjoy your purchase!
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <%--<img src="" alt="">--%>
                                    <h2>Sorry!</h2>
                                    <div><span>Transaction Id: ${payment.transactionId}</span></div>
                                    <div>
                                        Transaction failed,
                                        <br/>
                                        Please try again.
                                    </div>
                                </c:otherwise>
                            </c:choose>
                            <div>
                                you will receive Mail/SMS from <fmt:message key="app.name"/> with details about your order. you can close this window.
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>