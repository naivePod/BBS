package gdut.service;

import gdut.po.User;

public interface IUserService {
	public User login(String username, String password);
	public boolean regist(User user);
	public boolean validateUserName(String username);
}
