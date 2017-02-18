package maciek.controller;

import maciek.domain.Product;
import maciek.domain.ShopCart;
import maciek.service.ProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.io.IOException;

@WebServlet("shopping-cart")
public class CartController extends HttpServlet {

    @Inject
    private ShopCart shopCart;

    @Inject
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (shopCart.getEntries() == 0) {
            getServletContext().getRequestDispatcher("/WEB-INF/pages/cart-empty.jsp").forward(request, response);
        } else {
            request.setAttribute("products", shopCart.getProducts());
            request.setAttribute("cartInSession", "" + shopCart);
            request.setAttribute("session", request.getSession().getId());
            request.setAttribute("servlet", "" + this);
            getServletContext().getRequestDispatcher("/WEB-INF/pages/cart-contents.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = productService.findById(Integer.parseInt(id));
        shopCart.add(product);

        addCartToSession(request.getSession());

        response.sendRedirect("products");
    }

    private void addCartToSession(@NotNull HttpSession session) {
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", shopCart);
        }
    }

}
