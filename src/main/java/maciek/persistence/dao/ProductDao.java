package maciek.persistence.dao;

import maciek.persistence.dto.ProductDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductDao {

    @PersistenceContext(unitName = "mnshopdbPU")
    private EntityManager entityManager;

    public ProductDto findById(int id) {
        ProductDto productDto = entityManager.find(ProductDto.class, id);
        return productDto;
    }

    public List<ProductDto> list() {
        List<ProductDto> result = entityManager.createQuery( "from ProductDto", ProductDto.class ).getResultList();
        return result;
    }

    public void save(ProductDto productDto) {
        entityManager.persist(productDto);
    }
}
