<%--
  Created by IntelliJ IDEA.
  User: Antoine Lambert
  Date: 05-01-20
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payement-page</title>
</head>
<body>
    <form id="paypal_form_one_time" target="_top" class="paypal-form" method="post" action="https://www.paypal.com/cgi-bin/webscr">
        <input name="business" type="hidden" value="buyMyBag@business.com" name="business"/>
        <input name="password" type="hidden" value="YourStrong(!)"/>
        <input name="cert_id" type="hidden" value="UK5X979PVSZ76"/>
        <input name="cmd" type="hidden" value="_xclick"/>

        <input type="hidden" value="${basket.getTotalPriceOfArticles()}" name="amount">

        <input type="hidden" value="EUR" name="currency_code">

        <input type="hidden" value="http://localhost/paymentError" name="cancel_return">
        <input type="hidden" value="http://localhost/paymentSuccess" name="notify_url">
        <input type="hidden" value="http://localhost/paymentSuccess" name="return">
        <input type="image" name="submit"
               src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif"
               alt="PayPal - The safer, easier way to pay online">
    </form>
    <div style="position:absolute;">
        <img src="https://i.ibb.co/VCGQBbt/fat-Pushing-Cart.jpg" style="max-width: 1000px; max-height: 1000px;"/>
    </div>
</body>
</html>
