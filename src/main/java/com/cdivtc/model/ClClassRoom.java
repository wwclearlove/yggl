package com.cdivtc.model;

import java.io.Serializable;

public class ClClassRoom implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cl_class_room.cl_id
     *
     * @mbggenerated Mon Oct 21 11:11:06 CST 2019
     */
    private String clId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cl_class_room.cl_room
     *
     * @mbggenerated Mon Oct 21 11:11:06 CST 2019
     */
    private String clRoom;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cl_class_room.cl_id
     *
     * @return the value of cl_class_room.cl_id
     *
     * @mbggenerated Mon Oct 21 11:11:06 CST 2019
     */
    public String getClId() {
        return clId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cl_class_room.cl_id
     *
     * @param clId the value for cl_class_room.cl_id
     *
     * @mbggenerated Mon Oct 21 11:11:06 CST 2019
     */
    public void setClId(String clId) {
        this.clId = clId == null ? null : clId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cl_class_room.cl_room
     *
     * @return the value of cl_class_room.cl_room
     *
     * @mbggenerated Mon Oct 21 11:11:06 CST 2019
     */
    public String getClRoom() {
        return clRoom;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cl_class_room.cl_room
     *
     * @param clRoom the value for cl_class_room.cl_room
     *
     * @mbggenerated Mon Oct 21 11:11:06 CST 2019
     */
    public void setClRoom(String clRoom) {
        this.clRoom = clRoom == null ? null : clRoom.trim();
    }
}