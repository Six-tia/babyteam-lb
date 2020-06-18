package com.tiaedu.babyteam.controller;

import com.tiaedu.babyteam.entity.Goods;
import com.tiaedu.babyteam.service.GoodsService;
import freemarker.template.Configuration;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;

import org.slf4j.*;

@Controller
public class GoodsController {
    Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Resource
    private GoodsService goodsService;
    //Freemaker的核心配置类，用于动态生成模板对象
    //在SpringBoot IOC容器初始化的时候，自动Configuration就被实例化
    @Resource
    private Configuration freemarkerConfig;

    @Value("${server.port}")
    private String port;

    @GetMapping("/goods") //http://localhost/goods?gid=xxx
    public ModelAndView showGoods(Long gid){
        logger.info("gid:" + gid);
        logger.info("port:" + port);
        ModelAndView mav = new ModelAndView("/goods");
        Goods goods = goodsService.getGoods(gid);
        mav.addObject("goods", goods);
        mav.addObject("covers", goodsService.findCovers(gid));
        mav.addObject("details", goodsService.findDetails(gid));
        mav.addObject("params", goodsService.findParams(gid));
        return mav;
    }

    @GetMapping("/goods2") //http://localhost/goods?gid=xxx
    public ModelAndView showGoods1(Long gid){
        logger.info("gid:" + gid);
        ModelAndView mav = new ModelAndView("goodso");
        Goods goods = goodsService.getGoods(gid);
        mav.addObject("goods", goods);
        mav.addObject("covers", goodsService.findCovers(gid));
        mav.addObject("details", goodsService.findDetails(gid));
        mav.addObject("params", goodsService.findParams(gid));
        return mav;
    }

    /**
     * 将当前用户存到Session中
     * @param u
     * @param request
     * @return
     */
    @GetMapping("/login")
    @ResponseBody
    public String login(String u, WebRequest request){
        request.setAttribute("user", u, WebRequest.SCOPE_SESSION);
        return "port" + port;
    }

    /**
     * 模拟登陆后是否可以正常进入
     * 若不采取处理，由于负载均衡，非登录的服务器处理时，没有用户的Session信息
     * 无法正常登录，需要重新登录
     * @param request
     * @return
     */
    @GetMapping("/check")
    @ResponseBody
    public String checkUser(WebRequest request){
        String user = (String) request.getAttribute("user", WebRequest.SCOPE_SESSION);
        if(user != null){
            return "port:" + port + ",user:" + user;
        }else{
            return "port:" + port + ",redirect to login!";
        }
    }
}
