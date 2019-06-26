package cn.soa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.soa.entity.IndexTempInfo;

@Mapper
public interface IndexTempInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(IndexTempInfo record);

    int insertSelective(IndexTempInfo record);

    IndexTempInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IndexTempInfo record);

    int updateByPrimaryKeyWithBLOBs(IndexTempInfo record);

    int updateByPrimaryKey(IndexTempInfo record);

	/**
	 * @return 
	 * 
	 */
	List<IndexTempInfo> findAll();
}