package com.qsx.crm.module.user.repository;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qsx.crm.model.UserModel;

@Repository
@Table(name = "qsx_user")
@Qualifier("userRepository")
public interface UserRepository extends CrudRepository<UserModel, Long>{
	public UserModel findOne(Long id);
	
	public UserModel save(UserModel userModel); 
	
	public UserModel findByloginName(String loginName);
}
