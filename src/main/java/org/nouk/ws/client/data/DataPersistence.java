package org.nouk.ws.client.data;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
abstract class DataPersistence {
    private String userHome;
    private String dir = "/.wsClient/";

    @PostConstruct
    private void init() throws IOException {
        userHome = System.getProperty("user.home");
        Path path = Paths.get(userHome + dir);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }

    abstract String file();

    private Path filePath(){
        return Paths.get(userHome + dir + file());
    }
    protected void buildFile() throws IOException {
        if(!Files.exists(filePath())){
            Files.createFile(filePath());
        }
    }

    abstract String data2String();
    public void data2File() throws IOException {
        Files.write(filePath(),data2String().getBytes(StandardCharsets.UTF_8));
    }

    abstract void string2Data(String str);
    public void file2Data() throws IOException {
        string2Data(new String(Files.readAllBytes(filePath())));
    }
}
