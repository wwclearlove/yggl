package com.cdivtc.service;

import com.cdivtc.model.CClass;
import com.cdivtc.model.CCourse;
import com.cdivtc.model.ClClassRoom;
import com.cdivtc.model.PageBean;

import java.util.List;

public interface ClClassRoomService {
    public int addClassRoom(ClClassRoom clClassRoom);
    public ClClassRoom findByname(String cName);
    public int deleteClassRoom(String cId);
    public int updateClassRoom(ClClassRoom clClassRoom);
    public PageBean<ClClassRoom> findPageClassRoom(Integer page, Integer row);
    public List<ClClassRoom> findAllClassRoom();
}
