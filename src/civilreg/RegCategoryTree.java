package civilreg;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class RegCategoryTree extends JTree{
	private DefaultTreeModel tree;
	//private DefaultMutableTreeNode root;
	public RegCategoryTree() {
		makeStructure();
		this.setModel(tree);
		this.putClientProperty("JTree.lineStyle", "Angled");
	}
	private void makeStructure() {
		TreeSelectionListener e = new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e1) {
				
			}
		};
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(Main.m.gettf1().getText());
		DefaultMutableTreeNode cb = new DefaultMutableTreeNode("Sổ đăng ký khai sinh");
		DefaultMutableTreeNode cd = new DefaultMutableTreeNode("Sổ đăng ký khai tử");
		DefaultMutableTreeNode cm = new DefaultMutableTreeNode("Sổ đăng ký kết hôn");
		DefaultMutableTreeNode cc = new DefaultMutableTreeNode("Sổ cấp bản sao trích lục hộ tịch");
		tree = new DefaultTreeModel(root);
		tree.insertNodeInto(cc, root, 0);
		tree.insertNodeInto(cm, root, 0);
		tree.insertNodeInto(cd, root, 0);
		tree.insertNodeInto(cb, root, 0);
		this.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		this.getSelectionModel().addTreeSelectionListener(e);
	}
}
