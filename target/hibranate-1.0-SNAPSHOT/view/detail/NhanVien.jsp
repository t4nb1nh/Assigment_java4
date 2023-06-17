<%--
  Created by IntelliJ IDEA.
  User: HaTanBinh
  Date: 3/27/2023
  Time: 12:55 PM
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
    <form action="/nhan-vien/update" method="post" class="container">
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
        <div class="mb-3 row">
            <label class="col-sm-3 col-form-label">Giới tính:</label>
            <div class="col-sm-9">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh" value="Nam" id="flexRadioDefault1" ${l.gioiTinh== "Nam" ? "checked" : ""}>
                    <label class="form-check-label" for="flexRadioDefault1">
                        Nam
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh" value="Nữ" id="flexRadioDefault2"
                    ${l.gioiTinh== "Nữ" ? "checked" : ""}  >
                    <label class="form-check-label" for="flexRadioDefault2">
                        Nữ
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Ngày Sinh</label>
            <div class="col-sm-10">
                <input class="form-control" type="date" name="ngaySinh" value="${l.ngaySinh}"><br>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Địa Chỉ</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="diaChi" value="${l.diaChi}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">SĐT</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="sdt" value="${l.sdt}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Mật Khẩu</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="matKhau" value="${l.matKhau}"><br>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-3 col-form-label">Giới tính:</label>
            <div class="col-sm-9">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="trangThai" value="0" ${l.trangThai== 0 ? "checked" : ""}>
                    <label class="form-check-label" for="flexRadioDefault1">
                        hoat dong
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="trangThai" value="1"
                    ${l.trangThai== 1 ? "checked" : ""}  >
                    <label class="form-check-label" for="flexRadioDefault2">
                        Khong Hoat Dong
                    </label>
                </div>
            </div>
        </div>
        <div class="mb-3 row">
            <label  class="col-sm-2 col-form-label">Mã cửa hàng:</label>
            <div class="col-sm-10">
                <select class="form-select w-25" aria-label="Default select example" name="idCH">
                    <c:forEach items="${listCuaHang}" var="ch">
                        <option value="${ch.id}" ${l.cuaHang.id == ch.id ? "selected" : ""}>${ch.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="mb-3 row">
            <label  class="col-sm-2 col-form-label">Mã chức vụ:</label>
            <div class="col-sm-10">
                <select class="form-select w-25" aria-label="Default select example" name="idCV">
                    <c:forEach items="${listChucVu}" var="cv">
                        <option value="${cv.id}" ${l.chucVu.id ==  cv.id? "selected" : ""}>${cv.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <button type="submit" class="btn btn-outline-primary">update</button>
    </form>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>
