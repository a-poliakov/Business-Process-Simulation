package lab3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {
    public static void main(String[] args) throws IOException {
        // 1. получаем строчки из файла
        Stream<String> lines = FileUtils.getFileLines("/Users/andreipoliakov/Downloads/ITCompany/text2.txt");
        // 2. находим все уникальные слова в тексте и количество их вхождений
        Map<String, Long> wordsWithCount = getUnicWordsWithCountFromStream(lines);
        // 3. сортируем и оставляем топ-20 слов
        List<Map.Entry<String,Long>> sortedEntries = sortAndLimit(wordsWithCount.entrySet());
        // 4. выводим результат
        sortedEntries.forEach(FileUtils::writeResult);
    }

    /**
     * Получение стрима строчек из файла
     * @param fileName путь к файлу для считывания данных
     * @return stream считанных строчек файла
     * @throws IOException если файл не существует или другая ошибка ввода-вывода
     */
    private static Stream<String> getFileLines(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName));
    }

    /**
     * Нахождение всех уникальных слов в тексте и количества их вхождений
     * @param lines строчки текста для обработки
     * @return набор пар <слово, количество вхождений>
     */
    private static Map<String, Long> getUnicWordsWithCountFromStream(Stream<String> lines){
        return lines.flatMap(line -> Stream.of(line.split("[^a-zA-Zа-яА-ЯёЁ\\-]"))) // разделяем по символам, не являющимися частью слова
                .filter(word -> !word.isEmpty()) // из 0 символов
                .filter(word -> !word.matches("[\\-]+") && !word.endsWith("-") && !word.startsWith("-")) // дефисы вне слов
                .map(String::toLowerCase) // для единообразия к нижнему регистру
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * Сортирует и оставляет топ-20 слов
     * @param wordsWithCount набор пар <слово, количество вхождений>
     * @return  отсортированный список пар <слово, количество вхождений>
     */
    private static List<Map.Entry<String,Long>> sortAndLimit(Set<Map.Entry<String,Long>> wordsWithCount){
        return wordsWithCount.stream()
                .sorted((a, b) -> {
                    int result = b.getValue().compareTo(a.getValue());
                    return result == 0 ? a.getKey().compareTo(b.getKey()) : result;
                })
                .limit(20).collect(Collectors.toList());
    }

    /**
     * Форматированный вывод пары <слово, количество вхождений>
     * @param element пара <слово, количество вхождений>
     */
    private static void writeResult(Map.Entry<String,Long> element){
        System.out.println(String.format("%s - %s", element.getKey(), element.getValue()));
    }
}
