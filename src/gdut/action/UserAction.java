package gdut.action;

import java.util.Map;

import gdut.dao.IUserDao;
import gdut.po.User;
import gdut.service.IUserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private String username;
	private String password;
	private IUserService iUserService;
	public IUserService getiUserService() {
		return iUserService;
	}



	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}



	private String errorInfo;
	




	public String getErrorInfo() {
		return errorInfo;
	}



	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}





	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		if(iUserService.login(username, password)) {
			return SUCCESS;
		}
		errorInfo = "’À∫≈ªÚ√‹¬Î¥ÌŒÛ";
		
		return "error";
	}


}
