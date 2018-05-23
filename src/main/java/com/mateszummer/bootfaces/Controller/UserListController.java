package com.mateszummer.bootfaces.Controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mateszummer.bootfaces.DTO.UserDTO;
import com.mateszummer.bootfaces.Service.UserService;

import java.util.List;

@Scope (value = "session")
@Component (value = "userList")
@ELBeanName(value = "userList")
@Join(path = "/", to = "/user-list.jsf")
public class UserListController {
    @Autowired
    private UserService userService;

    private List<UserDTO> userDTOs;

    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
        userDTOs = userService.getAllUserDTOs();
    }

    public List<UserDTO> getUsers() {
        return userDTOs;
    }
    
    public String deleteUser(UserDTO userDTO) {
    	userService.deleteUserDTO(userDTO);
    	return "/user-list.xhtml?faces-redirect=true";
    }
}
