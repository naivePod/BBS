package gdut.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

import gdut.po.Reply;
import gdut.service.IReplyService;

public class ReplyAction extends ActionSupport{
	private IReplyService iReplyService;
	private String replyContent;
	private Integer article_id;
	public static final Logger logger = LoggerFactory.getLogger(ReplyAction.class);
	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}



	private List<Reply> replies;
	

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	
	
	public IReplyService getiReplyService() {
		return iReplyService;
	}



	public void setiReplyService(IReplyService iReplyService) {
		this.iReplyService = iReplyService;
	}



	public String postReply() {
		Reply reply = new Reply();
		System.out.println("reply:"+article_id + replyContent);
		boolean isSuccess = iReplyService.post(article_id, replyContent);
		if(!isSuccess) {
			return "error";
		}
		return SUCCESS;
	}
}
