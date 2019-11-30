package webshop.resources;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Order {

    @NotNull
    private BigDecimal amount;
    @Length(min = 1, max = 255)
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
