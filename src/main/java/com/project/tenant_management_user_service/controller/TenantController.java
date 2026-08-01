package com.project.tenant_management_user_service.controller;


import com.project.tenant_management_user_service.dto.ApiResponse;
import com.project.tenant_management_user_service.dto.TenantRegisterDTO;
import com.project.tenant_management_user_service.entity.Tenant;
import com.project.tenant_management_user_service.service.TenantService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenant")
public class TenantController {

    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping("/create-profile")
    @PreAuthorize("hasRole('Tenant')")
    public ResponseEntity<ApiResponse<Void>> createProfile(
            @Valid @RequestBody TenantRegisterDTO request,
            HttpServletRequest httpRequest) {

        Long userId = (Long) httpRequest.getAttribute("userId");

        ApiResponse<Void> response = tenantService.createTenantProfile(userId, request);
        return response.isStatus()
                ? ResponseEntity.ok(response)
                : ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/get-profile")
    public ResponseEntity<ApiResponse<Tenant>> getMyProfile(HttpServletRequest httpRequest) {

        Long userId = (Long) httpRequest.getAttribute("userId");

        ApiResponse<Tenant> response = tenantService.getMyProfile(userId);
        return response.isStatus()
                ? ResponseEntity.ok(response)
                : ResponseEntity.badRequest().body(response);
    }

    @PutMapping("/update-profile")
    public ResponseEntity<ApiResponse<Void>> updateProfile(
            @Valid @RequestBody TenantRegisterDTO request,
            HttpServletRequest httpRequest) {

        Long userId = (Long) httpRequest.getAttribute("userId");

        ApiResponse<Void> response = tenantService.updateTenantProfile(userId, request);
        return response.isStatus()
                ? ResponseEntity.ok(response)
                : ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/get-all")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<ApiResponse<List<Tenant>>> getAllTenants() {
        ApiResponse<List<Tenant>> response = tenantService.getAllTenants();
        return ResponseEntity.ok(response);
    }
}
