package com.example.gtfurb.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.FilterType;

import lombok.Generated;

public class FilterImpl {
    private List<FilterQueryImpl> filter;
    private Integer page;
    private Integer size;
    private String order;

    public static FilterImpl parse(String filter, Integer size, Integer page, String order) {
        List<FilterQueryImpl> queries = new ArrayList<>();
        if (filter != null && !filter.isEmpty()) {
            String[] filters = filter.split(" AND ");
            String[] var9 = filters;
            int var8 = filters.length;

            for (int var7 = 0; var7 < var8; ++var7) {
                String fs = var9[var7];
                String[] fss = fs.split(" ");
                String right = "";

                for (int i = 2; i < fss.length; ++i) {
                    right = right + fss[i];
                }

                FilterQueryImpl query = new FilterQueryImpl();
                query.setField(fss[0]);
                query.setType(FilterType.valueOf(fss[1]));
                boolean settedValue = false;

                try {
                    query.setLongValue(Long.parseLong(right));
                    settedValue = true;
                } catch (NumberFormatException var16) {
                }

                if (("true".equals(right) || "false".equals(right)) && !settedValue) {
                    query.setBoolValue(Boolean.parseBoolean(right));
                    settedValue = true;
                }

                if (!settedValue) {
                    try {
                        if (right.endsWith("Z")) {
                            right = right.replace("Z", "+00:00");
                        }

                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                        query.setDateValue(dateFormat.parse(right));
                        settedValue = true;
                    } catch (ParseException var15) {
                        right = right.replace("+00:00", "Z");
                    }
                }

                if (!settedValue) {
                    query.setStringValue(right);
                }

                queries.add(query);
            }
        }

        return new FilterImpl(queries, page, size, order);
    }

    @Generated
    public List<FilterQueryImpl> getFilter() {
        return this.filter;
    }

    @Generated
    public Integer getPage() {
        return this.page;
    }

    @Generated
    public Integer getSize() {
        return this.size;
    }

    @Generated
    public String getOrder() {
        return this.order;
    }

    @Generated
    public void setFilter(final List<FilterQueryImpl> filter) {
        this.filter = filter;
    }

    @Generated
    public void setPage(final Integer page) {
        this.page = page;
    }

    @Generated
    public void setSize(final Integer size) {
        this.size = size;
    }

    @Generated
    public void setOrder(final String order) {
        this.order = order;
    }

    @Generated
    public FilterImpl(final List<FilterQueryImpl> filter, final Integer page, final Integer size, final String order) {
        this.filter = filter;
        this.page = page;
        this.size = size;
        this.order = order;
    }

    @Generated
    public FilterImpl() {
    }
}
