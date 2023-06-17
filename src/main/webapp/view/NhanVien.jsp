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
<form action="/nhan-vien/add" method="post" class="container">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mã</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="ma"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Tên</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="ten"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Tên Đệm</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="tenDem"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Họ</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="ho"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-3 col-form-label">Giới tính:</label>
        <div class="col-sm-9">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" value="Nam" id="flexRadioDefault1">
                <label class="form-check-label" for="flexRadioDefault1">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" value="Nữ" id="flexRadioDefault2">
                <label class="form-check-label" for="flexRadioDefault2">
                    Nữ
                </label>
            </div>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Ngày Sinh</label>
        <div class="col-sm-10">
            <input class="form-control" type="date" name="ngaySinh"><br>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Địa Chỉ</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="diaChi"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">SĐT</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="sdt"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mật Khẩu</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="matKhau"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-3 col-form-label">trang Thai:</label>
        <div class="col-sm-9">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="trangThai" value="0" >
                <label class="form-check-label" for="flexRadioDefault1">
                    Hoat Dong
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="trangThai" value="1" >
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
                    <option value="${ch.id}">${ch.ten}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="mb-3 row">
        <label class="col-sm-2 col-form-label">Mã chức vụ:</label>
        <div class="col-sm-10">
            <select class="form-select w-25" aria-label="Default select example" name="idCV">
                <c:forEach items="${listChucVu}" var="cv">
                    <option value="${cv.id}">${cv.ten}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <button type="submit" class="btn btn-outline-primary">Them</button>
</form>
    <table class="table">
        <tr>
            <th>
                ma
            </th>
            <th>
                ten
            </th>
            <th>
                ten dem
            </th>
            <th>
                ho
            </th>
            <th>
                gioitinh
            </th>
            <th>
                ngay sinh
            </th>
            <th>
                dia chi
            </th>
            <th>
                sdt
            </th>
            <th>
                mat khau
            </th>
            <th>
                trang thai
            </th>
            <th>
                chuc vu
            </th>
            <th>
                cua hang
            </th>
            <th>
                chuc nang
            </th>
        </tr>
        <c:forEach items="${l}" var="l">
            <tr>
                <td>
                        ${l.ma}
                </td>
                <td>
                        ${l.ten}
                </td>
                <td>
                        ${l.tenDem}
                </td>
                <td>
                        ${l.ho}
                </td>
                <td>
                        ${l.gioiTinh}
                </td>
                <td>
                        ${l.ngaySinh}
                </td>
                <td>
                        ${l.diaChi}
                </td>
                <td>
                        ${l.sdt}
                </td>
                <td>
                        ${l.matKhau}
                </td>
                <td>
                        ${l.trangThai== 0 ? "hoat dong" : "khong hoat dong"}
                </td>
                <td>${l.chucVu.ten}</td>
                <td>${l.cuaHang.ten}</td>

                <td>
                    <button type="button" class="btn btn-outline-primary"><a href="/nhan-vien/detail?id=${l.id}">detail</a></button>
                    <button type="button" class="btn btn-outline-primary"><a href="/nhan-vien/delete?id=${l.id}">delete</a></button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>
