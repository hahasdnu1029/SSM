package com.sdnu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdnu.domain.Items;
import com.sdnu.mapper.ItemsMapper;
import com.sdnu.service.ItemsService;
@Service
public class ItemsServiceImpl implements ItemsService {
	//注入dao层对象
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> findAllItems() {
		return itemsMapper.findAllItems();
	}

	@Override
	public Items findById(int id) {
		return itemsMapper.findById(id);
	}

	@Override
	public void update(Items item) {
		itemsMapper.update(item);
	}

	@Override
	public void deleteByIds(Integer[] ids) {
		itemsMapper.deleteByIds(ids);
	}

	@Override
	public void updateAll(List<Items> items) {
		itemsMapper.updateAll(items);
	}
}
