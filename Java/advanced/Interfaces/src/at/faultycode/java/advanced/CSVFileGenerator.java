package at.faultycode.java.advanced;

/**
 * @author MaAb
 */
public class CSVFileGenerator implements IFileGenerator {

	@Override
	public String getDefaultFileName() {
		return "newFile.csv";
	}

	@Override
	public String getName() {
		return "CSV";
	}
}
