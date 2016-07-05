package atmatm6.modem.reading;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AdventureReader {
    static final Logger log = LogManager.getLogger("MoDem");
    static final Path path = Paths.get(System.getProperty("user.dir"), "adv");
    static BufferedReader in;
    static final File directions = new File(path.toString());
    static ObjectMapper mapper = new ObjectMapper();
    static JsonFactory jsonF = new JsonFactory();

    public static void initDirections() throws IOException {
        // TODO: Interpret JSON directions from files
        String[] directories = directions.list((current, name) -> new File(current, name).isDirectory());
        int lengthofarray = directories.length;
        if(lengthofarray != 0) {
            for (String dir : directories) {
                File fil = new File(dir);
                File[] filea = fil.listFiles();
                for (File filey:filea) {
                    if(filey.getName().endsWith(".asu")){
                        AdvFile af = mapper.readValue(filey, AdvFile.class);
                    } else if(filey.getName().endsWith("asum")){

                    }
                }
            }
        }
    }
}

/*if(!(lengthOfArray == 0)){
        for (File file : fileArray) {
        if(file.getName().endsWith(".asu")){
        AdvFile af = mapper.readValue(file, AdvFile.class);
        } else if(file.getName().endsWith("asur")){

        }
        }
        } else log.error("No files to check.");*/