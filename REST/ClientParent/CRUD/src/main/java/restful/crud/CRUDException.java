/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.crud;

import javax.ws.rs.core.Response;

/**
 *
 * @author danecek
 */
public class CRUDException extends Exception {

    Response r;

    public CRUDException(String msg) {
        super(msg);
    }

    CRUDException(Response r) {
        this(r.toString());
        this.r = r;
    }
}
