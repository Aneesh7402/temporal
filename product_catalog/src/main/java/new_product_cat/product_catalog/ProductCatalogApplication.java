package new_product_cat.product_catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import io.temporal.worker.WorkerFactory;
import io.temporal.worker.Worker;

import new_product_cat.product_catalog.temporal.Workflowint;
import new_product_cat.product_catalog.temporal.WorkFlowImpl;
import new_product_cat.product_catalog.config.configuration;

@SpringBootApplication
public class ProductCatalogApplication {
	@Autowired
	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(ProductCatalogApplication.class, args);
		
		WorkerFactory factory = appContext.getBean(WorkerFactory.class);
		Worker worker = factory.newWorker(Workflowint.QUEUE_NAME);
		worker.registerWorkflowImplementationTypes(WorkFlowImpl.class);
		factory.start();

	}

}
