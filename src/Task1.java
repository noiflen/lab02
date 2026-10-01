import java.util.*;

public class Task1 {
    public static void run() {
        System.out.println("--- ЗАДАНИЕ 1: Методы Collections ---");

        int n = 10;
        int[] arr = new int[n];

        // 1. Создаем массив из N случайных чисел от 0 до 100
        System.out.print("1. Исходный массив: ");
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * 101);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 2. Делаем из обычного массива список (ArrayList)
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(arr[i]);
        }
        System.out.println("2. Список из массива: " + list);

        // 3. Сортировка по возрастанию (встроенный метод из класса Collections)
        Collections.sort(list);
        System.out.println("3. По возрастанию: " + list);

        // 4. Переворачиваем список задом наперед
        Collections.reverse(list);
        System.out.println("4. В обратном порядке: " + list);

        // 5. Перемешиваем элементы в случайном порядке (как колоду карт)
        Collections.shuffle(list);
        System.out.println("5. Перемешанный: " + list);

        // 6. Сдвигаем все элементы вправо на 1 позицию
        Collections.rotate(list, 1);
        System.out.println("6. Сдвиг на 1 элемент: " + list);

        // 7. Оставляем только уникальные элементы
        List<Integer> uniqueList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int current = list.get(i);
            if (!uniqueList.contains(current)) {
                uniqueList.add(current);
            }
        }
        System.out.println("7. Только уникальные: " + uniqueList);

        // 8. Оставляем только дублирующиеся элементы
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int current = list.get(i);
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == current) {
                    count++;
                }
            }
            if (count > 1 && !duplicates.contains(current)) {
                duplicates.add(current);
            }
        }
        System.out.println("8. Только дублирующиеся: " + duplicates);

        // 9. Превращаем список уникальных элементов обратно в массив
        Integer[] newArr = new Integer[uniqueList.size()];
        for (int i = 0; i < uniqueList.size(); i++) {
            newArr[i] = uniqueList.get(i);
        }
        System.out.println("9. Массив из уникальных: " + Arrays.toString(newArr));

        // 10. Подсчитываем, сколько раз каждое число встретилось
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (counts.containsKey(num)) {
                counts.put(num, counts.get(num) + 1);
            } else {
                counts.put(num, 1);
            }
        }
        System.out.println("10. Частота вхождений: " + counts);
    }
}