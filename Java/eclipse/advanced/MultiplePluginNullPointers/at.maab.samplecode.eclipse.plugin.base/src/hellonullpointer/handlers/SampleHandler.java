package hellonullpointer.handlers;

import java.util.Random;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		MessageDialog.openInformation(
				window.getShell(),
				"HelloNullPointer",
				"Hello, Eclipse world");
		return null;
	}
	
	public static void printEventName(String eventName) {
		System.out.println(eventName.trim());
		
		String message = null;
		
		Random ran = new Random();
		int x = ran.nextInt(6);
		if (x == 2){
			message = message.concat("We have a problem here.");
		} else {
			message = "No bug occurred! Try another number of arguments.";
		}
		
		System.out.println(message);
	}
}