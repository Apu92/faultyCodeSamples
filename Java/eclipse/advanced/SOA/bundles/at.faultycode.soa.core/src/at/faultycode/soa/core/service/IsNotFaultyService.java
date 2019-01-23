package at.faultycode.soa.core.service;

import at.faultycode.soa.core.service.infrastructure.IService;

public interface IsNotFaultyService extends IService {

	/** Returns the {@link IService} name **/
	public String getServiceName();
}
