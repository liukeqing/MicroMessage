package com.imooc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imooc.bean.Message;
import com.imooc.dao.MessageDao;
import com.imooc.entity.Page;

public class QueryService {
	/**
	 * 查询列表数据
	 */
	public List<Message> queryMessageListByPage(String command,String description,Page page){
		Message message = new Message();
		message.setCommand(command);
		message.setDescription(description);
		MessageDao messageDao = new MessageDao();
		int totalNumber = messageDao.count(message);
		page.setTotalNumber(totalNumber);
		Map<String, Object> parameter = new HashMap<String,Object>();
		parameter.put("page", page);
		parameter.put("message", message);
		return messageDao.queryMessageList(parameter);
	}
}
