package gdut.dao;

import java.util.List;

import gdut.po.User;

public interface IUserDao {
	public void insert(User user);
	public void update(User user);
	public void delete(User user);
	public User findById(Integer id);
	public List<User> findAll();
	public User selectByUsernameAndPassword(String username, String password);
}
