package d0820;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Composite;

import java.io.FileInputStream;
import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import help.SwtLabelPaintListner;

import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class PbWin {

	protected Shell shell;

	private Label[][] cells = new Label[20][20];

	private PbGame pg = new PbGame();

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PbWin window = new PbWin();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(750, 650);
		shell.setText("SWT Application");
		shell.setLayout(new BorderLayout(0, 0));

		Composite compMap = new Composite(shell, SWT.NONE);
		compMap.setLayoutData(BorderLayout.CENTER);
		RowLayout rl_compMap = new RowLayout(SWT.HORIZONTAL);
		rl_compMap.spacing = 0;
		rl_compMap.justify = true;
		compMap.setLayout(rl_compMap);

		compMap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.keyCode == 16777217) {
					pg.moveTop();
				} else if (arg0.keyCode == 16777218) {
					pg.moveDown();
				} else if (arg0.keyCode == 16777219) {
					pg.moveLeft();
				} else if (arg0.keyCode == 16777220) {
					pg.moveRight();
				}
				if (pg.isYouWin()) {
					pg.next();
				}
				refresh();
				// pg.decideWin();
			}
		});

		// 创建400个地图元素对象
		for (int y = 0; y < cells.length; y++) {
			for (int x = 0; x < cells.length; x++) {
				cells[y][x] = new Label(compMap, SWT.NONE);
			}
		}

		Composite compCtrl = new Composite(shell, SWT.NONE);
		compCtrl.setLayoutData(BorderLayout.EAST);
		RowLayout r1_compCtrl = new RowLayout(SWT.VERTICAL);
		r1_compCtrl.spacing = 10;
		r1_compCtrl.marginBottom = 10;
		r1_compCtrl.marginTop = 10;
		r1_compCtrl.marginRight = 10;
		r1_compCtrl.marginLeft = 10;
		compCtrl.setLayout(r1_compCtrl);

		Button btnNewButton = new Button(compCtrl, SWT.NONE);
		btnNewButton.setText("New Button");

		Button btnNewButton_1 = new Button(compCtrl, SWT.NONE);
		btnNewButton_1.setText("New Button");

		Button btnNewButton_2 = new Button(compCtrl, SWT.NONE);
		btnNewButton_2.setText("New Button");

		// 打开窗口刷新地图
		refresh();
	}

	// 刷新地图
	public void refresh() {
		for (int y = 0; y < cells.length; y++) {
			for (int x = 0; x < cells.length; x++) {
				char c = pg.getMap()[y][x];
				String path = "/d0820/imgs/" + c + ".GIF";
				cells[y][x].setImage(SWTResourceManager.getImage(PbWin.class, path));
			}
		}
	}
}
