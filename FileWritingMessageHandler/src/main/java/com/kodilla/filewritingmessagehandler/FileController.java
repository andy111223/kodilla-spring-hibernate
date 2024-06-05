package com.kodilla.filewritingmessagehandler;

import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {

    private static final String INPUT_DIRECTORY = "data/input";
    private static final String OUTPUT_FILE = "data/output/log.txt";

    @PostMapping("/create")
    public String createFile(@RequestParam String fileName, @RequestParam String content) throws IOException {
        File file = new File(INPUT_DIRECTORY + "/" + fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        }
        return "File created: " + fileName;
    }

    @GetMapping("/log")
    public List<String> readLogFile() throws IOException {
        return Files.readAllLines(Paths.get(OUTPUT_FILE));
    }
}
