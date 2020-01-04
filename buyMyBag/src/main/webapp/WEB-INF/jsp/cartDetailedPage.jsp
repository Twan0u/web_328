<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>

<table class="table table-hover">
    <thead>
    <tr>
        <th>Produit</th>
        <th>Prix</th>
        <th>Quantité</th>
        <th>Plus</th>
        <th>Moins</th>
        <th>Retirer</th>
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
    <a href="/checkout">
        <button class="btn btn-primary"><spring:message code="checkout"/></button>
        <script src="https://www.paypal.com/sdk/js?client-id=sb"></script>
        <script>paypal.Buttons().render('body');</script>

        <form id="paypal_form_one_time" target="_top" class="paypal-form" method="post" action="https://www.sandbox.paypal.com/cgi-bin/webscr%22%3E
    <input type="hidden" value="_xclick" name="cmd">

        <input type="hidden" value="${basket.getTotalPriceOfArticles()}" name="amount">

        <input type="hidden" value="sb-vzrq1832953@business.example.com" name="business">

        <input type="hidden" value="EUR" name="currency_code">
        <input type="hidden" value="1" name="rm">
        <input type="hidden" value="feature_item_id=1&amp;deal_item_id=0" name="custom">
        <input type="hidden" value="http://localhost/" name="return">

        <input type="hidden" value="??" name="user_email">

        <input type="hidden" value="http://xxxx/xx/xxx/paypal_cancel" name="cancel_return">
        <input type="hidden" value="http://xxx/xx/paxxypal_ipn" name="notify_url">
        </form>
    </a>
</div>