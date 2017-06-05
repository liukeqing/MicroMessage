package com.imooc.dao;

import java.util.List;
import java.util.Map;

import com.imooc.bean.Message;

public interface IMessage {
	public int count(Message message);
	public List<Message> queryMessageList(Map<String, Object> parameter);
	public List<Message> queryMessageListByPage(Map<String, Object> parameter);
}
