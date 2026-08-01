package com.project.tenant_management_user_service.service;


import com.project.tenant_management_user_service.dto.ApiResponse;
import com.project.tenant_management_user_service.dto.TenantRegisterDTO;
import com.project.tenant_management_user_service.entity.Tenant;

import java.util.List;

public interface TenantService {

    ApiResponse<Void> createTenantProfile(Long userId, TenantRegisterDTO request);

    ApiResponse<Void> updateTenantProfile(Long userId, TenantRegisterDTO request);

    ApiResponse<Tenant> getMyProfile(Long userId);

    ApiResponse<List<Tenant>> getAllTenants();
}
