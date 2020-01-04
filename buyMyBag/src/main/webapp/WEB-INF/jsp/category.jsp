<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>
<!doctype html>
<html lang="fr">

<head>

  <title>TODO</title>

</head>
<style>
body{font-family: 'Raleway', sans-serif;}
</style>

<body>

  <!-- Page Content -->
  <div class="container">

    <div class="row">


      <div class="col-lg-3">

        <h1 class="my-4" style="font-family: 'Pacifico', cursive;" >${categoryName}</h1>
        <c:forEach items="${categories}" var="category">
          <div class="list-group">
            <a href="<c:url value="/category/${category.getName()}"/>" class="list-group-item" style="font-family: 'Pacifico', cursive;">${category.getName()}</a>
          </div>
        </c:forEach>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <div class="row" style="padding-top:5%">

          <c:forEach items="${products}" var="product">
            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href="<c:url value='/detail/${product.getName()}'/>"><img class="card-img-top" src='${product.getFirstImage()}' alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="<c:url value='/detail/${product.getName()}'/>">${product.getName()}</a>
                  </h4>
                  <h5>${product.getPrice()}€</h5>
                  <p class="card-text">${product.getDescription(pageContext.response.locale)}</p>
                </div>
              </div>
            </div>
          </c:forEach>
        </div>
        <!-- /.row -->
      </div>
      <!-- /.col-lg-9 -->
    </div>
    <!-- /.row -->
  </div>
  <!-- /.container -->
</body>

</html>
