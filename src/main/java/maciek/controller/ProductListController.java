package maciek.controller;

import maciek.persistence.dao.ProductDao;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("products")
public class ProductListController extends HttpServlet {

    private ProductDao productDao;

    @Inject
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", productDao.list());

        getServletContext().getRequestDispatcher("/WEB-INF/pages/product-list.jsp").forward(request, response);
    }
}

