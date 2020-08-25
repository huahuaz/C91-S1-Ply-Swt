package d0818;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ibm.icu.util.Calendar;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class RegWin {

	protected Shell shell;
	private Text textName;
	private Text textPwd;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RegWin window = new RegWin();
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
		shell.setSize(469, 538);
		shell.setText("注册");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(63, 56, 62, 20);
		lblNewLabel.setText("姓名:");

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(63, 103, 62, 20);
		lblNewLabel_1.setText("密码:");

		textName = new Text(shell, SWT.BORDER);
		textName.setBounds(131, 53, 150, 26);

		textPwd = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		textPwd.setBounds(131, 100, 150, 26);

		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(63, 155, 62, 20);
		lblNewLabel_2.setText("性别:");

		Button rb1 = new Button(shell, SWT.RADIO);
		rb1.setBounds(147, 155, 69, 20);
		rb1.setText("男");

		Button rb2 = new Button(shell, SWT.RADIO);
		rb2.setBounds(222, 155, 78, 20);
		rb2.setText("女");

		Label Aihao = new Label(shell, SWT.NONE);
		Aihao.setBounds(63, 199, 62, 20);
		Aihao.setText("爱好:");

		Button cb1 = new Button(shell, SWT.CHECK);
		cb1.setBounds(131, 199, 62, 20);
		cb1.setText("足球");

		Button cb2 = new Button(shell, SWT.CHECK);
		cb2.setText("篮球");
		cb2.setBounds(199, 199, 62, 20);

		Button cb3 = new Button(shell, SWT.CHECK);
		cb3.setText("滑雪");
		cb3.setBounds(267, 199, 62, 20);

		Button cb4 = new Button(shell, SWT.CHECK);
		cb4.setText("盗墓");
		cb4.setBounds(335, 199, 62, 20);

		Combo comboEdu = new Combo(shell, SWT.NONE);
		comboEdu.setItems(new String[] { "小学", "初中", "高中", "大专", "本科" });
		comboEdu.setBounds(131, 240, 150, 28);

		Label lblNewLabel_2_1 = new Label(shell, SWT.NONE);
		lblNewLabel_2_1.setText("学历:");
		lblNewLabel_2_1.setBounds(63, 243, 62, 20);

		Spinner spinnerAge = new Spinner(shell, SWT.BORDER);
		spinnerAge.setMaximum(200);
		spinnerAge.setBounds(131, 287, 101, 26);

		Label lblNewLabel_2_1_1 = new Label(shell, SWT.NONE);
		lblNewLabel_2_1_1.setText("年龄:");
		lblNewLabel_2_1_1.setBounds(63, 290, 62, 20);

		DateTime dtBirthday = new DateTime(shell, SWT.BORDER);
		dtBirthday.setBounds(131, 333, 150, 28);

		Label lblNewLabel_2_1_1_1 = new Label(shell, SWT.NONE);
		lblNewLabel_2_1_1_1.setText("生日:");
		lblNewLabel_2_1_1_1.setBounds(63, 341, 62, 20);

		Label lblNewLabel_2_1_1_1_1 = new Label(shell, SWT.NONE);
		lblNewLabel_2_1_1_1_1.setText("积分:");
		lblNewLabel_2_1_1_1_1.setBounds(63, 384, 62, 20);

		ProgressBar pbScore = new ProgressBar(shell, SWT.NONE);
		pbScore.setSelection(50);
		pbScore.setBounds(131, 384, 210, 21);

		Label lblNewLabel_3 = new Label(shell, SWT.BORDER);
		lblNewLabel_3.setImage(SWTResourceManager.getImage(RegWin.class, "/d0818/程序员.jpg"));
		lblNewLabel_3.setBounds(311, 34, 111, 141);

		Button button_3 = new Button(shell, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 获取用户信息的输入值，写入到用户对象中
				UserInfo ui = new UserInfo(textName.getText(), textPwd.getText());
				// 性别rb1,rb2 getSelection 判断是否选中
				if (rb1.getSelection()) {
					ui.setSex('男');
				} else if (rb2.getSelection()) {
					ui.setSex('女');
				}
				// 爱好
				ui.setLiles(new ArrayList<>());
				Button[] cbSeies = { cb1, cb2, cb3, cb4 };
				for (Button cb : cbSeies) {
					if (cb.getSelection()) {
						ui.getLiles().add(cb.getText());
					}
				}
				// 学历
				if (comboEdu.getSelectionIndex() > -1) {
					String edu = comboEdu.getItem(comboEdu.getSelectionIndex());
					ui.setEdu(edu);
				}
				// 年龄
				int age = Integer.valueOf(spinnerAge.getText());
				ui.setAge(age);
				// 生日
				Calendar c = Calendar.getInstance();
				c.set(Calendar.YEAR, dtBirthday.getYear());
				c.set(Calendar.MONTH, dtBirthday.getMonth());
				c.set(Calendar.DAY_OF_MONTH, dtBirthday.getDay());
				Date date = c.getTime();
				ui.setBirthday(date);
				// 积分
				ui.setScore(pbScore.getSelection());
				// 打印
				System.out.println(ui);
			}
		});
		button_3.setBounds(84, 438, 98, 30);
		button_3.setText("注册");

		Button button_4 = new Button(shell, SWT.NONE);
		button_4.setBounds(243, 438, 98, 30);
		button_4.setText("取消");

	}
}
