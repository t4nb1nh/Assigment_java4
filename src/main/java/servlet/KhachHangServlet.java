package servlet;

import entity.KhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.taglibs.standard.extra.spath.ParseException;
import repository.KhachHangRepository;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "khachhang", value = {"/khach-hang/hien-thi", "/khach-hang/add", "/khach-hang/detail", "/khach-hang/update", "/khach-hang/delete"})
public class KhachHangServlet extends HttpServlet {
    ArrayList<KhachHang> list;
    private KhachHangRepository khachHangRepository;

    public KhachHangServlet() throws ServletException {
        list = new ArrayList<>();
        khachHangRepository = new KhachHangRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            list = khachHangRepository.getAll();
            request.setAttribute("l", list);
            request.getRequestDispatcher("/view/KhachHang.jsp").forward(request, response);
        } else if (url.contains("delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang khachHang = khachHangRepository.getOne(id);
            boolean check = khachHangRepository.removeKhachHang(khachHang);
            response.sendRedirect("hien-thi");
        } else if (url.contains("detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang khachHang = khachHangRepository.getOne(id);
            request.setAttribute("l", khachHang);
            request.getRequestDispatcher("/view/detail/KhachHang.jsp").forward(request, response);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (url.contains("add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            Date ngaySinh;
            ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");
            KhachHang khachHang = new KhachHang();
            khachHang.setMa(ma);
            khachHang.setTen(ten);
            khachHang.setHo(ho);
            khachHang.setTenDem(tenDem);
            khachHang.setNgaySinh(ngaySinh);
            khachHang.setSdt(sdt);
            khachHang.setDiaChi(diaChi);
            khachHang.setThanhPho(thanhPho);
            khachHang.setQuocGia(quocGia);
            khachHang.setMatKhau(matKhau);
            boolean check = khachHangRepository.addKhachHang(khachHang);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/khach-hang/hien-thi");
        } else if (url.contains("update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            Date ngaySinh;
            ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");
            KhachHang khachHang = new KhachHang();
            khachHang.setId(id);
            khachHang.setMa(ma);
            khachHang.setTen(ten);
            khachHang.setHo(ho);
            khachHang.setTenDem(tenDem);
            khachHang.setNgaySinh(ngaySinh);
            khachHang.setSdt(sdt);
            khachHang.setDiaChi(diaChi);
            khachHang.setThanhPho(thanhPho);
            khachHang.setQuocGia(quocGia);
            khachHang.setMatKhau(matKhau);
            boolean check = khachHangRepository.updateKhachHang(khachHang);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/khach-hang/hien-thi");
        }
    }
}
