package new_product_cat.product_catalog.temporal;

import io.temporal.workflow.Workflow;


public class WorkFlowImpl implements Workflowint {
    private boolean isOrderConfirmed=false;
    private boolean isOrderOutForShipping=false;
    private boolean isOrderOutForDelivery=false;
    private boolean isOrderDelivered=false;
    @Override
    public void startOrderWorkflow(){
        System.out.println("***** Waiting for exec to confirm your order");
		Workflow.await(() -> isOrderConfirmed);
		
		System.out.println("***** Your Order has been accepted!! Waiting for product to aboard the ship");
		Workflow.await(() -> isOrderOutForShipping);
        System.out.println("***** Your Order has been sent for Shipping!!");
		Workflow.await(() -> isOrderOutForDelivery);
        System.out.println("***** Your Order has been Shipped! The delivery will be at your doorstep shortly");
		Workflow.await(() -> isOrderDelivered);
        System.out.println("***** Your Order has been Delivered");
    }
    @Override
    public void signalOrderAccepted() {
        isOrderConfirmed=true;
        
    }
    @Override
    public void signalShipped(){
        isOrderOutForShipping=true;
    }
    @Override
    public void signalOutForDelivery(){
        isOrderOutForDelivery=true;
    }
    @Override
    public void delivered(){
        isOrderDelivered=true;
    }
}
