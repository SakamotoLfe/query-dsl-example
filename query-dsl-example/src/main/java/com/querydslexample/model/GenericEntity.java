package com.querydslexample.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * This class is created to make a generic entity for the entire system.
 *
 * @author Alfredo Marin
 * @version ALPHA-0.0.1
 * @since 12/10/2019
 */

@MappedSuperclass
public class GenericEntity {

    /**
     * Register's ID.
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    /**
     * Date that the register was created.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdDate;

    /**
     * Date that the register was last updated.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date lastUpdate;

    /**
     * If the register is active or not.
     */
    @Column(nullable = false)
    private boolean enable;

    /* Constructors */

    /**
     * Constructor with params
     *
     * @param id          Register's ID.
     * @param createdDate Date that the register was created.
     * @param lastUpdate  Date that the register was last updated.
     * @param enable      If the register is active or not.
     */
    public GenericEntity(UUID id, Date createdDate, Date lastUpdate, boolean enable) {
        this.id = id;
        this.createdDate = createdDate;
        this.lastUpdate = lastUpdate;
        this.enable = enable;
    }

    /**
     * Empty constructor
     */
    public GenericEntity() {
        setEnable(true);
    }

    /* Getters and Setters */

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    // Pre persist

    /**
     * Method to automatically put a register date on each register saved on database.
     */
    @PrePersist
    private void putRegDate() {
        this.setCreatedDate(new Date());
    }

    // Pre update

    /**
     * Method to automatically put the last date that the register was been updated.
     */
    @PreUpdate
    private void putLastUpdate() {
        this.setLastUpdate(new Date());
    }

    /* To String */

    /**
     * To String method
     *
     * @return {@link String}
     */
    @Override
    public String toString() {
        return "GenericEntity{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", lastUpdate=" + lastUpdate +
                ", enable=" + enable +
                '}';
    }
}
