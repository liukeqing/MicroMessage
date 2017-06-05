package com.imooc.service;

import java.util.ArrayList;
import java.util.List;

import com.imooc.dao.MessageDao;

public class MaintainService {
	public void deleteOne(String id){
		MessageDao messageDao = new MessageDao();
		if(id != null && !id.trim().equals("")){
			messageDao.deleteOne(Integer.parseInt(id));			
		}
	}
	public void deleteBatch(String[] ids){
		MessageDao messageDao = new MessageDao();
		List<Integer> idList = new ArrayList<>();
		if(ids != null && ids.length>0){
			for(int i=0;i<ids.length;i++){
				idList.add(Integer.parseInt(ids[i]));
			}
			messageDao.deleteBatch(idList);
		}
	}
}
