package servlet;

import entity.ChucVu;
import entity.CuaHang;
import entity.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import repository.ChucVuReposiroty;
import repository.CuaHangReposiroty;
import repository.NhanVienRepository;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "nhanvien", value = {"/nhan-vien/hien-thi", "/nhan-vien/add", "/nhan-vien/detail", "/nhan-vien/update", "/nhan-vien/delete"})
public class NhanVienServlet extends HttpServlet {
    ArrayList<NhanVien> list;
    private NhanVienRepository nhanVienRepository;
    private CuaHangReposiroty cuaHangReposiroty;
    private ChucVuReposiroty chucVuReposiroty;

    public NhanVienServlet() throws ServletException {
        list = new ArrayList<>();
        nhanVienRepository = new NhanVienRepository();
        chucVuReposiroty=new ChucVuReposiroty();
        cuaHangReposiroty=new CuaHangReposiroty();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            list = nhanVienRepository.getAll();
            request.setAttribute("l", list);
            List<CuaHang> listCuaHang = cuaHangReposiroty.getAll();
            List<ChucVu> listChucVu = chucVuReposiroty.getAll();
            request.setAttribute("listCuaHang", listCuaHang);
            request.setAttribute("listChucVu", listChucVu);
            request.getRequestDispatcher("/view/NhanVien.jsp").forward(request, response);
        } else if (url.contains("delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien = nhanVienRepository.getOne(id);
            boolean check = nhanVienRepository.removeNhanVien(nhanVien);
            response.sendRedirect("hien-thi");
        } else if (url.contains("detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien = nhanVienRepository.getOne(id);
            List<CuaHang> listCuaHang = cuaHangReposiroty.getAll();
            List<ChucVu> listChucVu = chucVuReposiroty.getAll();
            request.setAttribute("listCuaHang", listCuaHang);
            request.setAttribute("listChucVu", listChucVu);
            request.setAttribute("l", nhanVien);
            request.getRequestDispatcher("/view/detail/NhanVien.jsp").forward(request, response);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getRequestURI();

        if (url.contains("add")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            Date ngaySinh;
            ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            Integer trangThai = Integer.parseInt(request.getParameter("trangThai"));
            String matKhau = request.getParameter("matKhau");
            UUID idCH = UUID.fromString(request.getParameter("idCH"));
            CuaHang cuaHang = cuaHangReposiroty.getOne(idCH);
            UUID idCV = UUID.fromString(request.getParameter("idCV"));
            ChucVu chucVu = chucVuReposiroty.getOne(idCV);
            NhanVien nhanVien = new NhanVien();
            nhanVien.setTen(ten);
            nhanVien.setMa(ma);
            nhanVien.setTenDem(tenDem);
            nhanVien.setHo(ho);
            nhanVien.setGioiTinh(gioiTinh);
            nhanVien.setNgaySinh(ngaySinh);
            nhanVien.setDiaChi(diaChi);
            nhanVien.setSdt(sdt);
            nhanVien.setMatKhau(matKhau);
            nhanVien.setTrangThai(trangThai);
            nhanVien.setChucVu(chucVu);
            nhanVien.setCuaHang(cuaHang);
            boolean check = nhanVienRepository.addNhanVien(nhanVien);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/nhan-vien/hien-thi");
        } else if (url.contains("update")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            Date ngaySinh;
            ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            Integer trangThai = Integer.parseInt(request.getParameter("trangThai"));
            String matKhau = request.getParameter("matKhau");
            UUID idCH = UUID.fromString(request.getParameter("idCH"));
            CuaHang cuaHang = cuaHangReposiroty.getOne(idCH);
            UUID idCV = UUID.fromString(request.getParameter("idCV"));
            ChucVu chucVu = chucVuReposiroty.getOne(idCV);
            NhanVien nhanVien = new NhanVien();
            nhanVien.setId(id);
            nhanVien.setMa(ma);
            nhanVien.setTen(ten);
            nhanVien.setTenDem(tenDem);
            nhanVien.setHo(ho);
            nhanVien.setGioiTinh(gioiTinh);
            nhanVien.setNgaySinh(ngaySinh);
            nhanVien.setDiaChi(diaChi);
            nhanVien.setSdt(sdt);
            nhanVien.setMatKhau(matKhau);
            nhanVien.setTrangThai(trangThai);
            nhanVien.setChucVu(chucVu);
            nhanVien.setCuaHang(cuaHang);
            boolean check = nhanVienRepository.updateNhanVien(nhanVien);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/nhan-vien/hien-thi");
        }
    }
}
