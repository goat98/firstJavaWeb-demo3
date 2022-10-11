package buba.com.cn.dao.impl;

import buba.com.cn.dao.SoldierDao;
import buba.com.cn.entity.Soldier;
import buba.com.cn.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @program: firstJavaWeb
 * @ClassName SoldierDaoImpl
 * @description:
 * @author: MSY
 * @create: 2022-09-20 16:04
 * @Version 1.0
 **/
public class SoldierDaoImpl implements SoldierDao {

    @Override
    public List<Soldier> findAllSoldiers() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "select * from t_soldier";
        List<Soldier> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Soldier.class));

        return list;
    }

    @Override
    public int deleteSoldierById(Integer id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "delete from t_soldier where soldier_id = ?";
        int i = jdbcTemplate.update(sql, id);
        return i;
    }

    @Override
    public Soldier findSoldierById(Integer id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "select * from t_soldier where soldier_id = ?";
        Soldier soldier = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Soldier.class), id);


        return soldier;
    }

    @Override
    public int updateSoldierById(Soldier soldier) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "update t_soldier set soldier_name = ?, soldier_weapon = ? where soldier_id = ?";
        int i = jdbcTemplate.update(sql, soldier.getSoldierName(), soldier.getSoldierWeapon(), soldier.getSoldierId());
        return i;
    }
}
