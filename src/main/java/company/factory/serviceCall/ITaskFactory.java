package company.factory.serviceCall;

import com.sun.istack.internal.NotNull;
import company.services.IServiceCall;

public interface ITaskFactory {
    IServiceCall createTask();
    IServiceCall createTask(@NotNull String name, @NotNull String description);
}
