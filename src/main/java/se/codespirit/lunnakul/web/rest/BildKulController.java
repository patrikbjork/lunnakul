package se.codespirit.lunnakul.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import se.codespirit.lunnakul.service.BildKulService;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

@RestController
@RequestMapping("/api")
public class BildKulController {

    @Autowired
    private BildKulService bildKulService;

    @PostMapping(path = "/bild-kul-upload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Object> saveEmployee(@RequestPart MultipartFile kulBild) throws IOException {

        InputStream inputStream = kulBild.getInputStream();

        StringWriter out = new StringWriter();
        bildKulService.convertToAscii(inputStream, new PrintWriter(out));

        return ResponseEntity.ok(out.toString().replace(System.getProperty("line.separator"), "<br>"));
    }
}
