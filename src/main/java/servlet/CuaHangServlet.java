package servlet;

import entity.CuaHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.CuaHangReposiroty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "cuahang", value = {"/cua-hang/hien-thi", "/cua-hang/add", "/cua-hang/detail", "/cua-hang/update", "/cua-hang/delete"})
public class CuaHangServlet extends HttpServlet {
    ArrayList<CuaHang> list;
    private CuaHangReposiroty cuaHangRepository;

    public CuaHangServlet() throws ServletException {
        list = new ArrayList<>();
        cuaHangRepository = new CuaHangReposiroty();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            list = cuaHangRepository.getAll();
            request.setAttribute("l", list);
            request.getRequestDispatcher("/view/CuaHang.jsp").forward(request, response);
        } else if (url.contains("delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang=cuaHangRepository.getOne(id);
            boolean check = cuaHangRepository.removeCuaHang(cuaHang);
            response.sendRedirect("hien-thi");
        } else if (url.contains("detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang = cuaHangRepository.getOne(id);
            request.setAttribute("l", cuaHang);
            request.getRequestDispatcher("/view/detail/CuaHang.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            CuaHang cuaHang = new CuaHang();
            cuaHang.setMa(ma);
            cuaHang.setTen(ten);
            cuaHang.setDiaChi(diaChi);
            cuaHang.setQuocGia(quocGia);
            cuaHang.setThanhPho(thanhPho);
            boolean check = cuaHangRepository.addCuaHang(cuaHang);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/cua-hang/hien-thi");
        } else if (url.contains("update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            CuaHang cuaHang = new CuaHang();
            cuaHang.setMa(ma);
            cuaHang.setId(id);
            cuaHang.setTen(ten);
            cuaHang.setDiaChi(diaChi);
            cuaHang.setQuocGia(quocGia);
            cuaHang.setThanhPho(thanhPho);
            boolean check = cuaHangRepository.updateCuaHang(cuaHang);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/cua-hang/hien-thi");
        }
    }
}
