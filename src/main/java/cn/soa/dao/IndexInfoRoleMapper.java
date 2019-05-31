package cn.soa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.soa.entity.IndexInfoRole;
import cn.soa.entity.UserRole;

@Mapper
public interface IndexInfoRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(IndexInfoRole record);

    int insertSelective(IndexInfoRole record);

    IndexInfoRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IndexInfoRole record);

    int updateByPrimaryKey(IndexInfoRole record);
    
    /**
     * 批量删除
     * @param records
     * @return
     */
    int deleteRecords(List<UserRole> records);
}