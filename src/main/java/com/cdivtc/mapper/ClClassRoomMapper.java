package com.cdivtc.mapper;

import com.cdivtc.model.CClass;
import com.cdivtc.model.CCourse;
import com.cdivtc.model.ClClassRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ClClassRoomMapper {
    public int addRoomMapper(ClClassRoom clClassRoom);
    public ClClassRoom findClClassRoomByname(String clRoom);
    public int deleteRoomMapper(String cId);
    public int updateRoomMapper(@Param("clClassRoom")ClClassRoom clClassRoom);
    public List<ClClassRoom> findPageRoomMapper(Map<String,Object> map);
    public List<ClClassRoom> findAllRoomMapper();
}
