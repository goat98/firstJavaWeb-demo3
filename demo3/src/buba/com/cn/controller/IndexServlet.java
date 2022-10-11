package buba.com.cn.controller;

import buba.com.cn.utils.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: firstJavaWeb
 * @ClassName IndexServlet
 * @description:
 * @author: MSY
 * @create: 2022-09-20 16:34
 * @Version 1.0
 **/
public class IndexServlet extends ViewBaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processTemplate("index", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
