package com.shopping.shopping.domain;

import com.shopping.shopping.enums.CurrencyType;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_price")
@EqualsAndHashCode(of = "id")
public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal amount;

    //@Enumerated(EnumType.STRING)
    private CurrencyType currency;

    public ProductPrice() {
    }

}
