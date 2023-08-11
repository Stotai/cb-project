package com.qianya.util.dtree;
import com.qianya.util.dtree.model.DTreeResponse;
import com.qianya.util.dtree.model.EleTree;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EleTreeUtil {

	/*public static  <T> Map<String, Object> getResp(List<T> list, String id, String pId, String title, String disabled, String disableValue) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//DTreeResponse resp = new DTreeResponse();
		List<EleTree> data = new ArrayList<>();
		for (T t : list) {
			EleTree tree = new EleTree();
			tree.setId(getValue(t, id));
			tree.setParentId("0".equals(pId)?"0":getValue(t, pId));
			tree.setTitle(getValue(t, title));
			data.add(tree);
		}
		Map<String, Object> oldMap=listToTree(data);

		//resp.setData(oldMap);
		return oldMap;
	}*/
	/**
	 * 节点list 转成树
	 * @param
	 * @return
	 */

	public static Map<String, Object> listToTree(List<EleTree> list){
		Map<String, Object> newList = new HashMap<String, Object>();
		Map<String, Map<String, Object>> idToRegionMap = new HashMap<>();
		for (EleTree ele:list) {
			idToRegionMap.put(ele.getId() ,toNode(ele));
		}
		newList.put("gridName","所有");
		newList.put("child",new ArrayList<Map<String, Object>>());

//       遍历，有父节点就和添加到父节点parentNode的child下面，没有父节点就添加到根节点child的下面
		for (Map<String, Object> node: idToRegionMap.values()) {
//       添加到父节点的child
			if(idToRegionMap.containsKey(node.get("parentId"))){
				Map<String, Object> parentNode = idToRegionMap.get(node.get("parentId"));
				if(parentNode.containsKey("child")){
					List<Map<String, Object>> child = (List<Map<String, Object>>) parentNode.get("child");
					child.add(node);
				}else {
					List<Map<String, Object>> child = new ArrayList<>();
					child.add(node);
					parentNode.put("child",child);
				}
			}else {
//        添加到根节点
				List<Map<String, Object>> child = (List<Map<String, Object>>) newList.get("child");
				child.add(node);
			}
		}
		return newList;
	}
	private static Map<String ,Object> toNode(EleTree ele){
		Map<String, Object> node = new HashMap<String, Object>();
		node.put("id",ele.getId());
		node.put("title",ele.getTitle());
		node.put("parentId",ele.getParentId());
		return node;
	}
	private static <T> String getValue(T t,String param) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(t.getClass(), param);
		Method getMethod = pd.getReadMethod();
		return String.valueOf(getMethod.invoke(t));
	}

	public static <T> Object getResp(List<T> list, String id, String pId, String title) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<EleTree> data = new ArrayList<>();
		for (T t : list) {
			EleTree tree = new EleTree();
			tree.setId(getValue(t, id));
			tree.setParentId("0".equals(pId)?"0":getValue(t, pId));
			tree.setTitle(getValue(t, title));
			data.add(tree);
		}
		return listToTree(data);
	}
}
