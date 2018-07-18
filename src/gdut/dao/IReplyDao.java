package gdut.dao;

import gdut.po.Reply;



public interface IReplyDao {
	public void insert(Reply reply);
	public void update(Reply reply);
	public void delete(Reply reply);
	public Reply findById(Integer id);
}
