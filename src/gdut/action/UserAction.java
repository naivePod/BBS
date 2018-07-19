package gdut.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import gdut.dao.IUserDao;
import gdut.po.User;
import gdut.service.IUserService;
import gdut.util.Const;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private String username;
	private String password;
	private IUserService iUserService;
	private User user;
	private String info;//username的检验信息
	private Integer role;
	
	
	
	public Integer getRole() {
		return role;
	}



	public void setRole(Integer role) {
		this.role = role;
	}



	public String getInfo() {
		return info;
	}



	public void setInfo(String info) {
		this.info = info;
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

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
	
	List<User> users;
	List userarticle_count;

	public List getUserarticle_count() {
		return userarticle_count;
	}



	public void setUserarticle_count(List userarticle_count) {
		this.userarticle_count = userarticle_count;
	}



	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}



	public String login() {
		ActionContext context = ActionContext.getContext();
		User currentUser = (User)context.getSession().get(Const.CURRENT_USER);
		if(currentUser != null) {
			return SUCCESS;
		}
		User loginUser = iUserService.login(user.getUserName(), user.getPsw());
		
		if(loginUser != null) {
			loginUser.setPsw(null);
			if(role.equals(Const.ROLE.ROLE_ADMIN)) {
				//管理员登录
				if(!loginUser.getRole().equals(Const.ROLE.ROLE_ADMIN)) {
					errorInfo = "非管理员无法登录";
					return "error";
				} {
					context.getSession().put(Const.CURRENT_USER, loginUser);
					return SUCCESS;
				}
			}
			
			loginUser.setRole(Const.ROLE.ROLE_USER);
			context.getSession().put(Const.CURRENT_USER, loginUser);
			return SUCCESS;
		}

		errorInfo = "账号或密码错误";

		return "error";
	}
	
	/*
	 * 注册模块
	 * */
	public String regist(){
		System.out.println(user.toString());
		if(iUserService.regist(user))
			return "success";
		else {
			errorInfo="注册错误";
			return "error";
		}
	}
	
	public String validateUserName() {
		boolean isSuccess = iUserService.validateUserName(username);
		if(!isSuccess) {
			info = "用户名已注册";
		} else {
			info = "该用户名可以使用";
		}
		return SUCCESS;
	}
	
	public String logout() {
		ActionContext context = ActionContext.getContext();
		context.getSession().remove(Const.CURRENT_USER);
		return SUCCESS;
	}
	
	public String queryUsers() {
		users=iUserService.findAll();
		userarticle_count = new ArrayList();
		for(int i=0;i<users.size();i++){
			userarticle_count.add(users.get(i).getArticles().size());
		}
		return SUCCESS;
		
	}

}
