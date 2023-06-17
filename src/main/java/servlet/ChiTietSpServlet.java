package servlet;

import entity.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "chitietsp", value = {"/chi-tiet-sp/hien-thi", "/chi-tiet-sp/add", "/chi-tiet-sp/detail", "/chi-tiet-sp/update", "/chi-tiet-sp/delete"})
public class ChiTietSpServlet extends HttpServlet {
    ArrayList<ChiTietSP> list;
    private ChiTietSPRepository chiTietSpRepository;
    private DongSpReposiroty dongSpReposiroty;
    private NSXReposiroty nsxReposiroty;
    private SanPhamRepository sanPhamRepository;
    private MauSacReposiroty mauSacReposiroty;
    public ChiTietSpServlet() throws ServletException {
        list = new ArrayList<>();
        chiTietSpRepository = new ChiTietSPRepository();
        dongSpReposiroty=new DongSpReposiroty();
        nsxReposiroty=new NSXReposiroty();
        sanPhamRepository=new SanPhamRepository();
        mauSacReposiroty=new MauSacReposiroty();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            list = chiTietSpRepository.getAll();
            List<SanPham> listSanPham = sanPhamRepository.getAll();
            List<NSX> listNSX = nsxReposiroty.getAll();
            List<MauSac> listMauSac = mauSacReposiroty.getAll();
            List<DongSp> listDongSP = dongSpReposiroty.getAll();
            request.setAttribute("l", list);
            request.setAttribute("listSanPham", listSanPham);
            request.setAttribute("listNSX", listNSX);
            request.setAttribute("listMauSac", listMauSac);
            request.setAttribute("listDongSP", listDongSP);
            request.getRequestDispatcher("/view/ChiTietSanPham.jsp").forward(request, response);
        } else if (url.contains("delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChiTietSP chiTietSp=chiTietSpRepository.getOne(id);
            boolean check = chiTietSpRepository.removeChiTietSP(chiTietSp);
            response.sendRedirect("hien-thi");
        } else if (url.contains("detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChiTietSP chiTietSp = chiTietSpRepository.getOne(id);
            List<SanPham> listSanPham = sanPhamRepository.getAll();
            List<NSX> listNSX = nsxReposiroty.getAll();
            List<MauSac> listMauSac = mauSacReposiroty.getAll();
            List<DongSp> listDongSP = dongSpReposiroty.getAll();
            request.setAttribute("listSanPham", listSanPham);
            request.setAttribute("listNSX", listNSX);
            request.setAttribute("listMauSac", listMauSac);
            request.setAttribute("listDongSP", listDongSP);
            request.setAttribute("l", chiTietSp);
            request.getRequestDispatcher("/view/detail/ChiTietSp.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            Integer namBH=Integer.parseInt(request.getParameter("namBH"));
            String mota=request.getParameter("moTa");
            Integer soLuongTon=Integer.parseInt(request.getParameter("soLuongTon"));
            BigDecimal giaNhap=BigDecimal.valueOf(Long.parseLong(request.getParameter("giaNhap")));
            BigDecimal giaBan=BigDecimal.valueOf(Long.parseLong(request.getParameter("giaBan")));
            UUID idSP = UUID.fromString(request.getParameter("idSP"));
            UUID idNSX = UUID.fromString(request.getParameter("idNSX"));
            UUID idMauSac = UUID.fromString(request.getParameter("idMauSac"));
            UUID idDongSP = UUID.fromString(request.getParameter("idDongSP"));
            SanPham sanPham = sanPhamRepository.getOne(idSP);
            NSX nsx = nsxReposiroty.getOne(idNSX);
            MauSac mauSac = mauSacReposiroty.getOne(idMauSac);
            DongSp dongSP = dongSpReposiroty.getOne(idDongSP);
            ChiTietSP chiTietSp = new ChiTietSP();
            chiTietSp.setMoTa(mota);
            chiTietSp.setSoLuongTon(soLuongTon);
            chiTietSp.setGiaBan(giaBan);
            chiTietSp.setGiaNhap(giaNhap);
            chiTietSp.setNamBH(namBH);
            chiTietSp.setDongSp(dongSP);
            chiTietSp.setMauSac(mauSac);
            chiTietSp.setNsx(nsx);
            chiTietSp.setSanPham(sanPham);
            boolean check = chiTietSpRepository.addChiTietSP(chiTietSp);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/chi-tiet-sp/hien-thi");
        } else if (url.contains("update")) {
            UUID id=UUID.fromString(request.getParameter("id"));
            Integer namBH=Integer.parseInt(request.getParameter("namBH"));
            String mota=request.getParameter("moTa");
            Integer soLuongTon=Integer.parseInt(request.getParameter("soLuongTon"));
            BigDecimal giaNhap=BigDecimal.valueOf(Long.parseLong(request.getParameter("giaNhap")));
            BigDecimal giaBan=BigDecimal.valueOf(Long.parseLong(request.getParameter("giaBan")));
            UUID idSP = UUID.fromString(request.getParameter("idSP"));
            UUID idNSX = UUID.fromString(request.getParameter("idNSX"));
            UUID idMauSac = UUID.fromString(request.getParameter("idMauSac"));
            UUID idDongSP = UUID.fromString(request.getParameter("idDongSP"));
            SanPham sanPham = sanPhamRepository.getOne(idSP);
            NSX nsx = nsxReposiroty.getOne(idNSX);
            MauSac mauSac = mauSacReposiroty.getOne(idMauSac);
            DongSp dongSP = dongSpReposiroty.getOne(idDongSP);
            ChiTietSP chiTietSp = new ChiTietSP();
            chiTietSp.setId(id);
            chiTietSp.setMoTa(mota);
            chiTietSp.setSoLuongTon(soLuongTon);
            chiTietSp.setGiaBan(giaBan);
            chiTietSp.setGiaNhap(giaNhap);
            chiTietSp.setNamBH(namBH);
            chiTietSp.setDongSp(dongSP);
            chiTietSp.setMauSac(mauSac);
            chiTietSp.setNsx(nsx);
            chiTietSp.setSanPham(sanPham);
            boolean check = chiTietSpRepository.updateChiTietSP(chiTietSp);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/chi-tiet-sp/hien-thi");
        }
    }
}
