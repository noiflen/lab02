import java.util.HashMap;
import java.util.Map;

public class Task4 {
    public static void run() {
        System.out.println("--- ЗАДАНИЕ 4: Частота слов ---");

        String text = "Hello world! Hello everyone. World is beautiful, isn't it? Hello!";

        // 1. Переводим всё в нижний регистр, чтобы "Hello" и "hello" считались одним словом
        String lowerText = text.toLowerCase();

        // 2. Заменяем все знаки препинания и символы на пробелы.
        String cleanText = lowerText.replaceAll("[^a-z]+", " ");

        // 3. Разбиваем очищенную строку на массив слов по пробелам
        String[] words = cleanText.split(" ");

        // 4. Создаем карту для подсчета: Ключ = слово, Значение = сколько раз встретилось
        Map<String, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) {
                continue;
            }
            if (freqMap.containsKey(word)) {
                freqMap.put(word, freqMap.get(word) + 1);
            } else {
                freqMap.put(word, 1);
            }
        }

        System.out.println("Частота слов:");
        // Перебираем все ключи  в нашей карте и выводим результат
        for (String key : freqMap.keySet()) {
            System.out.println(key + ": " + freqMap.get(key));
        }
    }
}