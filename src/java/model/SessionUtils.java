/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wenkary
 */
public class SessionUtils {
    
    public static ExternalContext getExternalContext() {
        return (ExternalContext) FacesContext.getCurrentInstance()
                .getExternalContext();
    }
    
    public static HttpSession getSession(){ 
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }
    
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }
    
    public static String getUsername()  {
        HttpSession httpSession = (HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext().getSession(false);
        return httpSession.getAttribute("username").toString();
    }
    
    public static String getUserId() {
        HttpSession httpSession = getSession();
        if(httpSession == null)
            return null;
        
        return (String) httpSession.getAttribute("userId");
    }
}
