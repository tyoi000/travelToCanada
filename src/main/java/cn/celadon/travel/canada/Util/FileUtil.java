package cn.celadon.travel.canada.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by empqqty on 6/18/2017.
 */
public class FileUtil {

    public static String readFileContent(Path filePath) throws IOException{
        Files.readAllLines(filePath);
        return "";
    }
}
