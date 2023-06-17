package servlet;

import entity.MauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.MauSacReposiroty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "mausac", value = {"/mau-sac/hien-thi", "/mau-sac/add", "/mau-sac/detail", "/mau-sac/update", "/mau-sac/delete"})
public class MauSacServlet extends HttpServlet {
    ArrayList<MauSac> list;
    private MauSacReposiroty mauSacRepository;

    public MauSacServlet() throws ServletException {
        list = new ArrayList<>();
        mauSacRepository = new MauSacReposiroty();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            list = mauSacRepository.getAll();
            request.setAttribute("l", list);
            request.getRequestDispatcher("/view/MauSac.jsp").forward(request, response);
        } else if (url.contains("delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            MauSac mauSac=mauSacRepository.getOne(id);
            boolean check = mauSacRepository.removeMauSac(mauSac);
            response.sendRedirect("hien-thi");
        } else if (url.contains("detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            MauSac mauSac = mauSacRepository.getOne(id);
            request.setAttribute("l", mauSac);
            request.getRequestDispatcher("/view/detail/MauSac.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            MauSac mauSac = new MauSac();
            mauSac.setMa(ma);
            mauSac.setTen(ten);
            boolean check = mauSacRepository.addMauSac(mauSac);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/mau-sac/hien-thi");
        } else if (url.contains("update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            MauSac mauSac = new MauSac();
            mauSac.setId(id);
            mauSac.setMa(ma);
            mauSac.setTen(ten);
            boolean check = mauSacRepository.updateMauSac(mauSac);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/mau-sac/hien-thi");
        }
    }
}
