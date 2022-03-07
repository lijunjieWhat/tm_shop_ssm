package com.lijunjie.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijunjie.tmall.bean.Product;
import com.lijunjie.tmall.bean.Property;
import com.lijunjie.tmall.bean.PropertyValue;
import com.lijunjie.tmall.bean.PropertyValueExample;
import com.lijunjie.tmall.dao.PropertyValueMapper;
import com.lijunjie.tmall.service.PropertyService;
import com.lijunjie.tmall.service.PropertyValueService;

@Service
public class PropertyValueServiceImpl implements PropertyValueService {

	@Autowired
	private PropertyValueMapper propertyValueMapper;
	@Autowired
	private PropertyService propertyService;

	@Override
	public List<PropertyValueMapper> queryPropertValue(Integer pid) {
		// TODO Auto-generated method stub
		return propertyValueMapper.queryPropertValue(pid);
	}

	// 因为对于PropertyValue的管理，没有增加，只有修改，每个Property和product对应的属性值都是预设的,所以需要初始化
	@Override
	public void init(Product p) {
		List<Property> pts = propertyService.list(p.getCategory().getId());// 根据cid获取所有的属性列表
		for (Property pt : pts) {
			PropertyValue pv = get(pt.getId(), p.getId()); // 根据属性id和产品id获取属性值，这个方法的返回值可能是null，因为数据库不存在对应的pv记录
			if (pv == null) { // 已获取的属性值对象可能是null，如果是null就初始化,向数据库插入记录
				pv = new PropertyValue();
				pv.setProduct(p);
				pv.setProperty(pt);
				propertyValueMapper.insert(pv);
			}

		}
	}

	@Override
	public void update(PropertyValue pv) {
		propertyValueMapper.updateByPrimaryKeySelective(pv);
	}

	@Override
	public PropertyValue get(int ptid, int pid) {
		PropertyValueExample example = new PropertyValueExample();
		example.createCriteria().andPtidEqualTo(ptid).andPidEqualTo(pid);
		List<PropertyValue> pvs = propertyValueMapper.selectByExample(example);// selectByExample()方法返回的是List
		if (pvs.isEmpty()) { // 这个list可能是空的，如果不是空的就返回第一个匹配的对象
			return null;
		}
		return pvs.get(0);
	}

	@Override
	public List<PropertyValue> list(int pid) {
		PropertyValueExample example = new PropertyValueExample();
		example.createCriteria().andPidEqualTo(pid);
		List<PropertyValue> pvs = propertyValueMapper.selectByExample(example);
		System.out.println(pvs);
		for (PropertyValue pv : pvs) {
			Property property = propertyService.get(pv.getProperty().getId());// 从数据库中取出对应属性值id的属性
			pv.setProperty(property);// 为每个属性值设置其对应的属性对象，这个property不是propertyValue表的字段，需要手动关联
		}
		return pvs;
	}

}
