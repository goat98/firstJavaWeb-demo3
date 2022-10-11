package buba.com.cn.service.impl;

import buba.com.cn.dao.SoldierDao;

import buba.com.cn.dao.impl.SoldierDaoImpl;
import buba.com.cn.entity.Soldier;
import buba.com.cn.service.SoldierService;

import java.util.List;

/**
 * @program: firstJavaWeb
 * @ClassName SoldierServiceImpl
 * @description:
 * @author: MSY
 * @create: 2022-09-20 16:00
 * @Version 1.0
 **/
public class SoldierServiceImpl implements SoldierService {

    private SoldierDao soldierDao = new SoldierDaoImpl();
    @Override
    public List<Soldier> findAllSoldiers() {

        return soldierDao.findAllSoldiers();
    }

    @Override
    public int deleteSoldierById(Integer id) {
        return soldierDao.deleteSoldierById(id);
    }

    @Override
    public Soldier findSoldierById(Integer id) {
        return soldierDao.findSoldierById(id);
    }

    @Override
    public int updateSoldierById(Soldier soldier) {
        return soldierDao.updateSoldierById(soldier);
    }
}
