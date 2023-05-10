package comunity.carcomunity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyLoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String userName = authentication.getName(); //인증된 사용자의 user_id를 가져옴
        session.setAttribute("userName", userName + "님 반가워요."); //세션에 user_id를 저장
        //super.onAuthenticationSuccess(request, response, authentication);
        response.sendRedirect("/index");
    }
}
