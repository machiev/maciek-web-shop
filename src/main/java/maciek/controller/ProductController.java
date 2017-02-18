package maciek.controller;

import maciek.service.ProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("product")
public class ProductController extends HttpServlet {

    private ProductService productService;

    @Inject
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("product", productService.findById(Integer.parseInt(id)));

        getServletContext().getRequestDispatcher("/WEB-INF/pages/product.jsp").forward(request, response);
    }
}

