vc <%--
  Created by IntelliJ IDEA.
  User: HaTanBinh
  Date: 3/26/2023
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%@ include file="../header.jsp" %>
<div class="container">
    <form action="/cua-hang/add" , method="post">
        <div class="mb-3 row">
            <label for="inpuMa" class="col-sm-2 col-form-label">Ma</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inpuMa" name="ma">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="inputTen" class="col-sm-2 col-form-label">Ten</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputTen" name="ten">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="inputTen" class="col-sm-2 col-form-label">dia chi</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"  name="diaChi">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="inputTen" class="col-sm-2 col-form-label">thanh pho</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"  name="thanhPho">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="inputTen" class="col-sm-2 col-form-label">quoc gia</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="quocGia">
            </div>
        </div>
        <button type="submit" class="btn btn-outline-primary">ADD</button>
    </form>
    <table class="table">
        <tr>
            <th>
                id
            </th>
            <th>
                ma
            </th>
            <th>
                ten
            </th>
            <th>
                dia chi
            </th>
            <th>
                thanh pho
            </th>
            <th>
                quoc gia
            </th>

            <th>
                chuc nang
            </th>
        </tr>
        <c:forEach items="${l}" var="l">
            <tr>
                <td>
                        ${l.id}
                </td>
                <td>
                        ${l.ma}
                </td>
                <td>
                        ${l.ten}
                </td>

                <td>
                        ${l.diaChi}
                </td>
                <td>
                        ${l.thanhPho}
                </td>
                <td>
                        ${l.quocGia}
                </td>

                <td>
                    <button type="button" class="btn btn-outline-primary"><a href="/cua-hang/detail?id=${l.id}">detail</a></button>
                    <button type="button" class="btn btn-outline-primary"><a href="/cua-hang/delete?id=${l.id}">delete</a></button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>
