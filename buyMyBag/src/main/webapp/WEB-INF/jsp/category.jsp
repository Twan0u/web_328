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
          <h1 class="my-4" style="font-family: 'Pacifico', cursive;" >TODO</h1>
        <c:forEach items="${categories}" var="category">
          <div class="list-group">
            <a href="#" class="list-group-item">${category.getName()}</a>
          </div>
        </c:forEach>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <div class="row">

          <c:forEach items="${products}" var="product">
            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href='#'><img class="card-img-top" src='${product.getFirstImage()}' alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="#">${product.getName()}</a>
                  </h4>
                  <h5>${product.getPrice()}€</h5>
                  <p class="card-text">${product.getDescription()}</p>
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

  <!-- Modal: modalCart -->
  <div class="modal fade" id="modalCart" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
       aria-hidden="true">
      <div class="modal-dialog" role="document">
          <div class="modal-content">
              <!--Header-->
              <div class="modal-header">
                  <h4 class="modal-title" id="myModalLabel">Your cart</h4>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">×</span>
                  </button>
              </div>
              <!--Body-->
              <div class="modal-body">

                  <table class="table table-hover">
                      <thead>
                      <tr>
                          <th>#</th>
                          <th>Produit</th>
                          <th>Prix</th>
                          <th>Retirer</th>
                      </tr>
                      </thead>
                      <tbody>
                      <tr>
                          <th scope="row">1</th>
                          <td>Product 1</td>
                          <td>100$</td>
                          <td><a><i class="far fa-times"></i></a></td>
                      </tr>
                      <tr class="total">
                          <th scope="row">5</th>
                          <td>Total</td>
                          <td>400$</td>
                          <td></td>
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

</body>

</html>
