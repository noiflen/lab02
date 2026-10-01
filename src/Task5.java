import java.util.HashMap;
import java.util.Map;

public class Task5 {
    public static void run() {
        System.out.println("--- ЗАДАНИЕ 5: Обмен ключей и значений ---");

        // Создаем тестовую карту
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 1); // Специально делаем одинаковое значение для проверки

        System.out.println("Исходная: " + map);
        System.out.println("Обмененная: " + swapMap(map));

    }

    static <K, V> Map<V, K> swapMap(Map<K, V> original) {
        Map<V, K> swapped = new HashMap<>();

        // Перебираем все пары из исходной карты
        for (Map.Entry<K, V> entry : original.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();
            swapped.put(value, key);
        }

        return swapped;
    }
}
