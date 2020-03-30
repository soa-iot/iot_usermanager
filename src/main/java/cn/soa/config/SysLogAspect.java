package cn.soa.config;

import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.soa.entity.UserLog;
import cn.soa.service.inter.UserLogService;
import cn.soa.util.GlobalUtil;

/**
 * 系统日志：切面处理类
 */
@Aspect
@Component
public class SysLogAspect {
	private static Logger logger = LoggerFactory.getLogger( SysLogAspect.class );
    @Autowired
    private UserLogService logService;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation( cn.soa.config.MyLog)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) throws UnknownHostException, ParseException {
        System.out.println("切面。。。。。");
        //保存日志
        UserLog sysLog = new UserLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            String value = myLog.value();
            sysLog.setOperation(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        sysLog.setMethod(className + "." + methodName);

        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
//        String params = JSON.toJSONString(args);
        sysLog.setParams("params");

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        sysLog.setCreateDate(formatter.format(date));
        String userName = GlobalUtil.getCookie("name").replaceAll("\"", "");
        logger.info("userName---"+userName);
        //获取用户名
        sysLog.setUserID(userName);
        sysLog.setUsername(userName);
        InetAddress ip4 = Inet4Address.getLocalHost();
        //获取用户ip地址
        sysLog.setIp(ip4.getHostAddress());

        //调用service保存SysLog实体类到数据库
      int i=  logService.save(sysLog);
      logger.info("记录数据---"+i);
    }

}