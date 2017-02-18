package maciek.service.converter;

import maciek.domain.Product;
import maciek.persistence.dto.ProductDto;

public class ProductConverter {

    public static Product frmDto(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getName(), productDto.getDescription());
    }
}
