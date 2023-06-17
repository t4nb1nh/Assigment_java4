package servlet;

import entity.DongSp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.DongSpReposiroty;


import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "dongsp", value = {"/dong-sp/hien-thi", "/dong-sp/add", "/dong-sp/detail", "/dong-sp/update", "/dong-sp/delete"})
public class DongSpServlet extends HttpServlet {
    ArrayList<DongSp> list;
    private DongSpReposiroty dongSpRepository;

    public DongSpServlet() throws ServletException {
        list = new ArrayList<>();
        dongSpRepository = new DongSpReposiroty();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            list = dongSpRepository.getAll();
            request.setAttribute("l", list);
            request.getRequestDispatcher("/view/DongSp.jsp").forward(request, response);
        } else if (url.contains("delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            DongSp dongSp=dongSpRepository.getOne(id);
            boolean check = dongSpRepository.removeDongSp(dongSp);
            response.sendRedirect("hien-thi");
        } else if (url.contains("detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            DongSp dongSp = dongSpRepository.getOne(id);
            request.setAttribute("l", dongSp);
            request.getRequestDispatcher("/view/detail/DongSp.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            DongSp dongSp = new DongSp();
            dongSp.setMa(ma);
            dongSp.setTen(ten);
            boolean check = dongSpRepository.addDongSp(dongSp);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/dong-sp/hien-thi");
        } else if (url.contains("update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            DongSp dongSp = new DongSp();
            dongSp.setId(id);
            dongSp.setMa(ma);
            dongSp.setTen(ten);
            boolean check = dongSpRepository.updateDongSp(dongSp);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/dong-sp/hien-thi");
        }
    }
}
