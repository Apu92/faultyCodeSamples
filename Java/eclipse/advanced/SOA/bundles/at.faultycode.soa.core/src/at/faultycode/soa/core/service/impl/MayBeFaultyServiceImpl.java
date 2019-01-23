package at.faultycode.soa.core.service.impl;

import java.util.Random;

import at.faultycode.soa.core.service.MayBeFaultyService;

public class MayBeFaultyServiceImpl implements MayBeFaultyService {
	
	@Override
	public String getServiceName() {
		Random random = new Random();
		if (random.nextInt(11) > 5) {
			return MayBeFaultyServiceImpl.class.getSimpleName();
		}
		return null;
	}
}
