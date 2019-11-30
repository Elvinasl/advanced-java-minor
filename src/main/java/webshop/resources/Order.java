package webshop.resources;

import java.math.BigDecimal;

public class Order {

    private BigDecimal amount;
    private String name;

    public Order(BigDecimal amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    public Order() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
