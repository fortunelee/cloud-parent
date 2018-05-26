package com.cloud.service.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cloud.service.db.pojo.User;
import org.springframework.data.repository.query.Param;



@RepositoryRestResource(path = "user")
public interface UserRepository extends JpaRepository<User, Long>{
	
	
	@Query("from User u where u.id = :userid")
	public List<User> findByUserid(@Param("userid") int userid);
	
	
}
