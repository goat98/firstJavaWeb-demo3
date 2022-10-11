package buba.com.cn.controller;

import buba.com.cn.entity.Soldier;
import buba.com.cn.service.SoldierService;
import buba.com.cn.service.impl.SoldierServiceImpl;
import buba.com.cn.utils.ViewBaseServlet;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.http.HttpClient;
import java.util.List;
import java.util.Map;

/**
 * @program: firstJavaWeb
 * @ClassName SoldierServlet
 * @description:
 * @author: MSY
 * @create: 2022-09-20 16:13
 * @Version 1.0
 **/
public class SoldierServlet extends ViewBaseServlet {

    private SoldierService soldierService = new SoldierServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //在获取请求参数之前调用
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String getReq = req.getMethod();
        if ("findAllSoldiers".equals(req.getParameter("method").toString())){
            this.findAllSoldiers(req, resp);
        }

        if ("findSoldierById".equals(req.getParameter("method").toString())){
            this.findSoldierById(req, resp);
        }

        if ("updateSoldierById".equals(req.getParameter("method").toString())){
            try {
                this.updateSoldierById(req, resp);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        if ("deleteSoldierById".equals(req.getParameter("method").toString())){
            this.deleteSoldierById(req, resp);
        }

    }

    private void findSoldierById(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

        String id = req.getParameter("id");
        Soldier soldier = soldierService.findSoldierById(Integer.parseInt(id));

        req.setAttribute("soldier", soldier);
        processTemplate("edit", req, resp);
    }

    public void findAllSoldiers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Soldier> allSoldiers = soldierService.findAllSoldiers();
        req.setAttribute("soldierList", allSoldiers);
        processTemplate("list", req, resp);
    }

    public void updateSoldierById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Map<String, String[]> map = req.getParameterMap();

        Soldier soldier = new Soldier();
        BeanUtils.populate(soldier, map);

        int i = soldierService.updateSoldierById(soldier);

        if (i > 0){
            this.findAllSoldiers(req, resp);
        }

    }

    public void deleteSoldierById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        int i = soldierService.deleteSoldierById(Integer.parseInt(id));
        if (i > 0){
            this.findAllSoldiers(req, resp);
        }
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
