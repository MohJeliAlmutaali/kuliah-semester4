package com.app;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class LibraryApp {
    private static final String BOOKS_FILE = "books.json";
    private static final String MEMBERS_FILE = "members.json";
    private static final String TRANSACTIONS_FILE = "transactions.json";

    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    private Gson gson = new Gson();

    public LibraryApp() {
        loadData();
    }

    private void loadData() {
        try {
            File booksFile = new File(BOOKS_FILE);
            File membersFile = new File(MEMBERS_FILE);
            File transactionsFile = new File(TRANSACTIONS_FILE);

            if (booksFile.exists()) {
                try (FileReader reader = new FileReader(booksFile)) {
                    Type bookListType = new TypeToken<List<Book>>() {}.getType();
                    books = gson.fromJson(reader, bookListType);
                }
            }

            if (membersFile.exists()) {
                try (FileReader reader = new FileReader(membersFile)) {
                    Type memberListType = new TypeToken<List<Member>>() {}.getType();
                    members = gson.fromJson(reader, memberListType);
                }
            }

            if (transactionsFile.exists()) {
                try (FileReader reader = new FileReader(transactionsFile)) {
                    Type transactionListType = new TypeToken<List<Transaction>>() {}.getType();
                    transactions = gson.fromJson(reader, transactionListType);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveData() {
        try {
            try (FileWriter writer = new FileWriter(BOOKS_FILE)) {
                gson.toJson(books, writer);
            }

            try (FileWriter writer = new FileWriter(MEMBERS_FILE)) {
                gson.toJson(members, writer);
            }

            try (FileWriter writer = new FileWriter(TRANSACTIONS_FILE)) {
                gson.toJson(transactions, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Methods to add, view, and update books, members, and transactions
    public void addBook(Book book) {
        books.add(book);
        saveData();
    }

    public void addMember(Member member) {
        members.add(member);
        saveData();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        for (Book book : books) {
            if (book.getIdBook() == transaction.getIdBook() && transaction.getStatus() == 1) {
                book.setQuantity(book.getQuantity() - 1);
                book.setBooked(book.getBooked() + 1);
                saveData(); // Menghentikan iterasi setelah buku ditemukan dan diupdate
                break;
            } else if (book.getIdBook() == transaction.getIdBook() && transaction.getStatus() == 2) {
                book.setQuantity(book.getQuantity() + 1);
                book.setBooked(book.getBooked() - 1);
                saveData();
                break;
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 7) {
            System.out.println("===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Add Transaction");
            System.out.println("4. View Books");
            System.out.println("5. View Members");
            System.out.println("6. View Transaction");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    clearScreen();
                    addBookMenu(scanner);
                    break;
                case 2:
                    clearScreen();
                    addMemberMenu(scanner);
                    break;
                case 3:
                    clearScreen();
                    addTransactionMenu(scanner);
                    break;
                case 4:
                    clearScreen();
                    viewBooks();
                    break;
                case 5:
                    clearScreen();
                    viewMembers();
                    break;
                case 6:
                    clearScreen();
                    viewTransactions();
                    break;
                case 7:
                    clearScreen();
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void addBookMenu(Scanner scanner) {
        System.out.print("Enter book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume the leftover newline character
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter categories (comma-separated): ");
        String categoriesInput = scanner.nextLine();
        List<String> categories = Arrays.asList(categoriesInput.split("\\s*,\\s*"));
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        
        

        Book book = new Book();
        book.setIdBook(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setDescription(description);
        book.setCategories(categories);
        book.setQuantity(quantity);
        book.setBooked(0);

        addBook(book);
        System.out.println("Book added successfully!");
    }

    private void addMemberMenu(Scanner scanner) {
        System.out.print("Enter member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        Member member = new Member();
        member.setIdMember(id);
        member.setName(name);
        member.setPhoneNumber(phone);
        member.setEmail(email);
        member.setAddress(address);

        addMember(member);
        System.out.println("Member added successfully!");
    }

    private void addTransactionMenu(Scanner scanner) {
        System.out.print("Enter transaction ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter status (1 for borrow, 2 for return): ");
        int status = scanner.nextInt();
        scanner.nextLine();

        Transaction transaction = new Transaction();
        transaction.setIdTransaction(id);
        transaction.setDateTransaction(new Date());
        transaction.setIdmember(memberId);
        transaction.setIdBook(bookId);
        transaction.setStatus(status);

        addTransaction(transaction);
        System.out.println("Transaction added successfully!");
    }

    private void viewBooks() {
        for (Book book : getBooks()) {
            System.out.println(book);
        }
    }

    private void viewMembers() {
        for (Member member : getMembers()) {
            System.out.println(member);
        }
    }

    private void viewTransactions(){
        for (Transaction transaction : getTransactions()) {
            System.out.println(transaction);
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
