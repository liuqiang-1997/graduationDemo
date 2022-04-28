package com.liuqiang.commons.utils;

import javax.servlet.http.HttpServletResponse;

/**
 * @author LiuQiang
 * @date 11:24 下午
 */
public class WebUtils {

    public static String render(HttpServletResponse response,String str){

        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
