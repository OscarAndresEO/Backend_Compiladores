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
import java.io.StringReader;
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
    public ResponseEntity<?> leerTexto(@RequestParam("textoJava") String texto) throws Exception {
        parser p = null;
        try {
            Lexer analizadorLexico = new Lexer(new StringReader(texto));
            p = new parser(analizadorLexico);
        } catch (Exception e) {
            return ResponseEntity.ok("No funcionó");
        }
        return ResponseEntity.ok(p.parse());
    }

//
    @PostMapping("/archivo")
    public ResponseEntity<?> leerArchivo(@RequestParam("file") MultipartFile file) {
        parser p = null;
        try {
            InputStream inputStream = file.getInputStream();

            Reader reader = new InputStreamReader(inputStream);
            Lexer analizadorLexico = new Lexer(reader);
            p = new parser(analizadorLexico);

            return ResponseEntity.ok(p.parse());

        } catch (Exception e) {
            return ResponseEntity.ok("No funcionó");
        }
    }

}
