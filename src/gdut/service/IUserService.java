package gdut.service;

import java.util.List;

import gdut.po.User;

public interface IUserService {
	public User login(String username, String password);
	public boolean regist(User user);
	public boolean validateUserName(String username);
	public List<User> findAll();
}
