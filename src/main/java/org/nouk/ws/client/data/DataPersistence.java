package org.nouk.ws.client.data;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
abstract class DataPersistence {
    private String userDir;
    private String dir = "/.wsClient/";
    private static final String ENCODING_SYSTEM_PROPERTY  = "sun.jnu.encoding";

    @PostConstruct
    private void init() throws IOException {
        userDir = System.getProperty("user.dir");
        Path path = Paths.get(userDir + dir);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }

    abstract String file();

    private Path filePath(){
        return Paths.get(userDir + dir + file());
    }
    protected void buildFile() throws IOException {
        if(!Files.exists(filePath())){
            Files.createFile(filePath());
        }
    }

    abstract String data2String();
    public void data2File() throws IOException {
        if(StringUtils.isNoneEmpty(data2String())){
            Charset charset = Charset.forName(System.getProperty(ENCODING_SYSTEM_PROPERTY));
            Files.write(filePath(),data2String().getBytes(charset));
        }
    }

    abstract void string2Data(String str);
    public void file2Data() throws IOException {
        Charset charset = Charset.forName(System.getProperty(ENCODING_SYSTEM_PROPERTY));
        string2Data(new String(Files.readAllBytes(filePath()), charset));
    }
}
