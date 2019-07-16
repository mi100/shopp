package dmytro.shop.controller;

import dmytro.shop.dto.request.FileRequest;
import dmytro.shop.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public String upload(@RequestBody FileRequest fileRequest) throws IOException{

    String filePath = fileService.saveFile(fileRequest);
    return filePath;
    }
}
