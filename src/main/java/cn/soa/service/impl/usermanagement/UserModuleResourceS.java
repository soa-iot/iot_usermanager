package cn.soa.service.impl.usermanagement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.soa.dao.usermanagement.UserModuleResourceMapper;
import cn.soa.entity.IotUserModuleResource;
import cn.soa.service.inter.usermanagement.UserModuleResourceSI;
import lombok.extern.slf4j.Slf4j;
/**
 * 菜单管理业务层
 * @author Jiang, Hang
 * @date 2020-03-31
 *
 */
@Service
@Slf4j
public class UserModuleResourceS implements UserModuleResourceSI {
	
	@Autowired
	private UserModuleResourceMapper umrMapper;
	
	/**
	 * 查询所有的权限资源信息
	 * 
	 * @return List<IotUserModuleResource> - 权限资源信息列表
	 */
	
	@Override
	public List<IotUserModuleResource> getAllResources() {
		log.info("-----开始查询所有的权限资源信息-----");
		try {
			
			List<IotUserModuleResource> list = umrMapper.findAllResources();
			
			log.info("-----查询所有的权限资源信息成功-----");
			return list;
			
		}catch (Exception e) {
			log.info("-----查询所有的权限资源信息发生错误-----");
			log.info("--{}", e);
			return null;
		}
	}
	
	/**
	 * 添加菜单资源信息
	 * @param resource - 菜单资源信息对象
	 * 
	 */
	@Override
	public Boolean addModuleResource(IotUserModuleResource resource) {
		log.info("-----开始添加菜单资源信息-----");
		try {
			resource.setCreateTime(new Date());
			resource.setLastModifyTime(new Date());
			umrMapper.insertModuleResource(resource);
			
			log.info("-----添加菜单资源信息成功-----");
			return true;
			
		}catch (Exception e) {
			log.info("-----添加菜单资源信息发生错误-----");
			log.info("--{}", e);
			return false;
		}
	}
	
	/**
	 * 更新菜单资源信息
	 * @param resource - 菜单资源信息对象
	 * 
	 */
	@Override
	public Boolean setModuleResource(IotUserModuleResource resource) {
		log.info("-----开始更新菜单资源信息-----");
		try {
			resource.setLastModifyTime(new Date());
			umrMapper.updateModuleResource(resource);
			
			log.info("-----更新菜单资源信息成功-----");
			return true;
			
		}catch (Exception e) {
			log.info("-----更新菜单资源信息发生错误-----");
			log.info("--{}", e);
			return false;
		}
	}



}
