<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>
<!doctype html>
<html lang="fr">

<head>

  <title>Buy My Bag</title>

</head>
<style>
body{font-family: 'Raleway', sans-serif;}
</style>

<body>

  <!-- Page Content -->
  <div class="container">

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

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>

        <div class="row">

          <c:forEach items="${products}" var="product">
            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href="<c:url value='/detail/${product.getName()}'/>"><img class="card-img-top" src='${product.getFirstImage()}' alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="<c:url value='/detail/${product.getName()}'/>">${product.getName()}</a>
                  </h4>
                  <h5>${product.getPrice()}€</h5>
                  <p class="card-text">${product.getDescription("FRENCH")}</p>
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
