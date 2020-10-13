/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import model.SessionUtils;
import model.User;
import persistence.UserDAO;
/**
 *
 * @author wenkary
 */
@ManagedBean
@RequestScoped
public class UserBean {
    
    @ManagedProperty(value = "#{userDAO}")
    private UserDAO userDAO;
    @ManagedProperty(value = "#{user}")
    private User user;
    
    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public UserDAO getLoginDAO() {
        return userDAO;
    }

    public void setLoginDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    // actions
    
    public String login() {
        User currentUser = this.userDAO.login(this.user.getUsername(), this.user.getPassword());
        
        if(currentUser == null)
            return "login";
        
        SessionUtils.getSession().setAttribute("username", user.getUsername());
        SessionUtils.getSession().setAttribute("userId", user.getId());
        return "index";
    }
    
}
