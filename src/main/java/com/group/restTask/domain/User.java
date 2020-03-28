package com.group.restTask.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long numOfVisits;
    private long webPageID;

    public static long totalVisits = 0;
    private long dayOfVisit;

    public void setName(String name) {
        this.name = name;
    }

    public void setNumOfVisits(long numOfVisits) {
        this.numOfVisits = numOfVisits;
        totalVisits += numOfVisits;
    }

    public void setWebPageID(long webPageID) {
        this.webPageID = webPageID;
    }

    public long getDayOfVisit() {
        return dayOfVisit;
    }

    public void setDayOfVisit(long dayOfVisit) {
        this.dayOfVisit = dayOfVisit;
    }
}
