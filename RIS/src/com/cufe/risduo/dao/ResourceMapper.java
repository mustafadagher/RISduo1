package com.cufe.risduo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cufe.risduo.model.Resource;

public class ResourceMapper implements RowMapper<Resource>{

	
	public Resource mapRow(ResultSet rs, int rowNum) throws SQLException {

		Resource resource = new Resource();
		resource.setId(rs.getInt("roomId"));
	    resource.setName(rs.getString("roomName"));
		return resource;
	}

}