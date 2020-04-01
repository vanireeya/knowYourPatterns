package edu.sjsu.cmpe202.kyp.state;

public class NoImage implements IImageState{
	
	
	IImageStateManager image;


	public NoImage(IImageStateManager m) {
		this.image = m;
	}


	@Override
	public int getImageOpenedCount() {
		return 0;
	}


	@Override
	public void clickedHint() {
		image.setStateOneImage();
	}
	
	
	
	
	

}
