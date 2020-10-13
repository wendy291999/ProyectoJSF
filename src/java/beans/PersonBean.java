/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import model.FacesUtil;
import model.Person;
import model.SessionUtils;
import model.User;
import persistence.DAO;
import persistence.UserDAO;

/**
 *
 * @author wenkary
 */
@ManagedBean
@SessionScoped
public class PersonBean {
    
    @ManagedProperty(value = "#{dao}")
    private DAO dao;
    @ManagedProperty(value = "#{person}")
    private Person person;
    private User user;
    
    public PersonBean() {
        String username = SessionUtils.getUsername();
        String userId = SessionUtils.getUserId();
        this.user = new User();
        this.user.setUsername(username);
        this.user.setId(Long.parseLong(userId));
    }
    // setters and getters
    
    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    // actions
    
    public void create() {
        dao.create(person);
        this.resetForm();
    }
    
    public void delete(ActionEvent event) {
        Long personId = FacesUtil.getActionAttributeLong(event, "personId");
        Person  person = new Person();
        person.setId(personId);
        dao.delete(person);
    }
    
    public Person getById() {
        Person person = this.dao.getById(this.person.getId());
        return person;
    }
    
    public void update() {
        dao.update(person);
     
    }
    
    public List<Person> getAll() {
        List<Person> persons = this.dao.getAll();
        return persons;
    }
    
    // navigations
    
    public void goToDetails(ActionEvent event) {
        Long personId = FacesUtil.getActionAttributeLong(event, "personId");
        Person  person = this.dao.getById(personId);
        this.person = person;
    }
    
    public void resetForm() {
        this.person = new Person();
    }
    
}
