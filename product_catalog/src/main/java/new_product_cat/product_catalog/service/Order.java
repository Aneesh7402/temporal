package new_product_cat.product_catalog.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import new_product_cat.product_catalog.temporal.Workflowint;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

@Service
public class Order{

	@Autowired
	WorkflowServiceStubs workflowServiceStubs;

	@Autowired
	WorkflowClient workflowClient;

	public void placeOrder(String workflowId) {
		Workflowint workflow = createWorkFlowConnection(workflowId);
		WorkflowClient.start(workflow::startOrderWorkflow);
	}

	public void makeOrderAccepted(String workflowId) {
		Workflowint workflow = workflowClient.newWorkflowStub(Workflowint.class, "Order_" + workflowId);
		workflow.signalOrderAccepted();
	}
    public void makeOrderShipped(String workflowId) {
		Workflowint workflow = workflowClient.newWorkflowStub(Workflowint.class, "Order_" + workflowId);
		workflow.signalShipped();
	}

	public void makeOrderPickedUp(String workflowId) {
		Workflowint workflow = workflowClient.newWorkflowStub(Workflowint.class, "Order_" + workflowId);
		workflow.signalOutForDelivery();
	}

	public void makeOrderDelivered(String workflowId) {
		Workflowint workflow = workflowClient.newWorkflowStub(Workflowint.class, "Order_" + workflowId);
		workflow.delivered();
	}

	public Workflowint createWorkFlowConnection(String id) {
		WorkflowOptions options = WorkflowOptions.newBuilder().setTaskQueue(Workflowint.QUEUE_NAME)
				.setWorkflowId("Order_" + id).build();
		return workflowClient.newWorkflowStub(Workflowint.class, options);
	}

}
