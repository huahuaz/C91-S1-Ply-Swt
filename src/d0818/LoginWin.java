package d0818;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class LoginWin {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginWin window = new LoginWin();
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
		shell.setSize(450, 300);
		shell.setText("登录窗口");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(60, 58, 76, 20);
		label.setText("用户名:");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(142, 55, 171, 26);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("密码:");
		label_1.setBounds(60, 116, 76, 20);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(142, 110, 171, 26);
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(83, 186, 98, 30);
		button.setText("登录");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setBounds(238, 186, 98, 30);
		button_1.setText("取消");

	}
}
