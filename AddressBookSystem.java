import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    // Getters and setters for each attribute
}

class AddressBook {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }
    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public void displayAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact.getName() + " - " + contact.getPhoneNumber() + " - " + contact.getEmailAddress());
        }
    }

    public void writeContactsToFile(String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (Contact contact : contacts) {
                fileWriter.write(contact.getName() + "," + contact.getPhoneNumber() + "," + contact.getEmailAddress() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Contact> readContactsFromFile(String filePath) {
        List<Contact> contacts = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] contactData = line.split(",");
                Contact contact = new Contact(contactData[0], contactData[1], contactData[2]);
                contacts.add(contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}

public class AddressBookSystem {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add a new contact");
            System.out.println("2. Edit an existing contact's information");
            System.out.println("3. Search for a contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.next();
                    System.out.print("Enter email address: ");
                    String emailAddress = scanner.next();
                    Contact contact = new Contact(name, phoneNumber, emailAddress);
                    addressBook.addContact(contact);
                    break;
                case 2:
                    // Edit an existing contact's information
                    break;
                case 3:
                    // Search for a contact
                    break;
                case 4:
                    // Display all contacts
                    addressBook.displayAllContacts();
                    break;
                case 5:
                    // Exit
                    return;
            }
        }
    }
}

