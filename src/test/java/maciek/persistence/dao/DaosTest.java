package maciek.persistence.dao;

import maciek.persistence.dto.Customer;
import maciek.persistence.dto.OrderDto;
import maciek.persistence.dto.OrderItemDto;
import maciek.persistence.dto.ProductDto;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import java.util.Properties;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@Ignore("needs tables in DB to be created first")
public class DaosTest {

    private final static String GLOBAL_CONTEXT_SPACE = "java:global/maciek-web-shop/";
    private static ProductDao productDao;
    private static CustomerDao customerDao;
    private static OrderDao orderDao;

    @BeforeClass
    public static void beforeClass() throws NamingException {
        final Properties p = new Properties();
        p.put("mnshopDatabase", "new://Resource?type=DataSource");
        p.put("mnshopDatabase.JdbcDriver", "com.mysql.jdbc.Driver");
        p.put("mnshopDatabase.JdbcUrl", "jdbc:mysql://localhost/shopdb");
        p.put("mnshopDatabase.username", "shopdb");
        p.put("mnshopDatabase.password", "shopdb");

        Context context = EJBContainer.createEJBContainer(p).getContext();
        productDao = (ProductDao) context.lookup(GLOBAL_CONTEXT_SPACE + "ProductDao");
        customerDao = (CustomerDao) context.lookup(GLOBAL_CONTEXT_SPACE + "CustomerDao");
        orderDao = (OrderDao) context.lookup(GLOBAL_CONTEXT_SPACE + "OrderDao");
    }

    @Test
    public void productDaoTest() {
        //given
        ProductDto newProduct = new ProductDto(null, "Samsung TV", "Samsung TV 54\"");
        //when
        int sizeBeforeSave = productDao.list().size();
        productDao.save(newProduct);
        int sizeAfterSave = productDao.list().size();
        ProductDto productById = productDao.findById(newProduct.getId());
        //then
        assertNotNull(productById.getId());
        assertThat(productById.getName(), is("Samsung TV"));
        assertThat(sizeAfterSave, is(sizeBeforeSave + 1));
    }

    @Test
    public void customerDaoTest() {
        //given
        Customer newCustomer = new Customer(null, "John", "Dale");
        //when
        int sizeBeforeSave = customerDao.list().size();
        customerDao.save(newCustomer);
        int sizeAfterSave = customerDao.list().size();
        Customer customerById = customerDao.findById(newCustomer.getId());
        //then
        assertNotNull(customerById.getId());
        assertThat(customerById.getName(), is("John"));
        assertThat(sizeAfterSave, is(sizeBeforeSave + 1));
    }

    @Test
    public void orderDaoTest() {
        //given
        Customer customer1 = new Customer("John", "Dale");
        Customer customer2 = new Customer("Mindy", "Strong");
        OrderItemDto order1Item1 = new OrderItemDto(null, "Samsung TV", null, 1);
        OrderItemDto order1Item2 = new OrderItemDto(null, "Toaster", null, 1);
        OrderDto order1 = new OrderDto(null, customer1, asList(order1Item1, order1Item2));
        OrderItemDto order2Item1 = new OrderItemDto(null, "Toaster", null, 1);
        OrderDto order2 = new OrderDto(null, customer2, singletonList(order2Item1));
        //when
        customerDao.save(customer1);
        customerDao.save(customer2);
        int sizeBeforeSave = orderDao.list().size();
        orderDao.save(order1);
        orderDao.save(order2);
        int sizeAfterSave = orderDao.list().size();
        OrderDto order1ById = orderDao.findById(order1.getId());
        OrderDto order2ById = orderDao.findById(order2.getId());
        //then
        assertThat(sizeAfterSave, is(sizeBeforeSave + 2));
        assertThat(order1ById.getCustomer().getName(), is(customer1.getName()));
        assertThat(order2ById.getCustomer().getName(), is(customer2.getName()));
        assertThat(order1ById.getItems().size(), is(2));
        assertThat(order2ById.getItems().size(), is(1));

    }

}