package servlet;

import entity.ChucVu;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ChucVuReposiroty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "chucvu", value = {"/chuc-vu/hien-thi", "/chuc-vu/add", "/chuc-vu/detail", "/chuc-vu/update", "/chuc-vu/delete"})
public class ChucVuServlet extends HttpServlet {
    ArrayList<ChucVu> list;
    private ChucVuReposiroty chucVuRepository;

    public ChucVuServlet() throws ServletException {
        list = new ArrayList<>();
        chucVuRepository = new ChucVuReposiroty();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            list = chucVuRepository.getAll();
            request.setAttribute("l", list);
            request.getRequestDispatcher("/view/ChucVu.jsp").forward(request, response);
        } else if (url.contains("delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChucVu chucVu=chucVuRepository.getOne(id);
            boolean check = chucVuRepository.removeChucVu(chucVu);
            response.sendRedirect("hien-thi");
        } else if (url.contains("detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChucVu chucVu = chucVuRepository.getOne(id);
            request.setAttribute("l", chucVu);
            request.getRequestDispatcher("/view/detail/ChucVu.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu chucVu = new ChucVu();
            chucVu.setMa(ma);
            chucVu.setTen(ten);
            boolean check = chucVuRepository.addChucVu(chucVu);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/chuc-vu/hien-thi");
        } else if (url.contains("update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu chucVu = new ChucVu();
            chucVu.setId(id);
            chucVu.setMa(ma);
            chucVu.setTen(ten);
            boolean check = chucVuRepository.updateChucVu(chucVu);
            if (check == true) {
                System.out.println("thanh cong");
            } else {
                System.out.println("that bai");
            }
            response.sendRedirect("/chuc-vu/hien-thi");
        }
    }
}
