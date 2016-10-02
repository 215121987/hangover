package com.hangover.java.model;

import com.hangover.java.model.type.OfferFor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 10/2/16
 * Time: 5:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@javax.persistence.Table(name = "offers")
@XmlRootElement(name = "offers")
public class OffersEntity extends BaseEntity{
    
    private String imageURL;
    private OfferFor offerFor = OfferFor.WEB;
    private String description;
    private String title;
    private String subTitle;
    private int priority =1;


    @Column(name = "image_url")
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Enumerated
    @Column(name = "offer_for")
    public OfferFor getOfferFor() {
        return offerFor;
    }

    public void setOfferFor(OfferFor offerFor) {
        this.offerFor = offerFor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Column(name = "priority", nullable = false)
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
