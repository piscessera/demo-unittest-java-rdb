package com.piscessera.unittest.rdb.demo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class OrderDetail {
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String itemId;
    @Getter @Setter
    private String orderHeaderId;
    @Getter @Setter
    private Integer quantity;

    @Getter @Setter
    private Item item;
}
