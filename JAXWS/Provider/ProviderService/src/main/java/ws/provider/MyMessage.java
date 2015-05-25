/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.provider;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danecek
 */
@XmlRootElement
public class MyMessage {

    public MyMessage(String mess) {
        this.mess = mess;
    }

    public MyMessage() {
    }

    private String mess;

    /**
     * @return the mess
     */
    public String getMess() {
        return mess;
    }

    /**
     * @param mess the mess to set
     */
    public void setMess(String mess) {
        this.mess = mess;
    }
}
