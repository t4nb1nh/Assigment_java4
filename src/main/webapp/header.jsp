<%--
  Created by IntelliJ IDEA.
  User: HaTanBinh
  Date: 4/4/2023
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<div id="header">
    <div class="logo">
        <a href="index.jsp">Tấn Bình</a>
    </div>
    <nav>
        <form class="search" action="search.php">
            <input name="q" placeholder="Search..." type="search">
        </form>
        <ul>
            <li class="dropdown">
                <a href="/nhan-vien/hien-thi">Nhân Viên</a>
                <ul>
                    <li>
                        <a href="/chuc-vu/hien-thi">Chức Vụ</a>
                    </li>
                    <li>
                        <a href="/cua-hang/hien-thi">Của Hàng</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="/khach-hang/hien-thi">Khách Hàng</a>
            </li>
            <li class="dropdown">
                <a href="/chi-tiet-sp/hien-thi">Chi Tiết Sản Phẩm</a>
                <ul>
                    <li>
                        <a href="/san-pham/hien-thi">Sản Phẩm</a>
                    </li>
                    <li>
                        <a href="/nsx/hien-thi">Nhà Sản Xuất</a>
                    </li>
                    <li><a href="/mau-sac/hien-thi">Màu Sắc</a></li>
                    <li><a href="/dong-sp/hien-thi">Dòng Sản phẩm</a></li>
                </ul>
            </li>

        </ul>
    </nav>
</div>
<script src="../js/style.js"></script>
</body>
</html>
