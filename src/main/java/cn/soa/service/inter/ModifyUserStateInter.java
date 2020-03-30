package cn.soa.service.inter;

import org.springframework.stereotype.Service;

import cn.soa.entity.UserOrganization;

@Service
public interface ModifyUserStateInter {

	boolean sendUserToMQ( UserOrganization userd);

	void modifyUserStateById(UserOrganization user);

}
