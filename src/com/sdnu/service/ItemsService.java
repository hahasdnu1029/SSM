package com.sdnu.service;

import java.util.List;

import com.sdnu.domain.Items;

public interface ItemsService {
	//查找所有商品类别
	List<Items> findAllItems();
	//根据id查找单个商品
	Items findById(int id);
	//更新商品信息
	void update(Items item);
	//批量删除商品信息
	void deleteByIds(Integer[] ids);
	//批量更新商品信息
	void updateAll(List<Items> items);

}
