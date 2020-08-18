package d0818.hw;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.eclipse.swt.SWT;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.widgets.Button;

public class Demo {

	protected Shell shlAboutEclipseIde;
	private Text text;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Demo window = new Demo();
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
		shlAboutEclipseIde.open();
		shlAboutEclipseIde.layout();
		while (!shlAboutEclipseIde.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlAboutEclipseIde = new Shell();
		shlAboutEclipseIde.setSize(911, 371);
		shlAboutEclipseIde.setText("About Eclipse IDE");
		shlAboutEclipseIde.setLayout(new BorderLayout(0, 0));

		Composite composite = new Composite(shlAboutEclipseIde, SWT.NONE);
		composite.setLayoutData(BorderLayout.NORTH);
		composite.setLayout(new FormLayout());

		Label lblNewLabel = new Label(composite, SWT.NONE);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.left = new FormAttachment(0);
		fd_lblNewLabel.top = new FormAttachment(0);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/left.png"));

		text = new Text(composite, SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
		fd_lblNewLabel.right = new FormAttachment(text, -1);
		FormData fd_text = new FormData();
		fd_text.left = new FormAttachment(0, 116);
		fd_text.right = new FormAttachment(100);
		fd_text.bottom = new FormAttachment(0, 164);
		fd_text.top = new FormAttachment(0);
		text.setLayoutData(fd_text);

		Composite composite_1 = new Composite(shlAboutEclipseIde, SWT.NONE);
		composite_1.setLayoutData(BorderLayout.SOUTH);

		Label label_7 = new Label(composite_1, SWT.NONE);
		label_7.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/help.png"));
		label_7.setBounds(28, 0, 38, 30);

		Button btnNewButton = new Button(composite_1, SWT.NONE);
		btnNewButton.setBounds(68, 0, 157, 30);
		btnNewButton.setText("Information Details");

		Button btnClose = new Button(composite_1, SWT.NONE);
		btnClose.setBounds(749, 0, 109, 30);
		btnClose.setText("Close");

		Composite composite_2 = new Composite(shlAboutEclipseIde, SWT.NONE);
		composite_2.setLayoutData(BorderLayout.WEST);
		composite_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Label lblNewLabel_1 = new Label(composite_2, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/1.png"));

		Label lblNewLabel_2 = new Label(composite_2, SWT.NONE);
		lblNewLabel_2.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/2.png"));

		Label lblNewLabel_3 = new Label(composite_2, SWT.NONE);
		lblNewLabel_3.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/3.png"));

		Label lblNewLabel_4 = new Label(composite_2, SWT.NONE);
		lblNewLabel_4.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/4.png"));

		Label lblNewLabel_5 = new Label(composite_2, SWT.NONE);
		lblNewLabel_5.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/5.png"));

		Label lblNewLabel_6 = new Label(composite_2, SWT.NONE);
		lblNewLabel_6.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/6.png"));

		Label lblNewLabel_7 = new Label(composite_2, SWT.NONE);
		lblNewLabel_7.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/7.png"));

		Label lblNewLabel_8 = new Label(composite_2, SWT.NONE);
		lblNewLabel_8.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/8.png"));

		Label lblNewLabel_9 = new Label(composite_2, SWT.NONE);
		lblNewLabel_9.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/9.png"));

		Label lblNewLabel_10 = new Label(composite_2, SWT.NONE);
		lblNewLabel_10.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/10.png"));

		Label label = new Label(composite_2, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/11.png"));

		Label label_1 = new Label(composite_2, SWT.NONE);
		label_1.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/12.png"));

		Label label_2 = new Label(composite_2, SWT.NONE);
		label_2.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/13.png"));

		Label label_3 = new Label(composite_2, SWT.NONE);
		label_3.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/14.png"));

		Label label_4 = new Label(composite_2, SWT.NONE);
		label_4.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/15.png"));

		Label label_5 = new Label(composite_2, SWT.NONE);
		label_5.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/16.png"));

		Label label_6 = new Label(composite_2, SWT.NONE);
		label_6.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/17.png"));

		Label lblNewLabel_11 = new Label(composite_2, SWT.NONE);
		lblNewLabel_11.setImage(SWTResourceManager.getImage(Demo.class, "/d0818/hw/imges/18.png"));

		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("D:\\workspaceJ2SE1\\C91-S1-Ply-Swt\\src\\d0818\\hw\\版权信息.txt");
			br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null) {
				text.setText(text.getText() + line + "\r\n");
			}
		}catch(IOException e) {
				e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
