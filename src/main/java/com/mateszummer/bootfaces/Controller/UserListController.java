package com.mateszummer.bootfaces.Controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mateszummer.bootfaces.Model.User;
import com.mateszummer.bootfaces.Repository.UserRepo;

import java.util.List;

@Scope (value = "session")
@Component (value = "userList")
@ELBeanName(value = "userList")
@Join(path = "/", to = "/user-list.jsf")
public class UserListController {
    @Autowired
    private UserRepo userRepo;

    private List<User> users;

    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
        users = userRepo.findAll();
    }

    public List<User> getUsers() {
        return users;
    }
    
    public String deleteUser(User user) {
    	userRepo.delete(user);
    	return "/user-list.xhtml?faces-redirect=true";
    }
}
