package cn.soa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

import cn.soa.entity.headResult.ResultJson;


/**
 * @ClassName: GlobalExceptionHandler
 * @Description: 增强控制器 - 异常处理……
 * @author zhugang
 * @date 2018年7月25日
 */
@SuppressWarnings("deprecation")
@ControllerAdvice
@ResponseBody
public class GlobalController  extends AbstractJsonpResponseBodyAdvice {
	private final static Logger logger = LoggerFactory.getLogger(GlobalController.class);
	
	public GlobalController() {
        super("callback", "jsonp");
    }
	
	 /**   
	 * @Title: initBinder   
	 * @Description: 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器   
	 * @param: @param binder      
	 * @return: void        
	 */  
	@InitBinder
	public void initBinder(WebDataBinder binder) {}
	
	/**   
	 * @Title: addAttributes   
	 * @Description: 把值绑定到Model中，使全局@RequestMapping可以获取到该值  
	 * @param: @param model      
	 * @return: void        
	 */  
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("author", "Magical Sam");
	}
	 
	/**   
	 * @Title: handlerException   
	 * @Description: 全局Exception异常处理  
	 * @param: @param e
	 * @param: @return      
	 * @return: ResultJson<Object>        
	 */  
	@ExceptionHandler
	ResultJson<Object> handlerException(Exception e){
		e.printStackTrace();
		logger.debug(e.getMessage());
		return new ResultJson<Object>(1, e.getMessage(), null);
	}
	
	/**   
	 * @Title: handleMethodArgumentNotValidException   
	 * @Description: 处理所有接口数据验证异常  
	 * @param: @param e
	 * @param: @return      
	 * @return: ResultJson<Object>        
	 */  
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	ResultJson<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		e.printStackTrace();
		logger.error(e.getMessage(), e);
		return new ResultJson<Object>(e);
	}
}
