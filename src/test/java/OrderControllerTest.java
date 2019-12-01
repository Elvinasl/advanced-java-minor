import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import webshop.config.WebConfig;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import webshop.data.model.Order;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringJUnitWebConfig(classes = WebConfig.class)
public class OrderControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private ObjectMapper mapper = new ObjectMapper();
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testAdd() throws Exception {


        MvcResult mvcResult = this.mockMvc.perform(post("/orders/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.getJsonOrder()))
                .andReturn();

        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(), "{\"id\":1,\"amount\":10,\"name\":\"Test 1\"}");
    }

    @Test
    public void testGetAll() throws Exception {
        // NOTE: This test will only work if we test add order before!
        MvcResult mvcResult = this.mockMvc.perform(get("/orders/all"))
                .andReturn();

        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(), "[{\"id\":1,\"amount\":10,\"name\":\"Test 1\"}]");
    }

    @Test
    public void testUpdate() throws Exception {
        // NOTE: This test will only work if we test add order before!
        Order order = new Order();
        order.setId(1L);
        order.setName("Test 2");
        order.setAmount(BigDecimal.ONE);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(order);

        MvcResult mvcResult = this.mockMvc.perform(put("/orders/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andReturn();

        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(), "{\"id\":1,\"amount\":1,\"name\":\"Test 2\"}");
    }

    @Test
    public void testDelete() throws Exception {
        // NOTE: This test will only work if we test add order before!

        MvcResult mvcResultCreated = this.mockMvc.perform(post("/orders/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.getJsonOrder()))
                .andReturn();


        Order orderToDelete = mapper.readValue(mvcResultCreated.getResponse().getContentAsString(), Order.class);

        MvcResult mvcResultDelete = this.mockMvc.perform(delete("/orders/delete?id=" + orderToDelete.getId()))
                .andReturn();

        Assertions.assertEquals(mvcResultDelete.getResponse().getContentAsString(), "[{\"id\":1,\"amount\":10,\"name\":\"Test 1\"}]");
    }

    private String getJsonOrder() throws JsonProcessingException {
        Order order = new Order();
        order.setName("Test 1");
        order.setAmount(BigDecimal.TEN);

        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(order);

    }

}
