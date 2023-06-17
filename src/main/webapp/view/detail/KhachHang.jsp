<%--
  Created by IntelliJ IDEA.
  User: HaTanBinh
  Date: 3/27/2023
  Time: 12:56 PM
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
    <form action="/khach-hang/update" method="post" class="container">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">id</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="id" value="${l.id}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Mã</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="ma" value="${l.ma}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Tên</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="ten" value="${l.ten}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Tên Đệm</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="tenDem" value="${l.tenDem}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Họ</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="ho" value="${l.ho}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Ngày Sinh</label>
            <div class="col-sm-10">
                <input class="form-control" type="date" name="ngaySinh" value="${l.ngaySinh}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">SĐT</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="sdt" value="${l.sdt}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Địa Chỉ</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="diaChi" value="${l.diaChi}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Thành Phố</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="thanhPho" value="${l.thanhPho}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Quốc Gia</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="quocGia" value="${l.quocGia}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Mật Khẩu</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="matKhau" value="${l.matKhau}"><br>
            </div>
        </div>
        <button type="submit" class="btn btn-outline-primary">Update</button>
    </form>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>
