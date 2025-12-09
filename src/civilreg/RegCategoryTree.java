package civilreg;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class RegCategoryTree extends JTree{
	private DefaultTreeModel tree;
	public RegCategoryTree() {
		makeStructure();
		this.setModel(tree);
		this.putClientProperty("JTree.lineStyle", "Angled");
	}
	private void makeStructure() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(Main.m.gettf1().getText());
		DefaultMutableTreeNode cb = new DefaultMutableTreeNode("Sổ đăng ký khai sinh");
		DefaultMutableTreeNode cd = new DefaultMutableTreeNode("Sổ đăng ký khai tử");
		DefaultMutableTreeNode cm = new DefaultMutableTreeNode("Sổ đăng ký kết hôn");
		DefaultMutableTreeNode cc = new DefaultMutableTreeNode("Sổ cấp bản sao trích lục hộ tịch");
		tree = new DefaultTreeModel(root);
		tree.insertNodeInto(cb, root, 0);
		tree.insertNodeInto(cd, root, 0);
		tree.insertNodeInto(cm, root, 0);
		tree.insertNodeInto(cc, root, 0);
	}
}
