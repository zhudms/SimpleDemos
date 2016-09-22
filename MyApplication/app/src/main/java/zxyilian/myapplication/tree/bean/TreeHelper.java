package zxyilian.myapplication.tree.bean;



import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import zxyilian.myapplication.R;

/**
 * http://blog.csdn.net/lmj623565791/article/details/40212367
 * @author zhy
 *
 */
public class TreeHelper
{
	/**
	 * 传入我们的普通bean，转化为我们排序后的Node
	 * 
	 * @param datas
	 * @param defaultExpandLevel
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <T> List<com.zhy.tree.bean.Node> getSortedNodes(List<T> datas,
			int defaultExpandLevel) throws IllegalArgumentException,
			IllegalAccessException

	{
		List<com.zhy.tree.bean.Node> result = new ArrayList<com.zhy.tree.bean.Node>();
		// 将用户数据转化为List<Node>
		List<com.zhy.tree.bean.Node> nodes = convetData2Node(datas);
		// 拿到根节点
		List<com.zhy.tree.bean.Node> rootNodes = getRootNodes(nodes);
		// 排序以及设置Node间关系
		for (com.zhy.tree.bean.Node node : rootNodes)
		{
			addNode(result, node, defaultExpandLevel, 1);
		}
		return result;
	}

	/**
	 * 过滤出所有可见的Node
	 * 
	 * @param nodes
	 * @return
	 */
	public static List<com.zhy.tree.bean.Node> filterVisibleNode(List<com.zhy.tree.bean.Node> nodes)
	{
		List<com.zhy.tree.bean.Node> result = new ArrayList<com.zhy.tree.bean.Node>();

		for (com.zhy.tree.bean.Node node : nodes)
		{
			// 如果为跟节点，或者上层目录为展开状态
			if (node.isRoot() || node.isParentExpand())
			{
				setNodeIcon(node);
				result.add(node);
			}
		}
		return result;
	}

	/**
	 * 将我们的数据转化为树的节点
	 * 
	 * @param datas
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private static <T> List<com.zhy.tree.bean.Node> convetData2Node(List<T> datas)
			throws IllegalArgumentException, IllegalAccessException

	{
		List<com.zhy.tree.bean.Node> nodes = new ArrayList<com.zhy.tree.bean.Node>();
		com.zhy.tree.bean.Node node = null;

		for (T t : datas)
		{
			int id = -1;
			int pId = -1;
			String label = null;
			Class<? extends Object> clazz = t.getClass();
			Field[] declaredFields = clazz.getDeclaredFields();
			for (Field f : declaredFields)
			{
				if (f.getAnnotation(TreeNodeId.class) != null)
				{
					f.setAccessible(true);
					id = f.getInt(t);
				}
				if (f.getAnnotation(TreeNodePid.class) != null)
				{
					f.setAccessible(true);
					pId = f.getInt(t);
				}
				if (f.getAnnotation(TreeNodeLabel.class) != null)
				{
					f.setAccessible(true);
					label = (String) f.get(t);
				}
				if (id != -1 && pId != -1 && label != null)
				{
					break;
				}
			}
			node = new com.zhy.tree.bean.Node(id, pId, label);
			nodes.add(node);
		}

		/**
		 * 设置Node间，父子关系;让每两个节点都比较一次，即可设置其中的关系
		 */
		for (int i = 0; i < nodes.size(); i++)
		{
			com.zhy.tree.bean.Node n = nodes.get(i);
			for (int j = i + 1; j < nodes.size(); j++)
			{
				com.zhy.tree.bean.Node m = nodes.get(j);
				if (m.getpId() == n.getId())
				{
					n.getChildren().add(m);
					m.setParent(n);
				} else if (m.getId() == n.getpId())
				{
					m.getChildren().add(n);
					n.setParent(m);
				}
			}
		}

		// 设置图片
		for (com.zhy.tree.bean.Node n : nodes)
		{
			setNodeIcon(n);
		}
		return nodes;
	}

	private static List<com.zhy.tree.bean.Node> getRootNodes(List<com.zhy.tree.bean.Node> nodes)
	{
		List<com.zhy.tree.bean.Node> root = new ArrayList<com.zhy.tree.bean.Node>();
		for (com.zhy.tree.bean.Node node : nodes)
		{
			if (node.isRoot())
				root.add(node);
		}
		return root;
	}

	/**
	 * 把一个节点上的所有的内容都挂上去
	 */
	private static void addNode(List<com.zhy.tree.bean.Node> nodes, com.zhy.tree.bean.Node node,
			int defaultExpandLeval, int currentLevel)
	{

		nodes.add(node);
		if (defaultExpandLeval >= currentLevel)
		{
			node.setExpand(true);
		}

		if (node.isLeaf())//是叶结点，说明没有子结点了
			return;
		for (int i = 0; i < node.getChildren().size(); i++)
		{
			addNode(nodes, node.getChildren().get(i), defaultExpandLeval,
					currentLevel + 1);
		}
	}

	/**
	 * 设置节点的图标
	 * 
	 * @param node
	 */
	private static void setNodeIcon(com.zhy.tree.bean.Node node)
	{
		if (node.getChildren().size() > 0 && node.isExpand())
		{
			node.setIcon(R.drawable.tree_ex);
		} else if (node.getChildren().size() > 0 && !node.isExpand())
		{
			node.setIcon(R.drawable.tree_ec);
		} else
			node.setIcon(-1);

	}

}
