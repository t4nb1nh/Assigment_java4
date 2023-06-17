<%--
  Created by IntelliJ IDEA.
  User: HaTanBinh
  Date: 3/26/2023
  Time: 5:23 PM
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
    <form action="/chi-tiet-sp/add" , method="post">
        <div class="mb-3 row">
            <label  class="col-sm-2 col-form-label">Mã SP:</label>
            <select
                    class="form-select w-25"
                    name="idSP"
                    aria-label="Default select example"
            >
                <c:forEach items="${listSanPham}" var="sp">
                    <option value="${sp.id}">${sp.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Mã NSX:</label>
            <select
                    class="form-select w-25"
                    name="idNSX"
                    aria-label="Default select example"
            >
                <c:forEach items="${listNSX}" var="nsx">
                    <option value="${nsx.id}">${nsx.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3 row">
            <label  class="col-sm-2 col-form-label">Mã màu sắc:</label>
            <select
                    class="form-select w-25"
                    name="idMauSac"
                    aria-label="Default select example"
            >
                <c:forEach items="${listMauSac}" var="ms">
                    <option value="${ms.id}">${ms.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Mã SP:</label>
            <select
                    class="form-select w-25"
                    name="idDongSP"
                    aria-label="Default select example"
            >
                <c:forEach items="${listDongSP}" var="dongSP">
                    <option value="${dongSP.id}">${dongSP.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">nam bao hanh</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="namBH">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">mo ta</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="moTa">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">so luong ton</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="soLuongTon">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">gia nhap</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="giaNhap">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">gia ban</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="giaBan">
            </div>
        </div>
        <button type="submit" class="btn btn-outline-primary">ADD</button>
    </form>
    <table class="table">
        <tr>
            <th>
                nam bao hanh
            </th>
            <th>
                mo ta
            </th>
            <th>
                so luong ton
            </th>
            <th>
                gia nhap
            </th>
            <th>
                gia ban
            </th>

            <th>
               san pham
            </th>
            <th>
                nha san xuat
            </th>
            <th>
                mau sac
            </th>
            <th>
                dong san pham
            </th>
            <th>
                chuc nang
            </th>
        </tr>
        <c:forEach items="${l}" var="l">
            <tr>
                <td>
                        ${l.namBH}
                </td>
                <td>
                        ${l.moTa}
                </td>
                <td>
                        ${l.soLuongTon}
                </td>
                <td>
                        ${l.giaNhap}
                </td>
                <td>
                        ${l.giaBan}
                </td>
                <td>${l.sanPham.ten}</td>
                <td>${l.nsx.ten}</td>
                <td>${l.mauSac.ten}</td>
                <td>${l.dongSp.ten}</td>
                <td>
                    <button class="btn btn-outline-primary"><a href="/chi-tiet-sp/detail?id=${l.id}">detail</a></button>
                    <button class="btn btn-outline-primary"><a href="/chi-tiet-sp/delete?id=${l.id}">remove</a></button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>
