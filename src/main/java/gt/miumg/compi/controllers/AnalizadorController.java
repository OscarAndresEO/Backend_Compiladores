/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.miumg.compi.controllers;

import antlr.Token;
//import gt.miumg.compi.AnalizadorJflex.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//import mi.primer.scanner.Scanner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import umg.compiladores.*;

/**
 *
 * @author Oscar
 */
@RestController
@RequestMapping("/analizador")
public class AnalizadorController {

    @PostMapping("/texto")
    public ResponseEntity<?> leerTexto(@RequestParam("textoJava") String texto) {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("texto", texto);
        } catch (Exception e) {
            return ResponseEntity.ok("No funcionó");
        }
        return ResponseEntity.ok(response);
    }

//
    @PostMapping("/archivo")
    public ResponseEntity<?> leerArchivo(@RequestParam("file") MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            
            Reader reader = new InputStreamReader(inputStream);
            Lexer analizadorLexico = new Lexer(reader);
            parser p = new parser(analizadorLexico);
            p.parse();
             
            return ResponseEntity.ok("TODO OK");
            // return ResponseEntity.ok(p.parse());

        } catch (Exception e) {
            return ResponseEntity.ok("No funcionó");
        }
    }

}
