package gdut.service.impl;

import gdut.dao.IUserDao;
import gdut.po.User;
import gdut.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao iUserDao;

	public IUserDao getiUserDao() {
		return iUserDao;
	}

	public void setiUserDao(IUserDao iUserDao) {
		this.iUserDao = iUserDao;
	}

	@Override
	public boolean login(String username, String password) {
		User user = iUserDao.selectByUsernameAndPassword(username, password);
		if(user == null) return false;
		return true;
	}



	
}
