package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;

/**
 * 商品查询接口
 * <p>
 * Title: ItemService
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.taotao.com
 * </p>
 * 
 * @author fb
 * @date 2017年2月28日 下午10:04:49
 * @version 1.0
 */
public interface ItemService {

	TbItem getItemById(Long itemId);

	EasyUIDataGridResult getItemList(int page, int rows);

}
