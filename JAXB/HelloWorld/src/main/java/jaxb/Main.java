/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.xml.bind.JAXB;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) throws IOException {
        File pointXML = new File("point.xml");
        JAXB.marshal(new Point(3, 4), pointXML);
        Files.copy(pointXML.toPath(), System.out);
        Point point = JAXB.unmarshal(pointXML, Point.class);
        System.out.println(point);
    }
}
