package sample.cafekiosk.spring.api.controller.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sample.cafekiosk.spring.api.controller.order.request.OrderCreateRequest;
import sample.cafekiosk.spring.api.sevice.order.OrderService;
import sample.cafekiosk.spring.domain.order.Order;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private OrderService orderService;

    @PostMapping("/api/v1/ordres/new")
    public void createOrder(@RequestBody OrderCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        orderService.createOrder(request, now);
    }


}
