
package com.group7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "research_projects")
public class ResearchProject {

    @Id
    @Column(name = "research_id")
    private Integer researchId;

    @Column(name = "so_code")
    private Integer soCode;

    @Column(name = "research_title")
    private String researchTitle;

    @Column(name = "grant_type_id")
    private Integer grantTypeId;

    @Column(name = "staff_no")
    private Integer staffNo;

    @Column(name = "research_status")
    private String researchStatus;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "expected_date")
    private LocalDate expectedDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    public ResearchProject() {
    }

    public Integer getResearchId() {
        return researchId;
    }

    public void setResearchId(Integer researchId) {
        this.researchId = researchId;
    }

    public Integer getSoCode() {
        return soCode;
    }

    public void setSoCode(Integer soCode) {
        this.soCode = soCode;
    }

    public String getResearchTitle() {
        return researchTitle;
    }

    public void setResearchTitle(String researchTitle) {
        this.researchTitle = researchTitle;
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

    public String getResearchStatus() {
        return researchStatus;
    }

    public void setResearchStatus(String researchStatus) {
        this.researchStatus = researchStatus;
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
}
