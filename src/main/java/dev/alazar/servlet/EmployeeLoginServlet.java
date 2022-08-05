package dev.alazar.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.alazar.models.Employee;
import dev.alazar.models.Reimbursement;
import dev.alazar.repositories.EmployeeDao;
import dev.alazar.repositories.ReimbursementDao;
import dev.alazar.utils.ConnectionUtil;
import org.postgresql.Driver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

@WebServlet(name = "EmployeeLoginServlet", value = "/EmployeeLogin")
public class EmployeeLoginServlet extends HttpServlet {
    private EmployeeDao employeeDao;
    private ReimbursementDao reimbursementDao;
    private ObjectMapper om;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Login login = om.readValue(request.getInputStream(), Login.class);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String u= (login.getUsername());
        String p = (login.getPassword());
        session.setAttribute("username", u);
        session.setAttribute("password", p);

        List<Employee> employees = employeeDao.
    }
}
