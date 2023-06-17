package servlet;

import entity.KhachHang;
import entity.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.SanPhamRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "sanpham", value = {"/san-pham/hien-thi", "/san-pham/add", "/san-pham/detail", "/san-pham/update", "/san-pham/delete"})
public class SanPhamServlet extends HttpServlet {
    ArrayList<SanPham> list;
    private SanPhamRepository sanPhamRepository;

    public SanPhamServlet() throws ServletException {
        list = new ArrayList<>();
        sanPhamRepository = new SanPhamRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            list = sanPhamRepository.getAll();
            request.setAttribute("l", list);
            request.getRequestDispatcher("/view/SanPham.jsp").forward(request, response);
        } else if (url.contains("delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            SanPham sanPham=sanPhamRepository.getOne(id);
            boolean check = sanPhamRepository.removeSanPham(sanPham);
            response.sendRedirect("hien-thi");
        } else if (url.contains("detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            SanPham sanPham = sanPhamRepository.getOne(id);
            request.setAttribute("l", sanPham);
            request.getRequestDispatcher("/view/detail/SanPham.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            SanPham sanPham = new SanPham();
            sanPham.setMa(ma);
            sanPham.setTen(ten);
            boolean check = sanPhamRepository.addSanPham(sanPham);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/san-pham/hien-thi");
        } else if (url.contains("update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            SanPham sanPham = new SanPham();
            sanPham.setId(id);
            sanPham.setMa(ma);
            sanPham.setTen(ten);
            boolean check = sanPhamRepository.updateSanPham(sanPham);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/san-pham/hien-thi");
        }
    }
}
