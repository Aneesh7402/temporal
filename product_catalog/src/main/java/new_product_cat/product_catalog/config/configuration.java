package new_product_cat.product_catalog.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowClientOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
import io.temporal.worker.WorkerFactory;
@Component
@Configuration
public class configuration {
    private String temporalServiceAddress = "127.0.0.1:8233";

	private String temporalNamespace = "default";
    @Bean
    public WorkflowServiceStubs workflowServicestubs(){
        WorkflowServiceStubsOptions options=WorkflowServiceStubsOptions.newBuilder().build();
        
        return WorkflowServiceStubs.newServiceStubs(options);
    }
    @Bean
	public WorkflowClient workflowClient(WorkflowServiceStubs workflowServiceStubs) {
		return WorkflowClient.newInstance(workflowServiceStubs,
				WorkflowClientOptions.newBuilder().setNamespace(temporalNamespace).build());
	}
    @Bean
    public WorkerFactory workerFactory(WorkflowClient workflowClient){
        return WorkerFactory.newInstance(workflowClient, null);
    }
}
