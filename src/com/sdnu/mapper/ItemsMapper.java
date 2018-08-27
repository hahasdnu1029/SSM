package com.sdnu.mapper;

import com.sdnu.domain.Items;
import com.sdnu.domain.ItemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
public interface ItemsMapper {
    int countByExample(ItemsExample example);

    int deleteByExample(ItemsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Items record);

    int insertSelective(Items record);

    List<Items> selectByExampleWithBLOBs(ItemsExample example);

    List<Items> selectByExample(ItemsExample example);

    Items selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByExampleWithBLOBs(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByExample(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKeyWithBLOBs(Items record);

    int updateByPrimaryKey(Items record);
    //查询所有商品列表
    List <Items> findAllItems();
    //根据id查询单个商品
	Items findById(int id);
	//更新商品信息
	void update(Items item);
	//批量删除商品信息
	void deleteByIds(Integer[] ids);
	//批量更新商品信息
	void updateAll(List<Items> items);
}