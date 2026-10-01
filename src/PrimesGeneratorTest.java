import java.util.ArrayList;
import java.util.List;

// Тот самый "проверочный класс", который просит задание
public class PrimesGeneratorTest {
    public static void run() {
        System.out.println("--- ЗАДАНИЕ 2: Генератор простых чисел ---");

        int n = 10;
        PrimesGenerator gen = new PrimesGenerator(n);
        List<Integer> primes = new ArrayList<>();

        System.out.print("Прямой порядок: ");
        while (gen.hasNext()) {
            int p = gen.next();
            primes.add(p);
            System.out.print(p + " ");
        }
        System.out.println();

        System.out.print("Обратный порядок: ");
        for (int i = primes.size() - 1; i >= 0; i--) {
            System.out.print(primes.get(i) + " ");
        }
        System.out.println();
    }
}

