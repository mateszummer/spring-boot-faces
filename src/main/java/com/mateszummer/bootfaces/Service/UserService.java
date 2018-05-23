package com.mateszummer.bootfaces.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateszummer.bootfaces.DTO.UserDTO;
import com.mateszummer.bootfaces.Model.User;
import com.mateszummer.bootfaces.Repository.UserRepo;

@Service
public class UserService {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UserRepo userRepo;
	
	public void deleteUserDTO(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		userRepo.delete(user);
	}
	
	public void saveUserDTO(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		userRepo.save(user);
	}
	
	public List<UserDTO> getAllUserDTOs() {
		return userRepo.findAll().stream().map(a -> modelMapper.map(a, UserDTO.class)).collect(Collectors.toList());
	}
	
}
