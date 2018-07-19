package gdut.dao;

import java.util.List;

import gdut.po.User;

public interface IUserDao {
	public void insert(User user);
	public void update(User user);
	public void delete(User user);
	public User findById(Integer id);
	public List<User> findAll();
	/**
	 *@author ChengJin
	 * @param user 用户信息
	 * @return 返回boolean类型数据，true表示登录成功，false表示登录失败。
	 */
	public boolean registUser(User user);
	
	/*
	 * 通过用户名字和密码查找用户，返回User
	 * */
	public User selectByUsernameAndPassword(String username, String password);
	
	public int selectByUserName(String username);
	

}
