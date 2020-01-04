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
        <button class="btn btn-primary">Checkout</button>
    </a>
</div>