package edu.sjsu.cmpe202.kyp.state;
public class ThreeImage implements IImageState{


	IImageStateManager image;


	public ThreeImage(IImageStateManager m) {
		this.image = m;
	}


	@Override
	public int getImageOpenedCount() {
		return 3;
	}


	@Override
	public void clickedHint() {
		image.setStateFourImage();
		
	}

}
