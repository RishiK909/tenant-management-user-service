package com.project.tenant_management_user_service.service;


import com.project.tenant_management_user_service.dto.ApiResponse;
import com.project.tenant_management_user_service.dto.TenantRegisterDTO;
import com.project.tenant_management_user_service.entity.Tenant;

public interface TenantService {

    ApiResponse<Void> createTenantProfile(Long userId, TenantRegisterDTO request);

    ApiResponse<Tenant> getMyProfile(Long userId);
}
