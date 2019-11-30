package webshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebShopService {

    private WebShopRepository webShopRepository;

    @Autowired
    public WebShopService(WebShopRepository webShopRepository) {
        this.webShopRepository = webShopRepository;
    }

    Order create(Order order) {
        return webShopRepository.create(order);
    }
}
