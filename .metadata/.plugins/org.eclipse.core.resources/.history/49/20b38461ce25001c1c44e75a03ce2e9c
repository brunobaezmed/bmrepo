
package com.S1.Sone.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.S1.Sone.models.Users;

@RestController
public interface IControl {

	
	public Users user(@PathVariable long id);
	public String get_usermail(@PathVariable long id);
	public String get_userphone(@PathVariable long id);
	public String[] get_usernameLast(@PathVariable long id);
	public Users ins_user(@PathVariable long id);
}