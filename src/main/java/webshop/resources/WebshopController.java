package webshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebshopController {

    private WebShopService webShopService;

    @Autowired
    public WebshopController(WebShopService webShopService) {
        this.webShopService = webShopService;
    }

    //place an order

    //edit order

    // show all

    //delete order
}
