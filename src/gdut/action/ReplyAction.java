package gdut.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

import gdut.po.Reply;
import gdut.service.IReplyService;

public class ReplyAction extends ActionSupport{
	private IReplyService iReplyService;
	private Reply reply;
	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}



	private Integer article_id;
	public static final Logger logger = LoggerFactory.getLogger(ReplyAction.class);
	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}



	
	

	

	

	
	
	public IReplyService getiReplyService() {
		return iReplyService;
	}



	public void setiReplyService(IReplyService iReplyService) {
		this.iReplyService = iReplyService;
	}



	public String postReply() {
		
		boolean isSuccess = iReplyService.post(article_id, reply.getReplyContent());
		if(!isSuccess) {
			return "error";
		}
		return SUCCESS;
	}
}
