package edu.gqq.lvjuan;

import edu.gqq.common.G;

public class GqqButton {

	private OnClickListener mListener;

	public void setOnClickList(OnClickListener listener) {
		this.mListener = listener;
	}
	public interface OnClickListener {
		void OnClick(Object obj, String info);
	}

	public void click() {
		G.println("Gqq Button is clicked!");

		processClick("after");
	}

	private void processClick(String str) {
		if (null != mListener)
			mListener.OnClick(this, "this msg " + str + "click");
	}

	public static void main(String[] args) {
		GqqButton gb = new GqqButton();
		gb.setOnClickList(new OnClickListener() {
			@Override
			public void OnClick(Object obj, String info) {
				G.println(gb == obj);
				G.println(obj.getClass().getSimpleName());
				G.println(info);
			}
		});
		gb.click();
	}
}

