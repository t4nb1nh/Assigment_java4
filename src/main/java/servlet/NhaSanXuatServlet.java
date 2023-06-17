package servlet;

import entity.NSX;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.NSXReposiroty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "NhaSanXuat", value = {
        "/nsx/hien-thi",
        "/nsx/add",
        "/nsx/update",
        "/nsx/remove",
        "/nsx/detail"
})public class NhaSanXuatServlet extends HttpServlet {
    ArrayList<NSX> list;
    private NSXReposiroty nsxRepository;

    public NhaSanXuatServlet() throws ServletException {
        list = new ArrayList<>();
        nsxRepository = new NSXReposiroty();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            list = nsxRepository.getAll();
            request.setAttribute("l", list);
            request.getRequestDispatcher("/view/NhaSanXuat.jsp").forward(request, response);
        } else if (url.contains("delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            NSX nsx=nsxRepository.getOne(id);
            boolean check = nsxRepository.removeNSX(nsx);
            response.sendRedirect("hien-thi");
        } else if (url.contains("detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            NSX nsx = nsxRepository.getOne(id);
            request.setAttribute("l", nsx);
            request.getRequestDispatcher("/view/detail/NhaSanXuat.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            NSX nsx = new NSX();
            nsx.setMa(ma);
            nsx.setTen(ten);
            boolean check = nsxRepository.addNSX(nsx);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/nsx/hien-thi");
        } else if (url.contains("update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            NSX nsx = new NSX();
            nsx.setId(id);
            nsx.setMa(ma);
            nsx.setTen(ten);
            boolean check = nsxRepository.updateNSX(nsx);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/nsx/hien-thi");
        }
    }
}
