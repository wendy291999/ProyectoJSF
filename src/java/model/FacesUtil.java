/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.faces.event.ActionEvent;

/**
 *
 * @author wenkary
 */
public class FacesUtil {
    
    public static String getActionAttribute(ActionEvent event, String name) {
        return (String) event.getComponent().getAttributes().get(name);
    }
    
    public static Long getActionAttributeLong(ActionEvent event, String name) {
        return (Long) event.getComponent().getAttributes().get(name);
    }
}
