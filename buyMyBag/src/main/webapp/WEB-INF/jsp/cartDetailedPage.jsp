<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>

<table class="table table-hover">
    <thead>
    <tr>
        <th><spring:message code="product"/></th>
        <th><spring:message code="price"/></th>
        <th><spring:message code="quantity"/></th>
        <th><spring:message code="more"/></th>
        <th><spring:message code="less"/></th>
        <th><spring:message code="remove"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${basket.getAllProductsWithQt().entrySet()}" var="item">
        <tr>
            <th scope="row">${item.getKey().getName()}</th>
            <td>${item.getKey().getPrice()}€</td>
            <td>${item.getValue()}</td>
            <td><a href="/addOne/${item.getKey().getName()}"><button>+</button></a></td>
            <td><a href="/removeOne/${item.getKey().getName()}"><button>-</button></a></td>
            <td><a href="/removeItem/${item.getKey().getName()}"><button>X</button></a></td>
        </tr>
    </c:forEach>

    <tr class="total">
        <th scope="row">Total</th>
        <td>€${basket.getTotalPriceOfArticles()}</td>
        <td>${basket.getNumberOfArticles()}</td>
    </tr>
    </tbody>
</table>
<div class="modal-footer">
    <a href="/payment">
        <button class="btn btn-primary"><spring:message code="checkout"/></button>
    </a>
</div>