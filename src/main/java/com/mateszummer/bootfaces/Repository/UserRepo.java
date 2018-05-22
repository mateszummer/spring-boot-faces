package com.mateszummer.bootfaces.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateszummer.bootfaces.Model.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
