package gdut.service;

import gdut.po.Reply;

public interface IReplyService {
	

	public boolean post(Integer article_id, String replyContent);
}
