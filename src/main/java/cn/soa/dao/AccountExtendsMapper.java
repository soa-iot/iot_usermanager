package cn.soa.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.soa.entity.AccountExtends;

@Mapper
public interface AccountExtendsMapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(AccountExtends record);

    int insertSelective(AccountExtends record);

    AccountExtends selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(AccountExtends record);

    int updateByPrimaryKey(AccountExtends record);
}