package maciek.controller;

import maciek.domain.Order;
import maciek.domain.Person;
import maciek.domain.ShopCart;
import maciek.service.OrderService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.io.IOException;


@WebServlet("order")
public class OrderController extends HttpServlet {

    @Inject
    private ShopCart shopCart;

    @Inject
    private OrderService orderService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (shopCart.getEntries() == 0) {
            getServletContext().getRequestDispatcher("/WEB-INF/pages/cart-empty.jsp").forward(request, response);
        } else {
            Person user = (Person) request.getSession().getAttribute("user");
            Order order = orderService.createOrder(user, shopCart.getProducts());
            addOrderToSession(request.getSession(), order);
            getServletContext().getRequestDispatcher("/WEB-INF/pages/order.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = (Order) request.getSession().getAttribute("order");
        orderService.save(order);
        shopCart.removeAll();

        response.sendRedirect("products");
    }

    private void addOrderToSession(@NotNull HttpSession session, Order order) {
        session.setAttribute("order", order);
    }

}
