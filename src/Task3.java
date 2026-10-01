import java.util.*;

// Класс человека. Реализуем Comparable, чтобы TreeSet мог сортировать людей по умолчанию
class Human implements Comparable<Human> {
    String name;
    String lastName;
    int age;

    public Human(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    // Сравниваем людей по возрасту по умолчанию (так требует интерфейс Comparable)
    @Override
    public int compareTo(Human other) {
        if (this.age < other.age) return -1;
        if (this.age > other.age) return 1;
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Если это один и тот же объект в памяти
        if (obj == null || getClass() != obj.getClass()) return false;

        Human other = (Human) obj;

        return this.age == other.age &&
                this.name.equals(other.name) &&
                this.lastName.equals(other.lastName);
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age;
        return result;
    }

    // Чтобы люди красиво выводились в консоль
    @Override
    public String toString() {
        return lastName + " " + name + " (" + age + " лет)";
    }
}

// Отдельный класс, который умеет сравнивать людей только по фамилии
class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        // compareTo у String уже умеет сравнивать строки по алфавиту
        return h1.lastName.compareTo(h2.lastName);
    }
}

public class Task3 {
    public static void run() {
        System.out.println("--- ЗАДАНИЕ 3: Множества и Human ---");

        // Создаем список людей с разными данными и одним полным клоном
        List<Human> list = new ArrayList<>();
        list.add(new Human("Ivan", "Ivanov", 20));
        list.add(new Human("Petr", "Petrov", 19));
        list.add(new Human("Anna", "Sidorova", 20));
        list.add(new Human("Ivan", "Ivanov", 20)); // Полный клон первого
        list.add(new Human("Alex", "Ivanov", 25)); // Другое имя, но та же фамилия

        // 2. HashSet - порядок случайный, дубликаты стирает
        System.out.println("2. HashSet (порядок случайный, дубликат 'Ivan Ivanov 20' убран):");
        System.out.println(new HashSet<>(list));

        // 3. LinkedHashSet - помнит порядок добавления, дубликаты стирает
        System.out.println("3. LinkedHashSet:");
        System.out.println(new LinkedHashSet<>(list));

        // 4. TreeSet - сортирует по возрасту, потому что мы реализовали Comparable
        System.out.println("4. TreeSet:");
        System.out.println(new TreeSet<>(list));

        // 5. TreeSet с компаратором по фамилии
        System.out.println("5. TreeSet с компаратором по фамилии:");
        TreeSet<Human> setByLastName = new TreeSet<>(new HumanComparatorByLastName());
        setByLastName.addAll(list);
        System.out.println(setByLastName);

        // 6. TreeSet с анонимным компаратором по возрасту

        System.out.println("6. TreeSet с анонимным компаратором по возрасту:");
        TreeSet<Human> setByAgeAnon = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                if (h1.age < h2.age) return -1;
                if (h1.age > h2.age) return 1;
                return 0;
            }
        });
        setByAgeAnon.addAll(list);
        System.out.println(setByAgeAnon);

    }
}