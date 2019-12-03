package webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshop.data.model.Order;
import webshop.services.OrderService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody @Valid Order order) {
        return ResponseEntity.ok(orderService.create(order));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Order> update(@RequestBody @Valid Order order, @PathVariable long id) {
        return ResponseEntity.ok(orderService.update(order, id));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @DeleteMapping
    @RequestMapping(path = "/{id}")
    public ResponseEntity<List<Order>> delete(@PathVariable("id") long id) {
        return ResponseEntity.ok(orderService.delete(id));
    }
}
