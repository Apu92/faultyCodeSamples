package at.faultycode.soa.core.service.impl;

import at.faultycode.soa.core.service.IsNotFaultyService;

public class IsNotFaultyServiceImpl implements IsNotFaultyService {
	
	@Override
	public String getServiceName() {
		return IsNotFaultyServiceImpl.class.getSimpleName();
	}
}
