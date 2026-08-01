package com.project.tenant_management_user_service.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.math.BigDecimal;

public class TenantRegisterDTO {

    @NotNull(message = "Property ID is required")
    private Long propertyId;

    @NotNull(message = "Lease start date is required")
    private LocalDate leaseStartDate;

    @NotNull(message = "Lease end date is required")
    @Future(message = "Lease end date must be in the future")
    private LocalDate leaseEndDate;

    @NotNull(message = "Rent amount is required")
    @Positive(message = "Rent amount must be positive")
    private BigDecimal rentAmount;

    @NotNull(message = "Rent due day is required")
    private Integer rentDueDay;

    public Long getPropertyId() { return propertyId; }
    public void setPropertyId(Long propertyId) { this.propertyId = propertyId; }

    public LocalDate getLeaseStartDate() { return leaseStartDate; }
    public void setLeaseStartDate(LocalDate leaseStartDate) { this.leaseStartDate = leaseStartDate; }

    public LocalDate getLeaseEndDate() { return leaseEndDate; }
    public void setLeaseEndDate(LocalDate leaseEndDate) { this.leaseEndDate = leaseEndDate; }

    public BigDecimal getRentAmount() { return rentAmount; }
    public void setRentAmount(BigDecimal rentAmount) { this.rentAmount = rentAmount; }

    public Integer getRentDueDay() { return rentDueDay; }
    public void setRentDueDay(Integer rentDueDay) { this.rentDueDay = rentDueDay; }
}