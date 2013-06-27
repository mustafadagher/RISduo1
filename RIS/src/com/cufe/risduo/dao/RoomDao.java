package com.cufe.risduo.dao;

import java.util.List;
import javax.sql.DataSource;

import com.cufe.risduo.model.Resource;
import com.cufe.risduo.model.Room;

public interface RoomDao {
   /** 
    * This is the method to be used to initialize
    * database resources ie. connection.
    */
   public void setDataSource(DataSource ds);
   /** 
    * This is the method to be used to create
    * a record in the patient table.
    */
   public int create(String roomName);
   /** 
    * This is the method to be used to list down
    * a record from the patient table corresponding
    * to a passed patient id.
    */
   public Room getRoom(String roomName);
   /** 
    * This is the method to be used to list down
    * all the records from the patient table.
    */
   public List<Room> listRooms();
   /** 
    * This is the method to be used to delete
    * a record from the patient table corresponding
    * to a passed patient id.
    */
   public List<Resource> listResources();
   public void delete();
   /** 
    * This is the method to be used to update
    * a record into the patient table.
    */
   
   void update(String roomName);
}

