package edu.sjsu.cmpe202.kyp.state;
public class OneImage implements IImageState{


	IImageStateManager image;


	public OneImage(IImageStateManager m) {
		this.image = m;
	}


	@Override
	public int getImageOpenedCount() {
		return 1;
	}


	@Override
	public void clickedHint() {
		image.setStateTwoImage();
		
	}
	

}
