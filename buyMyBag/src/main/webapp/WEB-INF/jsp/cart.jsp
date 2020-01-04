<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>
<!-- Modal: modalCart -->

<div class="modal fade" id="modalCart" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <!--Header-->
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel"><spring:message code="yourBasket"/></h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">X</span>
                </button>
            </div>
            <!--Body-->
            <div class="modal-body">

                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th><spring:message code="product"/></th>
                        <th><spring:message code="price"/></th>
                        <th><spring:message code="quantity"/></th>
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
                <button type="button" class="btn btn-outline-primary" data-dismiss="modal"><spring:message code="close"/></button>
                <a href="/checkout">
                    <button class="btn btn-primary"><spring:message code="checkout"/></button>

                </a>
            </div>
        </div>
    </div>
</div>
<script>

</script>
<!-- Modal: modalCart -->
