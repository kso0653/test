package mybatis.boarduk.common;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {
    // 실제 프로젝트에서는 Exception.class 를 사용해 한번에 모든 예외 처리를 하지 않고, 예외 별로 예외처리를 구현해야함
    // 여러 예외처리 메소드를 추가할 때는 Exception.class 를 가장 마지막에 입력
    // 위에 입력된 예외처리 메소드부터 실행되기 떄문
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception exception) {
        ModelAndView mv = new ModelAndView("/error/error_default");
        mv.addObject("exception", exception);

        log.error("exception", exception);

        return mv;
    }
}