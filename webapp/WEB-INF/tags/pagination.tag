<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="href"     required="true" %>
<%@ attribute name="pageVo"   required="true" %>
<%@ include file="/WEB-INF/jsp/pages/include/include_commonTags.jsp"  %>

<nav>
    <ul class="pagination">
        <li class="${pageVo.isPreviousBtnView ? '':'disabled'}">
            <a href="${href}?pageIndex=${pageVo.firstPageNoOnPreviousPageList}" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <c:forEach begin="${pageVo.firstPageNoOnPageList}" end="${pageVo.lastPageNoOnPageList}" var="item" varStatus="status">
            <li class="${item eq pageVo.currentPageIndex ? 'active':''}"><a href="${href}?pageIndex=${item}">${item}</a></li>
        </c:forEach>
        <c:if test="${pageVo.isNextBtnView}">
        <li class="${pageVo.isNextBtnView ? '':'disabled'}">
            <a href="${href}?pageIndex=${pageVo.firstPageNoOnNextPageList}" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
        </c:if>
    </ul>
</nav>
