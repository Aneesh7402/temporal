package new_product_cat.product_catalog.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import new_product_cat.product_catalog.service.Order;


@RestController
public class controller {
    @Autowired
    Order order;
    @PostMapping(value="/placeOrder")
    public String placeorder(@RequestParam("id") String id) {
        order.placeOrder(id);
        return "Order Placed";
    }
    @PostMapping(value="/makeOrderAccepted")
    public String orderaccept(@RequestParam("id") String id) {
        order.makeOrderAccepted(id);
        return "Order Accepted";
    }
    @PostMapping(value="/makeOrderShipped")
    public String ordershipped(@RequestParam("id") String id) {
        order.makeOrderShipped(id);
        return "Order Shipped";
    }
    @PostMapping(value="/makeOrderPickedUp")
    public String orderpicked(@RequestParam("id") String id) {
        order.makeOrderPickedUp(id);
        return "Order Picked";
    }
    @PostMapping(value="/makeOrderdelivered")
    public String orderdeliv(@RequestParam("id") String id) {
        order.makeOrderDelivered(id);
        return "Order Delivered";
    }
    

}
