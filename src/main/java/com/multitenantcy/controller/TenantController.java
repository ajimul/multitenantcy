package com.multitenantcy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {

//	@Autowired
//	private TenantRoutingDatasource tenantRoutingDatasource;
//
//	@PostMapping("/{tenantId}")
//	public String createTenant(@PathVariable String tenantId) {
//		tenantRoutingDatasource.createTenant(tenantId);
//		return "Tenant '" + tenantId + "' created successfully.";
//	}
}
