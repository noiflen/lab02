import java.util.Iterator;

// Делаем свой класс, который умеет работать как Iterator
public class PrimesGenerator implements Iterator<Integer> {
    private int count = 0;
    private int maxCount;
    private int current = 2;

    public PrimesGenerator(int n) {
        this.maxCount = n;
    }

    // hasNext() - говорит, есть ли еще числа, которые можно выдать
    @Override
    public boolean hasNext() {
        return count < maxCount;
    }

    // next() - возвращает следующее простое число и двигается дальше
    @Override
    public Integer next() {
        while (!isPrime(current)) {
            current++;
        }
        count++;
        int result = current;
        current++;
        return result;
    }

    // Обычная проверка на простоту: делим на все числа от 2 до самого числа
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}