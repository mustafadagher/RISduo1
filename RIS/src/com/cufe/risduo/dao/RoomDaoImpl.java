package com.cufe.risduo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cufe.risduo.model.Resource;
import com.cufe.risduo.model.Room;

@Component
public class RoomDaoImpl implements RoomDao{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	
	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdpcTemplate() {
		return jdbcTemplate;
	}

	public void setJdpcTemplate(JdbcTemplate jdpcTemplate) {
		this.jdbcTemplate = jdpcTemplate;
	}
	


	public int create(String roomName) {
		String sql = "INSERT INTO room (roomName) VALUES (?)";
		 
		int numRows =  jdbcTemplate.update(sql, new Object[] {roomName});
		 return numRows;
	}


	public Room getRoom(String roomName) {
		String SQL = "select * from room where roomName = ?";
		Room room= (Room)jdbcTemplate.queryForObject(SQL, 
                new Object[]{roomName}, new RoomMapper());
		return room;
	}

	
	public List<Room> listRooms() {
		String sql = "SELECT * FROM room";
		List<Room> rooms = jdbcTemplate.query(sql, new RoomMapper()); 
		return rooms;
	}
	
	public List<Resource> listResources() {
		String sql = "SELECT * FROM room";
		List<Resource> resources = jdbcTemplate.query(sql, new ResourceMapper()); 
		return resources;
	}
	
	public void update(String roomName) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void delete() {
		
		
	}
	
}
