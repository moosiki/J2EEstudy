package com.qsx.crm.module.dashboard.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsx.crm.core.BaseRepository;

/**
 * 首页处理 Dao 类
 * @author Mryang
 *
 */
@Repository
public class DashboardRepository {
	
	@Autowired
	BaseRepository<Object> baseRepository;
	
	/**
	 * 查询折线图和柱状图数据
	 * @return
	 */
	public List<Object[]> getLineDates() {
		String hql = "select sum(o.totalAmount) amount,sum(o.totalQuantity) quantity,month(o.createTime) month from "
				+ "qsx_sales_order o group by month(o.createTime)";
		List<Object[]> list = baseRepository.queryBySql(hql);
		return list;
	}
	
	/**
	 * 查询饼状图数据
	 * @return
	 */
	public List<Object[]> getPieDatas() {
			String hql = "select count(c.id) customerNum,c.region_id from qsx_customer c left join qsx_region r on c.region_id "
					+ "= r.id group by r.id";
			List<Object[]> list = baseRepository.queryBySql(hql);
			return list;
	}
	
	/**
	 * 查询地图数据
	 * @return
	 */
	public List<Object[]> getChinaMapData() {
			String hql = "select count(c.id) customerNum,p.key from qsx_customer c left join qsx_province p "
					+ " on p.code = c.province_code group by c.province_code";
			List<Object[]> list = baseRepository.queryBySql(hql);
			return list;
	}
	
	/**
	 * 查询当月销售数据
	 * @return
	 */
	public List<Object[]> getOrderData() {
			String hql = "select sum(o.totalAmount) amount,sum(o.totalQuantity) quantity from qsx_sales_order "
					+ "o where date_format(o.createTime,'%y-%m')=('17-03')";
			return baseRepository.queryBySql(hql);
	}
	
	 /**
     * 查询当天新增客户数量
     * 
     * @param
     * @return
     */
    public List<Object[]> getCustomersOfDay() {
        String sql = "select count(c.id) customerNum,c.id from qsx_customer c where date_format(c.createTime,'%Y-%m-%d')=date_format(now(),'%Y-%m-%d') ";
        List<Object[]> list = baseRepository.queryBySql(sql);
        return list;
    }

    /**
     * 查询本月新增客户数量
     * 
     * @param
     * @return
     */
    public List<Object[]> getCustomersOfMonth() {
        String sql = "select count(c.id) customerNum,c.id from qsx_customer c where date_format(c.createTime,'%Y-%m')=date_format(now(),'%Y-%m') ";
        List<Object[]> list = baseRepository.queryBySql(sql);
        return list;
    }
	
	
}
