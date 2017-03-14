package com.taotao.pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

/**
 * 测试TestPageHelper
 * <p>
 * Title: TestPageHelper
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.taotao.com
 * </p>
 * 
 * @author fb
 * @date 2017年3月2日 下午8:12:27
 * @version 1.0
 */
public class TestPageHelper {

	@Test
	public void testPageHelper() {
		// 1、获取mapper代理对象
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-*.xml");
		TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class);
		// 2、设置分页

		PageHelper.startPage(1, 30);

		// 3、执行查询
		TbItemExample tbItemExample = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(tbItemExample);

		// 4、 取分页后结果

		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("total:" + total);
		int pageSize = pageInfo.getSize();
		System.out.println("size:" + pageSize);
		int pages = pageInfo.getPages();
		System.out.println("pages:" + pages);
	}
}
