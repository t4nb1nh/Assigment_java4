<%--
  Created by IntelliJ IDEA.
  User: HaTanBinh
  Date: 3/27/2023
  Time: 12:56 PM
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
<%@ include file="../../header.jsp" %>
<div class="container">
    <form action="/chi-tiet-sp/update?id=${l.id}" , method="post">
    <div class="mb-3 row">
        <label class="col-sm-2 col-form-label">Mã SP:</label>
        <select
                class="form-select w-25"
                name="idSP"
                aria-label="Default select example"
        >
            <c:forEach items="${listSanPham}" var="sp">
                <option value="${sp.id}" ${l.sanPham.id == sp.id ? "selected":""}>${sp.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3 row">
        <label  class="col-sm-2 col-form-label">Mã NSX:</label>
        <select
                class="form-select w-25"
                name="idNSX"
                aria-label="Default select example"
        >
            <c:forEach items="${listNSX}" var="nsx">
                <option value="${nsx.id}" ${l.nsx.id == nsx.id ? "selected":""}>${nsx.ten}</option>
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
                <option value="${ms.id}" ${l.mauSac.id == ms.id ? "selected":""}>${ms.ten}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3 row">
        <label  class="col-sm-2 col-form-label">Mã SP:</label>
        <select
                class="form-select w-25"
                name="idDongSP"
                aria-label="Default select example"
        >
            <c:forEach items="${listDongSP}" var="dongSP">
                <option value="${dongSP.id}" ${l.dongSp.id == dongSP.id ? "selected":""}>${dongSP.ten}</option>
            </c:forEach>
        </select>
    </div>

        <div class="mb-3 row">
            <label for="inpuMa" class="col-sm-2 col-form-label">id</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inpuMa" name="id" value="${l.id}">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">nam bao hanh</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="namBH" value="${l.namBH}">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">mo ta</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="moTa" value="${l.moTa}">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">so luong ton</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="soLuongTon" value="${l.soLuongTon}">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">gia nhap</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="giaNhap" value="${l.giaNhap}">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">gia ban</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="giaBan" value="${l.giaBan}">
            </div>
        </div>
        <button type="submit" class="btn btn-outline-primary">update</button>
    </form>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>
