package ru.mtuci.BVT_demo1;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

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
    public ResponseEntity<String> saveFile(@RequestParam(name="file") MultipartFile file)
    {
        if (file.isEmpty())
        {
            return  ResponseEntity.badRequest().body("Empty file");
        }
        try
        {
            String filename = file.getOriginalFilename();
            byte[] bytes = file.getBytes();

            FileEntity fileEntity = new FileEntity();
            fileEntity.setFileName(filename);
            fileEntity.setData(bytes);

            fileRepository.save(fileEntity);
            return  ResponseEntity.ok().body("Файл успешно загружен" + filename);

        } catch (IOException ex)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable(name= "id") Long id)
    {
        Optional<FileEntity> optionalFileEntity = fileRepository.findById(id);
        if(optionalFileEntity.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }

        FileEntity fileEntity = optionalFileEntity.get();

        return ResponseEntity.ok().body(fileEntity.getData());
    }


}
