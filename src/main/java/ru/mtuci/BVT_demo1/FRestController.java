package ru.mtuci.BVT_demo1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return  ResponseEntity.ok(string);
    }

}
