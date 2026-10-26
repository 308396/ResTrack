
package com.group7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "research_project")
public class ResearchProjectSingle {

    @Id
    @Column(name = "so_code")
    private String soCode;

    @Column(name = "research_title")
    private String researchTitle;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "expected_date")
    private LocalDate expectedDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "grant_type_id")
    private Integer grantTypeId;

    @Column(name = "staff_no")
    private Integer staffNo;

    @Column(name = "status_id")
    private Integer statusId;

    public ResearchProjectSingle() {
    }

    public String getSoCode() {
        return soCode;
    }

    public void setSoCode(String soCode) {
        this.soCode = soCode;
    }

    public String getResearchTitle() {
        return researchTitle;
    }

    public void setResearchTitle(String researchTitle) {
        this.researchTitle = researchTitle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(LocalDate expectedDate) {
        this.expectedDate = expectedDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getGrantTypeId() {
        return grantTypeId;
    }

    public void setGrantTypeId(Integer grantTypeId) {
        this.grantTypeId = grantTypeId;
    }

    public Integer getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(Integer staffNo) {
        this.staffNo = staffNo;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
}
