package supportlibraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 
public class PropertyLoader 
{
   
    private String propertyFile;

    public PropertyLoader(String propertyFile){
        this.propertyFile = propertyFile;
    }

    public Properties load(){
    	String relativePath = new File(System.getProperty("user.dir")).getAbsolutePath();
		if(relativePath.contains("supportlibraries")) {
			relativePath = new File(System.getProperty("user.dir")).getParent();
		}
		if(relativePath.contains("allocator")) {
			relativePath = new File(System.getProperty("user.dir")).getParent();
		}
		propertyFile = relativePath+propertyFile;
        Properties properties = new Properties();
        try{
            properties.load(new FileInputStream(propertyFile));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return properties;
    }
}