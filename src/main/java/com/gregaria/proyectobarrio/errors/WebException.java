/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gregaria.proyectobarrio.errors;

/**
 *
 * @author Nahue
 */
public class WebException extends Exception {

    private static final long serialVersionUID = 7883636384872015753L;

    public WebException(String msn) {
        super(msn);
    }
    
}
