package d0819;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import help.SwtLabelPaintListner;

public class InfoComp extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public InfoComp(Composite parent, int style,String img,String title,String desc) {
		super(parent, style);
		
		Label label = new Label(this, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(img));
		label.setBounds(10, 72, 111, 140);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		lblNewLabel.setBounds(10, 10, 60, 30);
		lblNewLabel.setText(title);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBounds(37, 46, 100, 20);
		label_1.setText(desc);
		
		label.addPaintListener(new SwtLabelPaintListner());
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
