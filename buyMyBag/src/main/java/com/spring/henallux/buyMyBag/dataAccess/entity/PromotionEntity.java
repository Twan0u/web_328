package com.spring.henallux.buyMyBag.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="promotion")
public class PromotionEntity {
    @Id
    @Column
    private String eventname;

    @Column
    private Date event_start_date;

    @Column
    private Date event_end_date;

    @Column
    private Double min_order_price_for_application;

    @Column
    private String image_url;

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public Date getEvent_start_date() {
        return event_start_date;
    }

    public void setEvent_start_date(Date event_start_date) {
        this.event_start_date = event_start_date;
    }

    public Date getEvent_end_date() {
        return event_end_date;
    }

    public void setEvent_end_date(Date event_end_date) {
        this.event_end_date = event_end_date;
    }

    public Double getMin_order_price_for_application() {
        return min_order_price_for_application;
    }

    public void setMin_order_price_for_application(Double min_order_price_for_application) {
        this.min_order_price_for_application = min_order_price_for_application;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
