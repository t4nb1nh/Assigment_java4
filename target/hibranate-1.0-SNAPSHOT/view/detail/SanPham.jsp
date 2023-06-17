<%--
  Created by IntelliJ IDEA.
  User: HaTanBinh
  Date: 3/27/2023
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"
    />
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container">
    <form action="/san-pham/update", method="post">
        <div class="mb-3 row">
            <label  class="col-sm-2 col-form-label">id</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"  name="id" value="${l.id}">
            </div>
        </div>
        <div class="mb-3 row">
            <label  class="col-sm-2 col-form-label">Ma</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"  name="ma" value="${l.ma}">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Ten</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"  name="ten" value="${l.ten}">
            </div>
        </div>
        <button type="submit" class="btn btn-outline-primary">Update</button>
    </form>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>
