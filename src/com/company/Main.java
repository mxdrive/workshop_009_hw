package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // Есть файл, в котором в строках хранится информация Имя, Фамилия, email, телефон, разделенный пробелами или
        // запятыми с пробелами - не принципиально. Прочитайте файл и затем сложите в отдельный файл базу данных email’ов.
        // Можно использовать регулярки либо резать строку на подстроки и вытягивать по номеру. Здесь данные упорядочены.
        NewFile newFile = new NewFile();
        newFile.regexp();
        newFile.split();
    }
}