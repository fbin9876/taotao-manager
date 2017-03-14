/**
 * 
 */
package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.service.ItemService;

/**
 * 商品查询实现类
 * <p>
 * Title: ItemServiceImpl
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.taotao.com
 * </p>
 * 
 * @author fb
 * @date 2017年2月28日 下午10:19:26
 * @version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper tbItemMapper;

	@Override
	public TbItem getItemById(Long itemId) {
		// TbItem item = tbItemMapper.selectByPrimaryKey(itemId);
		TbItemExample tbItemExample = new TbItemExample();
		// 创建查询条件
		Criteria criteria = tbItemExample.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = tbItemMapper.selectByExample(tbItemExample);
		// 判断是否有值
		TbItem tbItem = null;
		if (list != null && list.size() > 0) {
			tbItem = list.get(0);
		}
		return tbItem;
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {

		// 分页处理
		PageHelper.startPage(page, rows);

		// 执行查询
		TbItemExample tbItemExample = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(tbItemExample);
		// 取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		// 返回处理结果
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}

}
