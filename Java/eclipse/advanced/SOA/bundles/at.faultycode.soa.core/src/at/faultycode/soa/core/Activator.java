package at.faultycode.soa.core;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import at.faultycode.soa.core.service.infrastructure.ServiceProvider;


/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "at.faultycode.core"; //$NON-NLS-1$

  // The shared instance
  private static Activator plugin;


  public Activator() {}

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static Activator getDefault() {
    return plugin;
  }

  public static ImageDescriptor getImageDescriptor(String path) {
    return imageDescriptorFromPlugin(PLUGIN_ID, path);
  }

  /**
   * This method will be executed at the beginning of the application.
   * Here you can add functionality, you need before the application is started.
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
    ServiceProvider.registerClassLoader(getClass().getClassLoader());
  }

  /**
   * This method will be executed when the application will be stopped.
   * Here you can add functionality, you need to do when the application is stopped.
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }

}

