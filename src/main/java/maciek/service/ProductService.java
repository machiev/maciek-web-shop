package maciek.service;

import maciek.domain.Product;
import maciek.persistence.dao.ProductDao;
import maciek.persistence.dto.ProductDto;
import maciek.service.converter.ProductConverter;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ProductService {

    private ProductDao productDao;

    @Inject
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product findById(int id) {
        ProductDto productDto = productDao.findById(id);
        if (productDto == null) {
            return null;
        }
        return ProductConverter.frmDto(productDto);
    }
}
