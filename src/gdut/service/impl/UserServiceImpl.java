package gdut.service.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import gdut.dao.IUserDao;
import gdut.po.User;
import gdut.service.IUserService;
import gdut.util.Const;

public class UserServiceImpl implements IUserService {
	private IUserDao iUserDao;

	public IUserDao getiUserDao() {
		return iUserDao;
	}

	public void setiUserDao(IUserDao iUserDao) {
		this.iUserDao = iUserDao;
	}

	@Override
	public User login(String username, String password) {
		User user = iUserDao.selectByUsernameAndPassword(username, password);
		return user;
	}

	@Override
	public boolean regist(User user)
	{
		user.setRole(Const.ROLE.ROLE_USER);
		user.setCreateTime(new Date());
		return  iUserDao.registUser(user);
	}	
	
	public boolean validateUserName(String username) {
		if(username == null) return false;
		int resRow = iUserDao.selectByUserName(username);
		if(resRow >0) {
			return false;
		}
		
		return true;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return iUserDao.findAll();
	}
}
