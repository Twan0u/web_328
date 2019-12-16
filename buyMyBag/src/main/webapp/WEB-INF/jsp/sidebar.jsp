<%@ include file="include/importTags.jsp"%>
<div class="col-lg-3">

    <h1 class="my-4" style="font-family: 'Pacifico', cursive;" >Home</h1>
    <c:forEach items="${param.categories}" var="category">
        <div class="list-group">
            <a href="#" class="list-group-item" style="font-family: 'Pacifico', cursive;">${category.getName()}</a>
        </div>
    </c:forEach>

</div>
<!-- /.col-lg-3 -->