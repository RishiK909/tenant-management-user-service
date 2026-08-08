package com.project.tenant_management_user_service.service;


import com.project.tenant_management_user_service.dto.ApiResponse;
import com.project.tenant_management_user_service.dto.TenantRegisterDTO;
import com.project.tenant_management_user_service.entity.Tenant;

import java.util.List;
import java.util.UUID;

public interface TenantService {

    ApiResponse<Void> createTenantProfile(UUID userId, TenantRegisterDTO request);

    ApiResponse<Void> updateTenantProfile(UUID userId, TenantRegisterDTO request);

    ApiResponse<Tenant> getMyProfile(UUID userId);

    ApiResponse<List<Tenant>> getAllTenants();
}
