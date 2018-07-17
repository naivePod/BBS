package gdut.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */

public class Article implements java.io.Serializable {

	// Fields

	private Integer articleId;
	private User user;
	private String titleContent;
	private String articleContent;
	private Timestamp titleTime;
	private Set tops = new HashSet(0);
	private Set replies = new HashSet(0);

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** minimal constructor */
	public Article(User user, String titleContent, String articleContent,
			Timestamp titleTime) {
		this.user = user;
		this.titleContent = titleContent;
		this.articleContent = articleContent;
		this.titleTime = titleTime;
	}

	/** full constructor */
	public Article(User user, String titleContent, String articleContent,
			Timestamp titleTime, Set tops, Set replies) {
		this.user = user;
		this.titleContent = titleContent;
		this.articleContent = articleContent;
		this.titleTime = titleTime;
		this.tops = tops;
		this.replies = replies;
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

	public String getTitleContent() {
		return this.titleContent;
	}

	public void setTitleContent(String titleContent) {
		this.titleContent = titleContent;
	}

	public String getArticleContent() {
		return this.articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public Timestamp getTitleTime() {
		return this.titleTime;
	}

	public void setTitleTime(Timestamp titleTime) {
		this.titleTime = titleTime;
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

}