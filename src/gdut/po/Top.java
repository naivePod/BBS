package gdut.po;

import java.sql.Timestamp;

/**
 * Top entity. @author MyEclipse Persistence Tools
 */

public class Top implements java.io.Serializable {

	// Fields

	private Integer articleId;
	private User user;
	private Article article;
	private Timestamp ttime;

	// Constructors

	/** default constructor */
	public Top() {
	}

	/** full constructor */
	public Top(Integer articleId, User user, Article article, Timestamp ttime) {
		this.articleId = articleId;
		this.user = user;
		this.article = article;
		this.ttime = ttime;
	}

	// Property accessors

	public Integer getArticleId() {
		return this.articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Timestamp getTtime() {
		return this.ttime;
	}

	public void setTtime(Timestamp ttime) {
		this.ttime = ttime;
	}

}