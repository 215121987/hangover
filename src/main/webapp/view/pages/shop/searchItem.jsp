<%@ include file="/view/common/taglib.jsp" %>
<c:choose>
    <c:when test="${not empty items  && fn:length(items) gt 0}">
        <c:forEach items="${items}" var="item">
            <li class="post-${item.id} product instock" style="width: 200px;">

            </li>
        </c:forEach>

    </c:when>
    <c:otherwise>
        <div class="text-uppercase text-center no-more-item"> Sorry!! No More Item...</div>
    </c:otherwise>
</c:choose>