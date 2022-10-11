package buba.com.cn.dao;

import buba.com.cn.entity.Soldier;

import java.util.List;

/**
 * @program: firstJavaWeb
 * @ClassName SoldierDao
 * @description:
 * @author: MSY
 * @create: 2022-09-20 16:03
 * @Version 1.0
 **/
public interface SoldierDao {

    //查询所有士兵
    List<Soldier> findAllSoldiers();

    //根据id删除士兵
    int deleteSoldierById(Integer id);

    //根据id查询士兵
    Soldier findSoldierById(Integer id);

    //根据id更新士兵信息
    int updateSoldierById(Soldier soldier);
}
