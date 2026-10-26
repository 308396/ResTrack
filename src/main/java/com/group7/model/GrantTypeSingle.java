package com.group7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "grant_type")
public class GrantTypeSingle {

    @Id
    @Column(name = "grant_type_id")
    private Integer grantTypeId;

    @Column(name = "grant_type_name")
    private String grantTypeName;

    public GrantTypeSingle() {
    }

    public Integer getGrantTypeId() {
        return grantTypeId;
    }

    public void setGrantTypeId(Integer grantTypeId) {
        this.grantTypeId = grantTypeId;
    }

    public String getGrantTypeName() {
        return grantTypeName;
    }

    public void setGrantTypeName(String grantTypeName) {
        this.grantTypeName = grantTypeName;
    }
}
