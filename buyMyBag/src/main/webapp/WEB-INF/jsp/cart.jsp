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
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${basket.getAllProductsWithQt().entrySet()}" var="item">
                        <tr>
                            <th scope="row">${item.getKey().getName()}</th>
                            <td>${item.getKey().getPrice()}€</td>
                            <td>${item.getValue()}</td>
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
                <a href="/checkout">
                    <script src="https://www.paypal.com/sdk/js?client-id=sb"></script>
                    <script>paypal.Buttons().render('body');</script>

                    <button class="btn btn-primary"><spring:message code="checkout"/></button>

                </a>
            </div>
        </div>
    </div>
</div>
<script>

</script>
<!-- Modal: modalCart -->
