package com.example.gtfurb.utils;

import java.util.Date;

import org.springframework.context.annotation.FilterType;

import lombok.Generated;

public class FilterQueryImpl {
    private String field;
    private FilterType type;
    private String stringValue;
    private Long longValue;
    private Boolean boolValue;
    private Date dateValue;
 
    @Generated
    public String getField() {
       return this.field;
    }
 
    @Generated
    public FilterType getType() {
       return this.type;
    }
 
    @Generated
    public String getStringValue() {
       return this.stringValue;
    }
 
    @Generated
    public Long getLongValue() {
       return this.longValue;
    }
 
    @Generated
    public Boolean getBoolValue() {
       return this.boolValue;
    }
 
    @Generated
    public Date getDateValue() {
       return this.dateValue;
    }
 
    @Generated
    public void setField(final String field) {
       this.field = field;
    }
 
    @Generated
    public void setType(final FilterType type) {
       this.type = type;
    }
 
    @Generated
    public void setStringValue(final String stringValue) {
       this.stringValue = stringValue;
    }
 
    @Generated
    public void setLongValue(final Long longValue) {
       this.longValue = longValue;
    }
 
    @Generated
    public void setBoolValue(final Boolean boolValue) {
       this.boolValue = boolValue;
    }
 
    @Generated
    public void setDateValue(final Date dateValue) {
       this.dateValue = dateValue;
    }
 
    @Generated
    public FilterQueryImpl(final String field, final FilterType type, final String stringValue, final Long longValue, final Boolean boolValue, final Date dateValue) {
       this.field = field;
       this.type = type;
       this.stringValue = stringValue;
       this.longValue = longValue;
       this.boolValue = boolValue;
       this.dateValue = dateValue;
    }
 
    @Generated
    public FilterQueryImpl() {
    }
 }
