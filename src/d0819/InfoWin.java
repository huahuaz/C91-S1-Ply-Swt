package d0819;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;

public class InfoWin {

	protected Shell shell;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InfoWin window = new InfoWin();
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
		shell.setSize(735, 538);
		shell.setText("SWT Application");
		shell.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		new InfoComp(shell, SWT.NONE,"D:\\workspaceJ2SE1\\C91-S1-Ply-Swt\\src\\d0818\\程序员.jpg","促销","降价酬宾");
		new InfoComp(shell, SWT.NONE,"D:\\workspaceJ2SE1\\C91-S1-Ply-Swt\\src\\d0818\\程序员.jpg","促销","降价酬宾");
		new InfoComp(shell, SWT.NONE,"D:\\workspaceJ2SE1\\C91-S1-Ply-Swt\\src\\d0818\\程序员.jpg","促销","降价酬宾");
		new InfoComp(shell, SWT.NONE,"D:\\workspaceJ2SE1\\C91-S1-Ply-Swt\\src\\d0818\\包子.jpg","促销","降价酬宾");
		new InfoComp(shell, SWT.NONE,"D:\\workspaceJ2SE1\\C91-S1-Ply-Swt\\src\\d0818\\包子.jpg","促销","降价酬宾");
	}
}
