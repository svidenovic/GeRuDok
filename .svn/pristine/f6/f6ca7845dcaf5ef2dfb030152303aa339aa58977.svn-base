package state;

import java.io.Serializable;

import view.MySlotView;

public class MyStateManager implements Serializable {
	private static final long serialVersionUID = 1L;

	private MyState currentState;
	private MySlotView view;
	MyCircleState circleState; 
	MyRectangleState rectangleState;
	MySelectState selectState;
	
	public MyStateManager(MySlotView med) {
		circleState = new MyCircleState(med); 
		rectangleState = new MyRectangleState(med);
		selectState = new MySelectState(med);
     	currentState = selectState;
     	view = med;
	}
	public MyStateManager( MyStateManager msm ){
		this.currentState = new MyState();
		this.circleState = new MyCircleState( msm.circleState );
		this.selectState = new MySelectState( msm.view );
		this.rectangleState = new MyRectangleState( msm.rectangleState );
	}
	
	public void setCircleState() { currentState = circleState; }
	public void setRectangleState() { currentState = rectangleState; }
	public void setSelectState() { currentState = selectState; }
	public MyState getCurrentState() { return currentState; }
}
