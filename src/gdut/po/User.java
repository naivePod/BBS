package gdut.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String psw;
	private String email;
	private String birth;
	private Integer role;
	private Date createTime;
	private Date lastUpdateTime;
	private Set tops = new HashSet(0);
	private Set replies = new HashSet(0);
	private Set articles = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userName, String psw) {
		this.userName = userName;
		this.psw = psw;
	}

	/** full constructor */
	public User(String userName, String psw, String email, String birth,
			Integer role, Date createTime, Date lastUpdateTime, Set tops,
			Set replies, Set articles) {
		this.userName = userName;
		this.psw = psw;
		this.email = email;
		this.birth = birth;
		this.role = role;
		this.createTime = createTime;
		this.lastUpdateTime = lastUpdateTime;
		this.tops = tops;
		this.replies = replies;
		this.articles = articles;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPsw() {
		return this.psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return this.birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Set getTops() {
		return this.tops;
	}

	public void setTops(Set tops) {
		this.tops = tops;
	}

	public Set getReplies() {
		return this.replies;
	}

	public void setReplies(Set replies) {
		this.replies = replies;
	}

	public Set getArticles() {
		return this.articles;
	}

	public void setArticles(Set articles) {
		this.articles = articles;
	}

}