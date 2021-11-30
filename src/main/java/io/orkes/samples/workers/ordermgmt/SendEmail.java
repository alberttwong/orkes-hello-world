package io.orkes.samples.workers.ordermgmt;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;

public class SendEmail implements Worker {
    @Override
    public String getTaskDefName() {
        return "send_email";
    }

    @Override
    public TaskResult execute(Task task) {
        task.setStatus(Task.Status.COMPLETED);
        return new TaskResult(task);
    }
}
