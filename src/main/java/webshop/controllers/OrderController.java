package webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshop.data.model.Order;
import webshop.services.OrderService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST, path = "/add")
    public ResponseEntity<Order> createOrder(@RequestBody @Valid Order order) {
        return ResponseEntity.ok(orderService.create(order));
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT, path = "/update")
    public ResponseEntity<Order> update(@RequestBody @Valid Order order) {
        return ResponseEntity.ok(orderService.update(order));
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET, path = "/all")
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE, path = "/delete")
    public ResponseEntity<List<Order>> delete(@RequestParam("id") Long id) {
        return ResponseEntity.ok(orderService.delete(id));
    }
}
