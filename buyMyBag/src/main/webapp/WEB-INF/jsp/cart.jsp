<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>
<!-- Modal: modalCart -->
<div class="modal fade" id="modalCart" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <!--Header-->
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">Votre Panier</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">X</span>
                </button>
            </div>
            <!--Body-->
            <div class="modal-body">

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
                    <c:forEach items="${basket.getArticlesAndQtAsBasketItem()}" var="item">
                        <tr>
                            <th scope="row">${item.getProduct().getName()}</th>
                            <td>${item.getProduct().getPrice()}€</td>
                            <td>${item.getQuantity()}</td>
                            <td>+</td>
                            <td>-</td>
                            <td><a><span>X</span></a></td>
                        </tr>
                    </c:forEach>

                    <tr class="total">
                        <th scope="row">Total</th>
                        <td>€${basket.getTotalPriceOfArticles()}</td>
                        <td>${basket.getNumberOfArticles()}</td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <!--Footer-->
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-primary" data-dismiss="modal">Close</button>
                <button class="btn btn-primary">Checkout</button>
            </div>
        </div>
    </div>
</div>
<!-- Modal: modalCart -->
