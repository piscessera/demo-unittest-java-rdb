package com.piscessera.unittest.rdb.demo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@EqualsAndHashCode
public class OrderHeader {
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String profileId;
    @Getter @Setter
    private Timestamp datetime;

    @Getter @Setter
    private List<OrderDetail> orderDetailList;
    @Getter @Setter
    private Profile profile;
}
