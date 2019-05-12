package com.piscessera.unittest.rdb.demo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class Item {
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String name;
}
