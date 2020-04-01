package edu.sjsu.cmpe202.kyp.state;
public class TwoImage implements IImageState{


	IImageStateManager image;


	public TwoImage(IImageStateManager m) {
		this.image = m;
	}


	@Override
	public int getImageOpenedCount() {
		return 2;
	}


	@Override
	public void clickedHint() {
		image.setStateThreeImage();
		
	}

}
