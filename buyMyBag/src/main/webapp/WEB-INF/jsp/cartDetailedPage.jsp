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
    <a>
        <button class="btn btn-primary"><spring:message code="checkout"/></button>

        <form id="paypal_form_one_time" target="_top" class="paypal-form" method="post" action="https://www.paypal.com/cgi-bin/webscr">
            <input type="hidden" value="sb-47ertw823112@business.example.com" name="business">
            <input type="hidden" value="i2I^ZVh6" name="password">
            <input type="hidden" value="XQFKS7A4QYXA6" name="cert_id">


            <input type="hidden" value="_xclick" name="cmd">

            <input type="hidden" value="${basket.getTotalPriceOfArticles()}" name="amount">

            <input type="hidden" value="EUR" name="currency_code">

            <input type="hidden" value="localhost:/" name="cancel_return">
            <input type="hidden" value="http://localhost/detail/d" name="notify_url">
            <input type="image" name="submit"
                   src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif"
                   alt="PayPal - The safer, easier way to pay online">

        </form>
    </a>
</div>