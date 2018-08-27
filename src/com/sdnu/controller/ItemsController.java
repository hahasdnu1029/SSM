package com.sdnu.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sdnu.domain.Items;
import com.sdnu.exception.CustomerException;
import com.sdnu.service.ItemsService;
import com.sdnu.vo.QueryVo;

@Controller(value = "itemsController")
@RequestMapping(value="/items")
public class ItemsController {
	// 注入service层对象
	@Autowired
	private ItemsService itemsService;
	
	/**
	 * 查询所有商品列表
	 * @return
	 */
	@RequestMapping(value="/itemsList")
	public ModelAndView getItems() throws Exception {
		// 调用service层方法查询
		List<Items> itemsList = itemsService.findAllItems();
		// 创建视图模型对象
		ModelAndView modelAndView = new ModelAndView();
		//把数据放入模型视图对象
		modelAndView.addObject("itemsList", itemsList);
		//把视图添加到模型视图对象中
		modelAndView.setViewName("itemList");
		return modelAndView;

	}
	/**
	 * 根据id查找单个商品
	 */
	@RequestMapping(value="/itemEdit/{id}")
	public String findItemsById(@PathVariable("id") String strId,Model model) throws Exception{
		int id;
		if(strId!=null&&!strId.trim().equals("")){
			id = Integer.parseInt(strId);
		}else{
			return "forward:itemsList";
		}
		//调用service层方法
		Items item=itemsService.findById(id);
		//把查询结果放入模型对象中
		model.addAttribute("item", item);
		return "editItem";
	}
	/**
	 * 更新商品信息
	 */
	@RequestMapping(value="/updateItem")
	public String update(Items item,MultipartFile pictureFile) throws Exception{
		//获得源文件名称
		String fileSourceName = pictureFile.getOriginalFilename();
		//组装新的文件名称
		String uuid = UUID.randomUUID().toString().replace("-", "");
		String fileNewName=uuid+"_"+fileSourceName;
		//设置新的名字
		item.setPic(uuid);
		//上传文件
		//创建存放文件的文件夹
		File uploadFile=new File("D://pic");
		if(!uploadFile.exists()){
			uploadFile.mkdirs();
		}
		pictureFile.transferTo(new File(uploadFile,fileNewName));
		//调用业务层
		itemsService.update(item);
		return "forward:itemsList";
	}
	/**
	 * 批量删除产品
	 */
	@RequestMapping(value="/deleteItemsByIds")
	public String deleteByIds(Integer[] ids){
		//调用业务层
		if(ids!=null&&ids.length>0){
			itemsService.deleteByIds(ids);
		}
		return "forward:itemsList";
	}
	/**
	 * 批量修改产品信息
	 */
	@RequestMapping(value="/updateAll")
	public String updateAll(QueryVo vo){
		List<Items> items=vo.getItemList();
		if(items!=null&&items.size()>0){
			//调用service层
			itemsService.updateAll(items);
		}	
		return "forward:itemsList";
	}
	/**
	 * json传递数据
	 * @return
	 */
	@RequestMapping("/transJson")
	@ResponseBody
	public  Items transJson(@RequestBody Items item){
		System.out.println("22222222222222222222222");
		return item;
	}
	@RequestMapping("/test")
	public String test(){
		return "redirect:itemsList";
	}
	@RequestMapping("/test2")
	public String test2(){
		return "redirect:/items/updateAll.action";
	}
	@RequestMapping("/test3")
	public String test3(){
		return "redirect:/jsp/itemList.jsp";
	}
	@SuppressWarnings("unused")
	@RequestMapping("/test4")
	public String test4() throws CustomerException{
		if(true){
			throw new CustomerException("商品信息不存在！");
		}
		return "redirect:/jsp/itemList.jsp";
	}
}
