package edu.sjsu.cmpe202.kyp.state;
public class FourImage implements IImageState{


	IImageStateManager image;


	public FourImage(IImageStateManager m) {
		this.image = m;
	}


	@Override
	public int getImageOpenedCount() {
		return 4;
	}


	@Override
	public void clickedHint() {


	}

}
