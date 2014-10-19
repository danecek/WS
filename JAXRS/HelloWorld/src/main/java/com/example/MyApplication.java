/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.Collections;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author danecek
 */
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Collections.singleton(MyResource.class);
    }

}
