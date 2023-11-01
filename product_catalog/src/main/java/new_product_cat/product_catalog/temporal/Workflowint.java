package new_product_cat.product_catalog.temporal;
import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;
@WorkflowInterface
public interface Workflowint {
    public static final String QUEUE_NAME="Order_queue";
    @WorkflowMethod
    public void startOrderWorkflow();
    @SignalMethod
    public void signalOrderAccepted();
    @SignalMethod
    public void signalShipped();
    @SignalMethod
    public void signalOutForDelivery();
    @SignalMethod
    public void delivered();
}
