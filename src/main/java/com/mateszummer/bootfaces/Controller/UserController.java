package com.mateszummer.bootfaces.Controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mateszummer.bootfaces.DTO.UserDTO;
import com.mateszummer.bootfaces.Service.UserService;

@Scope(value = "session")
@Component(value = "userController")
@ELBeanName(value = "userController")
@Join(path = "/user", to = "/user-form.jsf")
public class UserController {
    @Autowired
    private UserService userService;

    private UserDTO userDTO = new UserDTO();

    public String save() {
        userService.saveUserDTO(userDTO);
        userDTO = new UserDTO();
        return "/user-list.xhtml?faces-redirect=true";
    }

    public UserDTO getUser() {
        return userDTO;
    }
}