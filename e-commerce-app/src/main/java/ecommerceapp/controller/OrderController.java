package ecommerceapp.controller;

import com.sun.istack.NotNull;
import ecommerceapp.exception.OrderDetailsMisMatchException;
import ecommerceapp.model.Order;
import ecommerceapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired private OrderService service;

    @GetMapping("/all")
    public List<Order> getOrders(@NotNull @RequestParam Map<String, String> orderMap)
            throws OrderDetailsMisMatchException {
        return service.getOrdersByKeyAndSorting(orderMap);
    }
}
