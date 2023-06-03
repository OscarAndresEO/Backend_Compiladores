/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.miumg.compi.Analizadorjflex;
/**
 *
 * @author Oscar
 */


public class Token {
    private int fila;
    private int columna;
    private String lexema;

    public Token(int fila, int columna, String lexema) {
        this.fila = fila;
        this.columna = columna;
        this.lexema = lexema;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public String getLexema() {
        return lexema;
    }
}
