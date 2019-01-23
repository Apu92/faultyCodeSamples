package at.faultycode.soa.core.service.infrastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;


public class ServiceProvider {

	private static final Logger LOGGER = Logger
			.getLogger(ServiceProvider.class.getName());
	
	private static final String CLASS_PROPERTY = "class";
	
	/** Map which contains all instances of existing {@link IService} **/
	protected static Map<Class<? extends IService>, IService> instanceMap = new HashMap<>();
	
	  protected static List<ClassLoader> registry;
	  
	
	@SuppressWarnings("unchecked")
	public static <T extends IService> T getService(Class<? extends IService> clazz) {
	    try {
	      if (IService.class.isAssignableFrom(clazz)) {
	        if (instanceMap.containsKey(clazz)) {
	          // Service instance already existing
	          return (T) instanceMap.get(clazz);
	        }
	        T serviceInstance = null;
	        if (clazz.isInterface()) {
	          // Service interface (regular case)
	          serviceInstance = determineServiceInstance(clazz);
	        } else {
	          // Service implementation
	          serviceInstance = (T) clazz.newInstance();
	        }
	        if (serviceInstance != null) {
	            instanceMap.put(clazz, serviceInstance);
	            return serviceInstance;
	        }
	      }
	      throw new RuntimeException("Class does not implement IService interface"); 
	    } catch (InstantiationException | IllegalAccessException ex) {
	      LOGGER.log(Level.WARNING, "Error: ", ex);
	      return null;
	    }
	  }
	
	@SuppressWarnings("unchecked")
	protected static <T extends IService> T determineServiceInstance(
			Class<? extends IService> clazz) {
		T serviceInstance = null;
		int currentRanking = -1;
	    IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
	    if (extensionRegistry != null) {
	      IConfigurationElement[] ptcConfigurationElements =
	          extensionRegistry.getConfigurationElementsFor(IService.SERVICE_ID);
	      for (IConfigurationElement iface : ptcConfigurationElements) {
	        if (iface.getAttribute(CLASS_PROPERTY).equals(clazz.getName())) {
	          for (IConfigurationElement impl : iface.getChildren("impl")) {
	            try {
	              int ranking = Integer.valueOf(impl.getAttribute("ranking"));
	              if (ranking > currentRanking) {
	                Object service = impl.createExecutableExtension(CLASS_PROPERTY);
	                if (clazz.isAssignableFrom(service.getClass())) {
	                  serviceInstance = (T) service;
	                  currentRanking = ranking;
	                }
	              }
	            } catch (CoreException | NumberFormatException ex) {
	            	LOGGER.log(Level.WARNING, "Error: ", ex);
	            }
	          }
	        }
	      }
	    }
		
		return serviceInstance;
	}
	
	  protected static List<ClassLoader> getRegistry() {
		    if (registry == null) {
		      registry = new ArrayList<>();
		      registerClassLoader(ServiceProvider.class.getClassLoader());
		    }
		    return registry;
		  }

		  public static void registerClassLoader(ClassLoader classLoader) {
		    if (!getRegistry().contains(classLoader)) {
		      getRegistry().add(classLoader);
		    }
		  }
	
}
