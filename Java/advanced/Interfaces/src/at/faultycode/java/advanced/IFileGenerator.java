package at.faultycode.java.advanced;

import java.io.File;

/**
 * @author MaAb
 */
public interface IFileGenerator {

	/**
	 * Returns the directory of the system property "java.io.tmpdir"
	 * 
	 * @return system default directory or null
	 */
	default File getDefaultDirectory() {
		String defaultDir = System.getProperty("java.io.tmpdir");
		if (defaultDir != null) {
			return new File(defaultDir);
		}
		return null;
	}
	
	/**
	 * Returns a default file name for a generator which implements {@link IFileGenerator}
	 * 
	 * @return default file name
	 */
	String getDefaultFileName();
	
	/**
	 * Returns the generator name
	 * 
	 * @return generator name
	 */
	String getName();
}
