package com.group7.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "grant_types")
public class GrantType {

    @Id
    private Integer grantTypeId;

    private String grantTypeName;

    public GrantType() {
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
