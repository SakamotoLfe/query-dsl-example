package com.querydslexample.model;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * This class is created to make a model for Country between the database and the system.
 *
 * @author Alfredo Marin
 * @version 0.1
 * @since 12/10/2019
 */

@Entity
public class Country extends GenericEntity {

    /**
     * Country name.
     */
    @Column(length = 100, nullable = false, unique = true)
    private String name;

    /**
     * Country initials.
     */
    @Column(length = 2, nullable = false, unique = true)
    private char[] initials;

    /**
     * Country phone code.
     */
    @Column(length = 5, nullable = false)
    private char[] dialCode;

    /* Constructors */

    /**
     * Constructor with params and super class params
     *
     * @param id         Register's ID.
     * @param regDate    Date that the register was created.
     * @param lastUpdate Date that the register was last updated.
     * @param enable     If the register is active or not.
     * @param name       Country name.
     * @param initials   Country initials.
     * @param dialCode  Country phone code.
     */
    public Country(UUID id, Date regDate, Date lastUpdate, boolean enable, String name, char[] initials, char[] dialCode) {
        super(id, regDate, lastUpdate, enable);
        this.name = name;
        this.initials = initials;
        this.dialCode = dialCode;
    }

    /**
     * Constructor with com.qbcentral.main class parameters
     *
     * @param name      Country name.
     * @param initials  Country initials.
     * @param dialCode Country phone code.
     */
    public Country(String name, char[] initials, char[] dialCode) {
        this.dialCode = dialCode;
        super.setEnable(true);
        this.name = name;
        this.initials = initials;
    }

    /**
     * Empty constructor
     */
    public Country() {
        super.setEnable(true);
    }

    /* Equals and HashCode */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return name.equals(country.name) && Arrays.equals(initials, country.initials)
                && Arrays.equals(dialCode, country.dialCode);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(initials);
        result = 31 * result + Arrays.hashCode(dialCode);
        return result;
    }

    /* Getters and Setters */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char[] getInitials() {
        return initials;
    }

    public void setInitials(char[] initials) {
        this.initials = initials;
    }

    public char[] getDialCode() {
        return dialCode;
    }

    public void setDialCode(char[] dialCode) {
        this.dialCode = dialCode;
    }

    /* To String */

    /**
     * To String method
     *
     * @return {@link String}
     */
    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", initials=" + Arrays.toString(initials) +
                ", phoneCode=" + Arrays.toString(dialCode) +
                '}';
    }
}
