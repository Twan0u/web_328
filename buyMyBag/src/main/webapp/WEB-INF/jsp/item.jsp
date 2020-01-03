<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>
<head>

  <title>${product.getName()}</title>

  <!-- Custom styles for this template -->
  <link href="css/shop-item.css" rel="stylesheet">

</head>

<body>
  <!-- Page Content -->
  <div class="container" style="margin-top:8%">

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4" style="font-family: 'Pacifico', cursive;" >Home</h1>
        <c:forEach items="${categories}" var="category">
          <div class="list-group">
            <a href="<c:url value="/category/${category.getName()}"/>" class="list-group-item" style="font-family: 'Pacifico', cursive;">${category.getName()}</a>
          </div>
        </c:forEach>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <div class="card mt-4">
          <img class="card-img-top img-fluid" src="${product.getFirstImage()}" alt="">
          <div class="card-body">
            <h3 class="card-title">${product.getName()}</h3>
            <h4>€${product.getPrice()}</h4>
            <p class="card-text">${product.getDescription(chosenLanguage)}</p>
            <form:form id="productOrder"
                       method="POST"
                       action="/detail/${product.getName()}/addToBasket"
                       modelAttribute="orderQuantity">
            <div class="input-group mb-3">
              <form:select path="quantity" class="custom-select">
                <c:forEach begin="1" end="10" var="i">
                  <option value="${i}">${i}</option>
                </c:forEach>
              </form:select>
              <div class="input-group-append">
                <form:button class="btn btn-outline-secondary">Add to my basket</form:button>
              </div>
            </div>
            </form:form>
          </div>
        </div>
        <!-- /.card -->

      </div>
      <!-- /.col-lg-9 -->

    </div>


  </div>
  <!-- /.container -->



</body>

</html>
