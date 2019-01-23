package at.faultycode.soa.core.handlers;

import java.util.logging.Logger;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import at.faultycode.soa.core.service.IsFaultyService;
import at.faultycode.soa.core.service.IsNotFaultyService;
import at.faultycode.soa.core.service.MayBeFaultyService;
import at.faultycode.soa.core.service.impl.IsFaultyServiceImpl;
import at.faultycode.soa.core.service.infrastructure.ServiceProvider;

import org.eclipse.jface.dialogs.MessageDialog;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {

	private static final Logger LOGGER = Logger
			.getLogger(SampleHandler.class.getName());
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
//		IsFaultyServiceImpl obj = new IsFaultyServiceImpl();
//		LOGGER.info(obj.getServiceName().trim());
		
//		IsNotFaultyService notFaultyService = ServiceProvider.getService(IsNotFaultyService.class);
//		LOGGER.info(notFaultyService.getServiceName().trim());
//		
//		MayBeFaultyService mayBeFaultyService = ServiceProvider.getService(MayBeFaultyService.class);
//		LOGGER.info(mayBeFaultyService.getServiceName().trim());
//		
		IsFaultyServiceImpl isFaultyService = ServiceProvider.getService(IsFaultyService.class);
		LOGGER.info(isFaultyService.getServiceName().trim());
		
		
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		MessageDialog.openInformation(
				window.getShell(),
				"Core",
				"Hello, Eclipse world");
		return null;
	}
}
