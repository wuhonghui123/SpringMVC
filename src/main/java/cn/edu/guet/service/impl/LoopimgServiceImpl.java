package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Loopimg;
import cn.edu.guet.dao.LoopimgDao;
import cn.edu.guet.dao.impl.LoopimgDaoImpl;
import cn.edu.guet.service.LoopimgService;

import java.util.List;

public class LoopimgServiceImpl implements LoopimgService {
    @Override
    public List<Loopimg> getloopimgList() {
        LoopimgDao loopimgDao = new LoopimgDaoImpl();
        return loopimgDao.getloopimgList();
    }
}
