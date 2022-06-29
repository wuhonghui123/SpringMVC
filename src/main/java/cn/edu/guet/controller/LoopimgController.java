package cn.edu.guet.controller;

import cn.edu.guet.bean.Loopimg;
import cn.edu.guet.bean.News;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.LoopimgService;
import cn.edu.guet.service.NewsService;
import cn.edu.guet.service.impl.LoopimgServiceImpl;
import cn.edu.guet.service.impl.NewsServiceImpl;

import java.util.List;

public class LoopimgController {
    @RequestMapping("/getloopimgList")//读取数据库中的新闻信息转发到网页
    public List<Loopimg> getloopimgList() {

        System.out.println("获取所有图片");
        LoopimgService loopimgService = new LoopimgServiceImpl();
        return loopimgService.getloopimgList();
    }
}
