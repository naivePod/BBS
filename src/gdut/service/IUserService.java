package gdut.service;

import gdut.po.User;

public interface IUserService {
	public boolean login(String username, String password);
	public boolean regist(User user);
}
