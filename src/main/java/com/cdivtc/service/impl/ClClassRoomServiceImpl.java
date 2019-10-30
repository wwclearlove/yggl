package com.cdivtc.service.impl;

import com.cdivtc.mapper.ClClassRoomMapper;
import com.cdivtc.model.CClass;
import com.cdivtc.model.ClClassRoom;
import com.cdivtc.model.PageBean;
import com.cdivtc.service.ClClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClClassRoomServiceImpl implements ClClassRoomService {
    @Autowired
    ClClassRoomMapper clClassRoomMapper;
    @Override
    public int addClassRoom(ClClassRoom clClassRoom) {
        return clClassRoomMapper.addRoomMapper(clClassRoom);
    }

    @Override
    public ClClassRoom findByname(String cName) {
        return clClassRoomMapper.findClClassRoomByname(cName);
    }

    @Override
    public int deleteClassRoom(String cId) {
        return clClassRoomMapper.deleteRoomMapper(cId);
    }

    @Override
    public int updateClassRoom(ClClassRoom clClassRoom) {
        return clClassRoomMapper.updateRoomMapper(clClassRoom);
    }

    @Override
    public PageBean<ClClassRoom> findPageClassRoom(Integer page, Integer row) {
        if(page<=0){
            page=1;
            row=5;
        }

        PageBean<ClClassRoom> pb=new PageBean<ClClassRoom>();
        pb.setRows(row);
        //调用查询总记录数
        int totalCout=clClassRoomMapper.findAllRoomMapper().size();
        if(totalCout==0){
            return null;
        }else {
            pb.setTotalCount(totalCout);
            //计算总页码
            int totalPage=(totalCout%row )==0?totalCout/row:(totalCout/row)+1;
            pb.setTotalPage(totalPage);
            if(page>totalPage){
                page=totalPage;
            }
            pb.setCurrentPage(page);
            //调用dao查询list集合
            //计算开始的记录索引
            System.out.println(page+"页");
            int start=(page-1)*row;
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("start",start);
            map.put("row",row);
            List<ClClassRoom> list= clClassRoomMapper.findPageRoomMapper(map);
            pb.setList(list);
        }
        return pb;
    }

    @Override
    public List<ClClassRoom> findAllClassRoom() {
        return clClassRoomMapper.findAllRoomMapper();
    }
}
