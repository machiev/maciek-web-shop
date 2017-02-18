package maciek.domain;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@SessionScoped
public class ShopCart implements Serializable {

    private List<Product> products = new ArrayList<>();

    @Lock(LockType.READ)
    public List<Product> getProducts() {
        return products;
    }

    @Lock(LockType.WRITE)
    public void add(Product product) {
        products.add(product);
    }

    @Lock(LockType.WRITE)
    public void remove(int productId) {
        for (ListIterator<Product> iterator = products.listIterator(); iterator.hasNext(); ) {
            Product productInCart = iterator.next();
            if (productInCart.getId() == productId) {
                iterator.remove();
                return;
            }
        }
    }

    @Lock(LockType.READ)
    public int getEntries() {
        return products.size();
    }

    @Lock(LockType.WRITE)
    public void removeAll() {
        products.clear();
    }
}
