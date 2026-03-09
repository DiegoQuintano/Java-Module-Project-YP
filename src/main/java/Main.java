import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race(); // создаем объект класса Race

        for (int i = 1; i <=3; i++) { // цикл для ввода данных для 3 машин

            // введение названия
            System.out.println("Введите название машины №" + i + ":");
            String name = scanner.nextLine(); // считываем название

            while(name.isEmpty()) { // проверяем, вдруг название пусто
                System.out.println("Название отсутствует. Введите название машины:");
                name = scanner.nextLine();
            }

            // введение скорости
            int speed;
            while (true) { // цикл для ввода корректной скорости
                System.out.println("Введите скорость машины №" + i + ":");

                if (scanner.hasNextInt()) { // проверяем, что будет введено целое число
                    speed = scanner.nextInt();
                    scanner.nextLine(); //очистка буфера

                    if (speed > 0 && speed <= 250) { // проверяем, что скорость в диапазоне
                        break;
                    } else {
                        System.out.println("Скорость должна быть в пределах 0 - 250");
                    }
                } else {
                    System.out.println("Необходимо ввести число"); // если не число
                    scanner.nextInt(); // очситка буфера в случает неверного ввода
                }
            }

            Car car = new Car(name, speed); // создаем объект класса Car
            race.checkLeader(car); // проверяем, является ли эта машина лидером
            }
        System.out.println("Самая быстрая машина: " + race.getLeaderName());
        }
    }
