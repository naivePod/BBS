package gdut.service;

import gdut.po.Reply;
import gdut.po.User;

public interface IReplyService {
	

	public boolean post(Integer article_id, String replyContent, User user);
}
