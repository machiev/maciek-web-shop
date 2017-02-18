package maciek.controller;

import maciek.domain.ShopCart;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("shopping-cart-remove")
public class CartRemoveController extends HttpServlet {

    @Inject
    private ShopCart shopCart;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        shopCart.remove(Integer.parseInt(id));

        if (shopCart.getEntries() == 0) {
            getServletContext().getRequestDispatcher("/WEB-INF/pages/cart-empty.jsp").forward(request, response);
        } else {
            response.sendRedirect("shopping-cart");
        }
    }

}
