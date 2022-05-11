package ecommerceapp.service;

import ecommerceapp.exception.OrderDetailsMisMatchException;
import ecommerceapp.model.Order;
import ecommerceapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    private static final String ORDER_KEY = "key";
    private static final String ORDER_ID_KEY_VALUE = "orderId";
    private static final String ORDER_DATE_KEY_VALUE = "orderDate";
    private static final String DISPLAY_SEQUENCE_KEY = "ordering";
    private static final String DISPLAY_SEQUENCE_KEY_ASC = "ascending";
    private static final String DISPLAY_SEQUENCE_KEY_DESC = "descending";

    public List<Order> getOrdersByKeyAndSorting(Map<String, String> orderMap) throws OrderDetailsMisMatchException {
        List<Order> orderList = new ArrayList<>();
        if (orderMap.get(ORDER_KEY).equalsIgnoreCase(ORDER_ID_KEY_VALUE)) {
            if (orderMap.get(DISPLAY_SEQUENCE_KEY).equalsIgnoreCase(DISPLAY_SEQUENCE_KEY_ASC)) {
                Sort sortOrder = Sort.by("orderId").ascending();
                orderList = repository.findAll(sortOrder);
            } else if (orderMap.get(DISPLAY_SEQUENCE_KEY).equalsIgnoreCase(DISPLAY_SEQUENCE_KEY_DESC)) {
                Sort sortOrder = Sort.by("orderId").descending();
                orderList = repository.findAll(sortOrder);
            }
        } else if (orderMap.get(ORDER_KEY).equalsIgnoreCase(ORDER_DATE_KEY_VALUE)) {
            if (orderMap.get(DISPLAY_SEQUENCE_KEY).equalsIgnoreCase(DISPLAY_SEQUENCE_KEY_ASC)) {
                Sort sortOrder = Sort.by("orderDate").ascending();
                orderList = repository.findAll(sortOrder);
            } else if (orderMap.get(DISPLAY_SEQUENCE_KEY).equalsIgnoreCase(DISPLAY_SEQUENCE_KEY_ASC)) {
                Sort sortOrder = Sort.by("orderDate").descending();
                orderList = repository.findAll(sortOrder);
            }
        } else
            throw new OrderDetailsMisMatchException("Invalid Details in the request");

        return orderList;
    }

    public List<Order> getOrderbyUserId(String userId) {
        return repository.findByUserId(userId);
    }

    public List<Order> getOrderbyProductId(Integer productId) {
        return repository.findByProductId(productId);
    }
}
