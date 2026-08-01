package com.project.tenant_management_user_service.service;



import com.project.tenant_management_user_service.Repository.TenantRepository;
import com.project.tenant_management_user_service.dto.ApiResponse;
import com.project.tenant_management_user_service.dto.TenantRegisterDTO;
import com.project.tenant_management_user_service.entity.Tenant;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    public TenantServiceImpl(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public ApiResponse<Void> createTenantProfile(Long userId, TenantRegisterDTO request) {

        if (tenantRepository.findByUserId(userId).isPresent()) {
            return new ApiResponse<>("Tenant profile already exists for this user", false);
        }

        Tenant tenant = new Tenant();
        tenant.setUserId(userId);
        tenant.setPropertyId(request.getPropertyId());
        tenant.setLeaseStartDate(request.getLeaseStartDate());
        tenant.setLeaseEndDate(request.getLeaseEndDate());
        tenant.setRentAmount(request.getRentAmount());
        tenant.setRentDueDay(request.getRentDueDay());

        tenantRepository.save(tenant);

        return new ApiResponse<>("Tenant profile created successfully", true);
    }

    @Override
    public ApiResponse<Tenant> getMyProfile(Long userId) {

        Optional<Tenant> tenantOptional = tenantRepository.findByUserId(userId);

        if (tenantOptional.isEmpty()) {
            return new ApiResponse<>("Tenant profile not found", false);
        }

        return new ApiResponse<>("Tenant profile fetched successfully", true, tenantOptional.get());
    }
}
