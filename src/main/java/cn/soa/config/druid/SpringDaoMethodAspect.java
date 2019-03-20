package cn.soa.config.druid;

import java.util.ArrayList;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;

/**
 * @ClassName: SpringDaoMethodAspect
 * @Description: spring 监控配置类
 * @author zhugang
 * @date 2019年2月12日
 */

@Configuration
public class SpringDaoMethodAspect {
	@Bean
	public DruidStatInterceptor druidStatInterceptor() {
		DruidStatInterceptor dsInterceptor = new DruidStatInterceptor();
		return dsInterceptor;
	}

	@Bean
	@Scope("prototype")
	public JdkRegexpMethodPointcut druidStatPointcut() {
		JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
		// pointcut.setPattern("cn.soa.service.impl.*");
		String[] patterns = new String[] {
//			"cn.soa.service.inter.*"
				"cn.soa.service.*",
				"cn.soa.dao.*"
		};
		pointcut.setPatterns(patterns);
		return pointcut;
	}

	@Bean
	public DefaultPointcutAdvisor druidStatAdvisor(DruidStatInterceptor druidStatInterceptor,
			JdkRegexpMethodPointcut druidStatPointcut) {
		DefaultPointcutAdvisor defaultPointAdvisor = new DefaultPointcutAdvisor();
		defaultPointAdvisor.setPointcut(druidStatPointcut);
		defaultPointAdvisor.setAdvice(druidStatInterceptor);
		return defaultPointAdvisor;
	}
}
