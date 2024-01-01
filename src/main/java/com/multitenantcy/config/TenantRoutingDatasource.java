package com.multitenantcy.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

@Component
class TenantRoutingDatasource extends AbstractRoutingDataSource {

	@Autowired
	private TenantIdentifierResolver tenantIdentifierResolver;

	TenantRoutingDatasource() {
		setDefaultTargetDataSource(createEmbeddedDatabase("default"));

		HashMap<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put("VMWARE", createEmbeddedDatabase("VMWARE"));
		targetDataSources.put("PIVOTAL", createEmbeddedDatabase("PIVOTAL"));
		setTargetDataSources(targetDataSources);
	}

	@Override
	protected String determineCurrentLookupKey() {
//		return tenantIdentifierResolver.resolveCurrentTenantIdentifier();
		String currentTenant = tenantIdentifierResolver.resolveCurrentTenantIdentifier();
		System.out.println("Current Tenant Identifier: " + currentTenant);
		return currentTenant;
	}

	private DataSource createEmbeddedDatabase(String name) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/" + name + "?createDatabaseIfNotExist=true");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		return dataSource;
	}

}
