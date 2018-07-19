package gdut.util;

import gdut.action.ReplyAction;
import gdut.po.Reply;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ReplyIntercept extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		ReplyAction ReplyAction = (ReplyAction)ai.getAction();
		
		Reply reply = ReplyAction.getReply();
		System.out.print(reply);
		if(reply == null) {
			return "out";
		}
		
		String content = reply.getReplyContent();
		
		content = content.replaceAll("sb", "**");
		reply.setReplyContent(content);
		return ai.invoke();
	}
	
}
