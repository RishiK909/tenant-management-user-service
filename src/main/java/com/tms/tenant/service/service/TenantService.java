package com.tms.tenant.service.service;


import com.tms.tenant.service.dto.ApiResponse;
import com.tms.tenant.service.dto.TenantRegisterDTO;
import com.tms.tenant.service.entity.Tenant;

import java.util.List;
import java.util.UUID;

public interface TenantService {

    ApiResponse<Void> createTenantProfile(UUID userId, TenantRegisterDTO request);

    ApiResponse<Void> updateTenantProfile(UUID userId, TenantRegisterDTO request);

    ApiResponse<Tenant> getMyProfile(UUID userId);

    ApiResponse<List<Tenant>> getAllTenants();
}
