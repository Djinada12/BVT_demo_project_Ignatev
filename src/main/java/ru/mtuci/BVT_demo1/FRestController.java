package ru.mtuci.BVT_demo1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api")
public class FRestController {

    private  final FService fService;

    public FRestController(FService fService)
    {
        this.fService = fService;
    }

    @GetMapping("/hello")
    public  String getMessage()
    {
        return fService.getMessage();
    }
    @PostMapping("/echo")
    public ResponseEntity<String> getResponseEntity(@RequestParam(name = "str") String string)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest =md.digest(string.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return  ResponseEntity.ok(string);
    }

}
