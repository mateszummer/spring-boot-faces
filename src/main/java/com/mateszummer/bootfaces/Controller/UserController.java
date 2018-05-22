package com.mateszummer.bootfaces.Controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mateszummer.bootfaces.Model.User;
import com.mateszummer.bootfaces.Repository.UserRepo;

@Scope(value = "session")
@Component(value = "userController")
@ELBeanName(value = "userController")
@Join(path = "/user", to = "/user-form.jsf")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    private User user = new User();

    public String save() {
        userRepo.save(user);
        user = new User();
        return "/user-list.xhtml?faces-redirect=true";
    }

    public User getUser() {
        return user;
    }
}