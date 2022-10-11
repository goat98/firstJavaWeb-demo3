package buba.com.cn.service;

import buba.com.cn.entity.Soldier;

import java.util.List;

/**
 * @program: firstJavaWeb
 * @interfaceName SoldierService
 * @description:
 * @author: MSY
 * @create: 2022-09-20 15:58
 * @Version 1.0
 **/
public interface SoldierService {

    //查询所有士兵
    List<Soldier> findAllSoldiers();

    //根据Id删除士兵
    int deleteSoldierById(Integer id);

    //根据id查询士兵
    Soldier findSoldierById(Integer id);

    //根据id更新士兵信息
    int updateSoldierById(Soldier soldier);
}
