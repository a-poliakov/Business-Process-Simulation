package company.factory.serviceCall;

import company.services.Defect;
import company.services.Development;
import company.services.IServiceCall;

import java.util.Random;

public class DevelopmentFactory implements ITaskFactory {
    private Random random = new Random();
    private static String[] names = {"NSDPRD-10137", "NSDPRD-10229", "NSDPRD-10082", "NSDPRD-10116", "NSDPRD-10122"};
    private static String[] descriptions = {
            "Сохранение фильтров в списках в режиме администрирования",
            "Методы для работы с исключениями классов обслуживания",
            "Доработать приложение KanboardPresenter для повышения стабильности",
            "В плоском списке при перемещении или редактировании родителя (например, перемещение сотрудников по отделам) не показывать элементы, недоступные из-за ограничения по типам.",
            " МК Сервер Доработка ДПС для события “Пользовательское событие” для событий в МК"

    };

    @Override
    public IServiceCall createTask() {
        int nameIndex = names.length == descriptions.length ? random.nextInt(names.length) : 0;
        return createTask(names[nameIndex], descriptions[nameIndex]);
    }

    @Override
    public IServiceCall createTask(String name, String description) {
        return new Development(name, description);
    }


}
