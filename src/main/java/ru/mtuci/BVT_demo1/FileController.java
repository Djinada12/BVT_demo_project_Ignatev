package ru.mtuci.BVT_demo1;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/files")
public class FileController
{
    private final FileRepository  fileRepository;

    public  FileController(FileRepository fileRepository)
    {
        this.fileRepository = fileRepository;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> saveFile(@RequestBody FileEntity file)
    {
        fileRepository.save(file);
        return ResponseEntity.ok("File uploaded");
    }
}
