import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StoreTester {

    @Test
    void bookTester() {
        Store bookTester = new Store();
        Book book = new Book();
        bookTester.addBook(book);
        assertTrue(bookTester.getItems(Book.class).size() == 1);
    }

    @Test
    void phoneTester() {
        Store phoneTester = new Store();
        Phone phone = new Phone();
        phoneTester.addPhone(phone);
        assertTrue(phoneTester.getItems(Phone.class).size() == 1);
    }

    @Test
    void testBoth(){
        phoneTester();
        bookTester();
    }

    @Test
    void UpdateANDAllPhonesTester() {
        Store phoneTester = new Store();
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        Phone phone3 = new Phone();

        phoneTester.addPhone(phone);
        phoneTester.addPhone(phone2);
        phoneTester.addPhone(phone3);

        phoneTester.updatePhonesLocation("Room 512");
        ArrayList<Phone> processedPhones = new ArrayList<>();

        processedPhones = phoneTester.getAllPhones();

        assertEquals(processedPhones.get(0).getLocation(),"Room 512");
        assertEquals(processedPhones.get(1).getLocation(),"Room 512");
        assertEquals(processedPhones.get(2).getLocation(),"Room 512");

        assertTrue(phoneTester.getItems(Phone.class).size() == 3);
    }

    @Test
    void getItems(){
        Store getItemsTester = new Store();

        //reading items
        Book book = new Book();
        getItemsTester.addBook(book);

        Magazine magazine = new Magazine();
        getItemsTester.addMagazine(magazine);

        //elec items
        Arduino arduino = new Arduino();
        getItemsTester.addArduino(arduino);

        Phone phone = new Phone();
        getItemsTester.addPhone(phone);

        assertEquals(getItemsTester.getItems(Book.class).toString(), "[" + book + "]");
        assertEquals(getItemsTester.getItems(Magazine.class).toString(), "[" + magazine + "]");

        assertEquals(getItemsTester.getItems(Arduino.class).toString(), "[" + arduino + "]");
        assertEquals(getItemsTester.getItems(Phone.class).toString(), "[" + phone + "]");

    }

    @Test
    void updateItems(){
        Store updateItemsTester = new Store();

        Book book = new Book();
        updateItemsTester.addBook(book);

        Magazine magazine = new Magazine();
        updateItemsTester.addMagazine(magazine);

        Arduino arduino = new Arduino();
        updateItemsTester.addArduino(arduino);

        Phone phone = new Phone();
        updateItemsTester.addPhone(phone);

        updateItemsTester.updateItems("Book", "location", "my home");
        updateItemsTester.updateItems("Book", "isbn", "9780312406912");
        updateItemsTester.updateItems("Book", "author", "Henry James");

        ArrayList<Book> bookTester = updateItemsTester.getItems(Book.class);
        for(Book b : bookTester){
            assertEquals(b.getLocation(), "my home");
            assertEquals(b.getIsbn(), "9780312406912");
            assertEquals(b.getAuthor(), "Henry James");
        }

        updateItemsTester.updateItems("Magazine", "price", "25");
        updateItemsTester.updateItems("Magazine", "word count", "320");
        updateItemsTester.updateItems("Magazine", "print date", "November 20th 2004");

        ArrayList<Magazine> magazineTester = updateItemsTester.getItems(Magazine.class);
        for(Magazine m : magazineTester){
            assertEquals(m.getPrice(), 25);
            assertEquals(m.getWordCount(), 320);
            assertEquals(m.getPrintDate(), "November 20th 2004");
        }

        updateItemsTester.updateItems("Arduino", "description", "small microcomputer");
        updateItemsTester.updateItems("Arduino", "storage capacity", "256");
        updateItemsTester.updateItems("Arduino", "maker", "Arduino");
        updateItemsTester.updateItems("Arduino", "version", "10.1.4");

        ArrayList<Arduino> arduinoTester = updateItemsTester.getItems(Arduino.class);
        for(Arduino a : arduinoTester){
            assertEquals(a.getDescription(), "small microcomputer");
            assertEquals(a.getStorageCapacity(), 256);
            assertEquals(a.getMaker(), "Arduino");
            assertEquals(a.getVersion(), "10.1.4");
        }

        updateItemsTester.updateItems("Phone", "name", "Google Pixel 9");
        updateItemsTester.updateItems("Phone", "model", "Pixel 9");
        updateItemsTester.updateItems("Phone", "screen size", "5000000");

        ArrayList<Phone> phoneTester = updateItemsTester.getItems(Phone.class);
        for(Phone p : phoneTester){
            assertEquals(p.getName(), "Google Pixel 9");
            assertEquals(p.getModel(), "Pixel 9");
            assertEquals(p.getScreenSize(), 5000000);
        }
    }

    @Test
    void showAllInfo(){
        Store allInfoTester = new Store();

        Book book = new Book();
        book.setName("Handmaid's Tale");
        book.setLocation("Library");
        book.setPrice(70);
        book.setDescription("Book authored by Margaret Atwood");

        book.setWordCount(10000);
        book.setDatePublished("1984");
        book.setAuthor("Margaret Atwood");

        book.setIsbn("97823952134");
        book.setEdition("10th Edition");
        book.setTitle("Handmaid's Tale");


        allInfoTester.addBook(book);

        Magazine magazine = new Magazine();
        magazine.setName("Time Magazine");
        magazine.setLocation("Library");
        magazine.setPrice(99);
        magazine.setDescription("Discusses the fall of the Soviet Union");

        magazine.setWordCount(5000);
        magazine.setDatePublished("1991");
        magazine.setAuthor("Time Magazine Co.");

        magazine.setCoverStoryTitle("The End of the U.S.S.R.");
        magazine.setPrintDate("1991");

        allInfoTester.addMagazine(magazine);

        Arduino arduino = new Arduino();
        arduino.setName("Arduino Mini");
        arduino.setLocation("Room 513");
        arduino.setPrice(20);
        arduino.setDescription("Good Book");

        arduino.setStorageCapacity(32);
        arduino.setMaker("Arduino");
        arduino.setModel("Mini");
        arduino.setOperatingSystem("Arduino OS");

        arduino.setVersion("1.1.10");

        allInfoTester.addArduino(arduino);

        Phone phone = new Phone();
        phone.setName("Apple iPhone 16 Plus");
        phone.setLocation("Student Affairs Office");
        phone.setPrice(8999);
        phone.setDescription("Cutting edge cellular device");

        phone.setStorageCapacity(256);
        phone.setMaker("Apple");
        phone.setModel("iPhone 16 Plus");
        phone.setOperatingSystem("IOS");

        phone.setNetworkType("GSMA/CDMA");
        phone.setScreenSize(5000);

        allInfoTester.addPhone(phone);

        allInfoTester.showAllInfo();
    }
}
