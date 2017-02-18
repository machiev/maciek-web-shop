package maciek.controller;

import maciek.domain.Person;
import maciek.service.OrderService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("orders")
public class OrderListController extends HttpServlet {

    @Inject
    private OrderService orderService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person user = (Person) request.getSession().getAttribute("user");
        request.setAttribute("orders", orderService.findByCustomer(user.getId()));

        getServletContext().getRequestDispatcher("/WEB-INF/pages/order-list.jsp").forward(request, response);
    }
}

