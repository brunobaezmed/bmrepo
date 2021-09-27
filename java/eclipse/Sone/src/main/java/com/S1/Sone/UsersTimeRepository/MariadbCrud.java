package com.S1.Sone.UsersTimeRepository;

import org.springframework.data.repository.CrudRepository;

import com.S1.Sone.models.Userstime;

public interface MariadbCrud extends CrudRepository<Userstime,Long> {

}
