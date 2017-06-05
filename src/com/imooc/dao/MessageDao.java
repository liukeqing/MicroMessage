package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;

public class MessageDao {
	
	
	public List<Message> queryMessageList(Map<String, Object> parameter){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Message> messageList = new ArrayList<>();
		try {
			sqlSession = dbAccess.getSqlSession();
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.queryMessageList(parameter);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return messageList;
	}
	public List<Message> queryMessageListByPage(Map<String, Object> parameter){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Message> messageList = new ArrayList<>();
		try {
			sqlSession = dbAccess.getSqlSession();
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.queryMessageListByPage(parameter);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("deleteOne", id);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}
	public void deleteBatch(List<Integer> idList){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("deleteBatch", idList);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}
	public int count(Message message){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			result = imessage.count(message);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return result;
		
	}
	
	/**
	 * 查询列表数据
	 */
//	public List<Message> queryMessageList(String command,String description){
//		List<Message> messageList = new ArrayList<>();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micromessage", "root", "root");
//			StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from message WHERE 1=1 ");
//			List<String> paramList = new ArrayList<>();
//			if(command != null && !command.trim().equals("")){
//				sql.append(" and command = ? ");
//				paramList.add(command);
//			}
//			if(description != null && !"".equals(description.trim())){
//				sql.append(" and DESCRIPTION like '%' ? '%' ");
//				paramList.add(description);
//			}
//			PreparedStatement ps = conn.prepareStatement(sql.toString());
//			for(int i=0;i<paramList.size();i++){
//				ps.setString(i+1, paramList.get(i));
//			}
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()){
//				Message message = new Message();
//				messageList.add(message);//这样不会忘
//				message.setId(rs.getInt("ID"));
//				message.setCommand(rs.getString("COMMAND"));
//				message.setContent(rs.getString("CONTENT"));
//				message.setDescription(rs.getString("DESCRIPTION"));
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		return messageList;
//	}
}
