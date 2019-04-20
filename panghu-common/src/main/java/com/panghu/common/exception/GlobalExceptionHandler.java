package com.panghu.common.exception;

import com.panghu.common.cache.CommonLanguageCacheService;
import com.panghu.common.enums.ResultEnum;
import com.panghu.common.response.BaseResponse;
import com.panghu.common.utils.ResultUtil;
import com.panghu.common.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获全局异常
     *
     * @param e 异常
     * @return 通用响应
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse goalException(Exception e) {
        //获取当前请求的Request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取Request的语言
        String language = this.getLanguage(request);
        //语言默认为中文
        if (language == null) {
            language = "zh-cn";
        }
        //通过ApplicationContext对象根据clazz对象获取错误信息
        Map errorMsgMap = SpringContextUtil.getBean(CommonLanguageCacheService.class).getErrorInfoByLanguage(language);
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            log.info("【全局异常捕获】-error-[ businessException 业务异常信息]:[{}]", e.getMessage());
            return ResultUtil.error(businessException.getCode(), errorMsgMap.get(String.valueOf(businessException.getCode())).toString());
        } else if (e instanceof MethodArgumentNotValidException) {
            //方法参数无效异常
            BindingResult result = ((MethodArgumentNotValidException) e).getBindingResult();
            StringBuffer message = new StringBuffer();
            if (result.hasErrors()) {
                message = printBindException(result);
            }
            log.info("【全局异常捕获】-error-[ MethodArgumentNotValidException 业务异常信息]:[{}]", errorMsgMap.get(message.toString()));
            return ResultUtil.error(message.toString(), errorMsgMap.get(message.toString()).toString());
        } else if (e instanceof MissingServletRequestParameterException) {
            log.error("【全局异常捕获】-error-[ MissingServletRequestParameterException 系统异常信息]:[{}]", e);
            //输入参数为空
            return ResultUtil.error(ResultEnum.PARAMETER_IS_NOT_PRESENT.getCode(), errorMsgMap.get(String.valueOf(ResultEnum.PARAMETER_IS_NOT_PRESENT.getCode())).toString());
        } else if (e instanceof Exception) {
            log.error("【全局异常捕获】-error-[ Exception 系统异常信息]:[{}]", e);
            if (StringUtils.isNotBlank(e.getMessage()) && e.getMessage().equals("Bad credentials")) {
                //用户未经过授权
                return ResultUtil.error(ResultEnum.USER_OR_PASSWORD_INCORRECT.getCode(), errorMsgMap.get(String.valueOf(ResultEnum.USER_OR_PASSWORD_INCORRECT.getCode())).toString());
            } else if (StringUtils.isNotBlank(e.getMessage()) && e.getMessage().equals("User is disabled")) {
                //用户被禁用
                return ResultUtil.error(ResultEnum.USER_NOT_ENABLE.getCode(), errorMsgMap.get(String.valueOf(ResultEnum.USER_NOT_ENABLE.getCode())).toString());
            }
            return ResultUtil.error(ResultEnum.ERROR.getCode(), errorMsgMap.get(String.valueOf(ResultEnum.ERROR.getCode())).toString());
        } else {
            //服务器异常
            log.error("【全局异常捕获】-error-[系统运行异常信息]:[{}]", e);
            return ResultUtil.error(ResultEnum.REQUEST_REMOTE_ERROR.getCode(), errorMsgMap.get(String.valueOf(ResultEnum.REQUEST_REMOTE_ERROR.getCode())).toString());
        }
    }

    /**
     * 获取当前请求语言
     *
     * @param request 请求
     * @return 语言
     */
    private String getLanguage(HttpServletRequest request) {
        String language = null;
        try {
            if (Objects.nonNull(request) && Objects.nonNull(request.getHeader("Content-Language"))) {
                language = request.getHeader("Content-Language");
            }
            if (Objects.nonNull(language)) {
                return language.split(",")[0];
            }
        } catch (Exception e) {
            return Locale.getDefault().getLanguage();
        }
        return language;
    }

    private StringBuffer printBindException(BindingResult result) {
        StringBuffer message = new StringBuffer();
        List<ObjectError> allErrors = result.getAllErrors();
        message.append(allErrors.get(0).getDefaultMessage());//获取第一个error
        return message;
    }
}
