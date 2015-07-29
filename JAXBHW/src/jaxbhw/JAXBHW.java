/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbhw;

import javax.xml.bind.JAXB;

/**
 *
 * @author Student
 */
public class JAXBHW {
    
    
    public int value = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JAXB.marshal(new JAXBHW(), System.out);
        
        
        // TODO code application logic here
    }
    
}
