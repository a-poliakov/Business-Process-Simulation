package company.factory.serviceCall;

import com.sun.istack.internal.NotNull;
import company.services.Defect;
import company.services.IServiceCall;

import java.util.Random;

public class DefectFactory implements ITaskFactory {
    private Random random = new Random();
    private static String[] names = {"NSDPRD-10246", "NSDPRD-10033", "NSDPRD-6464", "NSDPRD-6294", "NSDPRD-6005", "NSDPRD-5875", "NSDPRD-6442", "NSDPRD-10000"};
    private static String[] descriptions = {
            "МК Сервер. При устранении ошибки настройки контентов в настройках мобильного приложения, ошибка продолжает отображаться в списках, если имеются контенты с таким же кодом.",
            "Верстка. Значение атрибута смещается вниз относительно его названия, если у атрибута настроен контрол, который не отображается для текущего пользователя (нет прав или выключено действие по событию)",
            "Если в контенте Параметры связанного объекта у атрибута есть контрол, применяемый к связанному объекту, то при его исключении из группы атрибутов подтягивается интерфейс карточки связанного объекта",
            "При использовании метода api.web.openTab() в скриптах ДПС генерируется некорректная ссылка",
            "Лишняя проверка на обязательность на клиенте при добавлении необязательного комментария с обязательными атрибутами на формах смены ответственного и статуса",
            "Страница с результатами быстрого поиска и страница с персональными настройками отображаются в цветах карточки архивного объекта",
            "NPE в логе из-за некорректной обработки ошибок в цепочке синхронных ДПС",
            "При загрузке частичной метаинформации сбиваются настройки контентов на карточках"

    };

    @Override
    public IServiceCall createTask() {
        int nameIndex = names.length == descriptions.length ? random.nextInt(names.length) : 0;
        return createTask(names[nameIndex], descriptions[nameIndex]);
    }

    @Override
    public IServiceCall createTask(@NotNull String name, @NotNull String description) {
        return new Defect(name, description);
    }
}
