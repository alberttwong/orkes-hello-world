package io.orkes.samples.workers;
import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import org.springframework.stereotype.Component;

@Component
public class WorldHello implements Worker {
    @Override
    public String getTaskDefName() {
        return "atwong-world-hello";
    }

    @Override
    public TaskResult execute(Task task) {
        TaskResult result = new TaskResult(task);

        String name = (String)task.getInputData().get("name");

        StringBuilder reversed = new StringBuilder(name);
        
        //result.addOutputData("hw_response", "Hello World!");
        result.addOutputData("message", reversed.reverse().toString());
        result.addOutputData("test", "this works2!");
        result.setStatus(TaskResult.Status.COMPLETED);
        return result;
    }
}
