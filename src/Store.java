import java.util.ArrayList;

public class Store {

   ArrayList<CISItem> cisItem;

   public Store(){
       cisItem = new ArrayList<>();
   }

   public void addBook(Book book){
       cisItem.add(book);
   }

   public void addPhone(Phone phone){
       cisItem.add(phone);
   }

   public void addMagazine(Magazine magazine){
       cisItem.add(magazine);
   }

   public void addArduino(Arduino arduino){
       cisItem.add(arduino);
   }

   public void updatePhonesLocation(String location){
       Phone newphone = new Phone();
       ArrayList<Integer> phones = new ArrayList<>();


       for(int i = 0; i < cisItem.size(); i++){
            if(cisItem.get(i).getClass().equals(newphone.getClass())){
                phones.add(i);
            }
       }

       for(int i = 0; i < phones.size(); i++){
           cisItem.get(phones.get(i)).setLocation(location);
       }

   }

   public ArrayList<Phone> getAllPhones(){
       Phone newphone = new Phone();
       ArrayList<Integer> phones = new ArrayList<>();

       for(int i = 0; i < cisItem.size(); i++){
           if(cisItem.get(i).getClass().equals(newphone.getClass())){
               phones.add(i);
           }
       }

       ArrayList<Phone> allPhones = new ArrayList<>();
       for(int i = 0; i < phones.size(); i++){
           allPhones.add((Phone) cisItem.get(phones.get(i)));
       }

       return allPhones;
   }

   public <T> ArrayList <T> getItems(Class <T> type){
       if(type.equals(Book.class)){
           Book newBook = new Book();
           ArrayList<Integer> books = new ArrayList<>();

           for(int i = 0; i < cisItem.size(); i++){
               if(cisItem.get(i).getClass().equals(newBook.getClass())){
                   books.add(i);
               }
           }

           ArrayList<Book> allBooks = new ArrayList<>();

           for(int i = 0; i < books.size(); i++){
               allBooks.add((Book) cisItem.get(books.get(i)));
           }

           return (ArrayList<T>) allBooks;
       }
       if(type.equals(Magazine.class)){
           Magazine newMag = new Magazine();
           ArrayList<Integer> magazines = new ArrayList<>();

           for(int i = 0; i < cisItem.size(); i++){
               if(cisItem.get(i).getClass().equals(newMag.getClass())){
                   magazines.add(i);
               }
           }

           ArrayList<Magazine> allMags = new ArrayList<>();
           for(int i = 0; i < magazines.size(); i++){
               allMags.add((Magazine) cisItem.get(magazines.get(i)));
           }

           return (ArrayList<T>) allMags;
       }
       if(type.equals(Arduino.class)){
           Arduino newArduino = new Arduino();
           ArrayList<Integer> arduinos = new ArrayList<>();

           for(int i = 0; i < cisItem.size(); i++){
               if(cisItem.get(i).getClass().equals(newArduino.getClass())){
                   arduinos.add(i);
               }
           }

           ArrayList<Arduino> allArduino = new ArrayList<>();
           for(int i = 0; i < arduinos.size(); i++){
               allArduino.add((Arduino) cisItem.get(arduinos.get(i)));
           }

           return (ArrayList<T>) allArduino;
       }
       if(type.equals(Phone.class)){
           Phone newphone = new Phone();
           ArrayList<Integer> phones = new ArrayList<>();

           for(int i = 0; i < cisItem.size(); i++){
               if(cisItem.get(i).getClass().equals(newphone.getClass())){
                   phones.add(i);
               }
           }

           ArrayList<Phone> allPhones = new ArrayList<>();
           for(int i = 0; i < phones.size(); i++){
               allPhones.add((Phone) cisItem.get(phones.get(i)));
           }

           return (ArrayList<T>) allPhones;
       }
       else{
           System.out.println("Not valid object type");
           System.exit(0);
       }

       return null;
   }

   public void updateItems(String itemType, String property, String value){
       switch(property) {
           //all cisitems properties
           case "name":
               for (int i = 0; i < this.cisItem.size(); i++) {
                   cisItem.get(i).setName(value);
               }
               break;
           case "price":
               for (int i = 0; i < this.cisItem.size(); i++) {
                   cisItem.get(i).setPrice(Integer.parseInt(value));
               }
               break;
           case "location":
               for (int i = 0; i < this.cisItem.size(); i++) {
                   cisItem.get(i).setLocation(value);
               }
               break;
           case "description":
               for (int i = 0; i < this.cisItem.size(); i++) {
                   cisItem.get(i).setDescription(value);
               }
               break;
       }

       if(itemType.equals("Book")){
           //arduino specified arraylist
           ArrayList<Book> allBook = new ArrayList<>();
           for (int i = 0; i < this.cisItem.size(); i++) {
               if(cisItem.get(i).getClass().equals(Book.class)) {
                   allBook.add((Book) cisItem.get(i));
               }
           }

           //reading mat specific
           switch(property) {
               case "word count":
                   for (int i = 0; i < allBook.size(); i++) {
                       allBook.get(i).setWordCount(Integer.parseInt(value));
                   }
                   break;
               case "date published":
                   for (int i = 0; i < allBook.size(); i++) {
                       allBook.get(i).setDatePublished(value);
                   }
                   break;
                case "author":
                    for (int i = 0; i < allBook.size(); i++) {
                        allBook.get(i).setAuthor(value);
                    }
                    break;
            }

           //book specific
            switch(property){
                case "isbn":
                    for (int i = 0; i < allBook.size(); i++) {
                        allBook.get(i).setIsbn(value);
                    }
                case "edition":
                    for (int i = 0; i < allBook.size(); i++) {
                        allBook.get(i).setEdition(value);
                    }
                break;
                case "title":
                    for (int i = 0; i < allBook.size(); i++) {
                            allBook.get(i).setTitle(value);
                    }
                    break;
            }

           //updates all the books in cisItem
           int count = 0;
           for (int i = 0; i < this.cisItem.size(); i++) {
               if(cisItem.get(i).getClass().equals(Book.class)){
                   cisItem.set(count, allBook.get(count));
                   count ++;
               }
           }
       }

       if(itemType.equals("Magazine")){
           ArrayList<Magazine> allMagazine = new ArrayList<>();
           for (int i = 0; i < this.cisItem.size(); i++) {
               if(cisItem.get(i).getClass().equals(Magazine.class)) {
                   allMagazine.add((Magazine) cisItem.get(i));
               }
           }

           switch(property) {
               //reading mat specific
               case "word count":
                   for (int i = 0; i < allMagazine.size(); i++) {
                       allMagazine.get(i).setWordCount(Integer.parseInt(value));
                   }
                   break;
               case "date published":
                   for (int i = 0; i < allMagazine.size(); i++) {
                       allMagazine.get(i).setDatePublished(value);
                   }
                   break;
               case "author":
                   for (int i = 0; i < allMagazine.size(); i++) {
                       allMagazine.get(i).setAuthor(value);
                   }
                   break;
           }

           //magazine specific
           switch(property) {
               case "cover story title":
                   for (int i = 0; i < allMagazine.size(); i++) {
                       allMagazine.get(i).setCoverStoryTitle(value);
                   }
                   break;
               case "print date":
                   for (int i = 0; i < allMagazine.size(); i++) {
                        allMagazine.get(i).setPrintDate(value);
                   }
                   break;
           }

           //updates all the magazines in cisItem
           int count = 0;
           for (int i = 0; i < this.cisItem.size(); i++) {
               if(cisItem.get(i).getClass().equals(Magazine.class)){
                   cisItem.set(count, allMagazine.get(count));
                   count ++;
               }
           }
       }

       if(itemType.equals("Arduino")){
           //arduino specified arraylist
           ArrayList<Arduino> allArduino = new ArrayList<>();
           for (int i = 0; i < this.cisItem.size(); i++) {
               if(cisItem.get(i).getClass().equals(Arduino.class)) {
                   allArduino.add((Arduino) cisItem.get(i));
               }
           }

           //electronic items properties
           switch(property) {
               case "storage capacity":
                   for (int i = 0; i < allArduino.size(); i++) {
                           allArduino.get(i).setStorageCapacity(Integer.parseInt(value));
                   }
                   break;
               case "model":
                   for (int i = 0; i < allArduino.size(); i++) {
                           allArduino.get(i).setModel(value);
                   }
                   break;
               case "maker":
                   for (int i = 0; i < allArduino.size(); i++) {
                            allArduino.get(i).setMaker(value);
                   }
               case "operating system":
                   for (int i = 0; i < allArduino.size(); i++) {
                       allArduino.get(i).setOperatingSystem(value);
                   }
           }

           //arduino specific properties
           switch(property) {
               case "version":
                   for (int i = 0; i < allArduino.size(); i++) {
                            allArduino.get(i).setVersion(value);
                   }
                   break;
           }

           //updates all the arduinos in cisItem
           int count = 0;
           for (int i = 0; i < this.cisItem.size(); i++) {
               if(cisItem.get(i).getClass().equals(Arduino.class)){
                   cisItem.set(count, allArduino.get(count));
                   count ++;
               }
           }
       }

       if(itemType.equals("Phone")){
           //phone specified arraylist
           ArrayList<Phone> allPhone = new ArrayList<>();
           for (int i = 0; i < this.cisItem.size(); i++) {
               if(cisItem.get(i).getClass().equals(Phone.class)) {
                   allPhone.add((Phone) cisItem.get(i));
               }
           }

           //electronic items properties
           switch(property) {
               case "storage capacity":
                   for (int i = 0; i < allPhone.size(); i++) {
                       allPhone.get(i).setStorageCapacity(Integer.parseInt(value));
                   }
                   break;
               case "model":
                   for (int i = 0; i < allPhone.size(); i++) {
                       allPhone.get(i).setModel(value);
                   }
                   break;
               case "maker":
                   for (int i = 0; i < allPhone.size(); i++) {
                       allPhone.get(i).setMaker(value);
                   }
               case "operating system":
                   for (int i = 0; i < allPhone.size(); i++) {
                       allPhone.get(i).setOperatingSystem(value);
                   }
           }

           //phone specific properties
           switch(property) {
               case "network type":
                   for (int i = 0; i < allPhone.size(); i++) {
                       allPhone.get(i).setNetworkType(value);
                   }
                   break;
               case "screen size":
                   for (int i = 0; i < allPhone.size(); i++) {
                       allPhone.get(i).setScreenSize(Integer.parseInt(value));
                   }
                   break;
           }

           //updates all the phones in cisItem
           int count = 0;
           for (int i = 0; i < this.cisItem.size(); i++) {
               if(cisItem.get(i).getClass().equals(Phone.class)){
                   cisItem.set(count, allPhone.get(count));
                   count ++;
               }
           }
       }
   }

   public void showAllInfo(){
       //all cisitems properties
       for(CISItem c : cisItem) {

           String item = "\nName: " + c.getName() + ", ";
               item += "Price: $" + c.getPrice() + ", ";
               item += "Location: " + c.getLocation() + ", ";
               item += "Description: " + c.getDescription() + ", ";

           if (c.getClass().equals(Book.class)) {
               //reading mat specific
               item += "\n\n Book Specific Details: \n";
               item += "Reading Material Specific Details: \n";
               item += "Word Count: " + ((Book) c).getWordCount() + ", ";
               item += "Date Published: " + ((Book) c).getDatePublished() + ", ";
               item += "Author: " + ((Book) c).getAuthor() + ", ";


               //book specific
               item += "ISBN: " + ((Book) c).getIsbn() + ", ";
               item += "Edition: " + ((Book) c).getEdition() + ", ";
               item += "Title: " + ((Book) c).getTitle() + ", ";
           }

           if (c.getClass().equals(Magazine.class)) {
               //reading mat specific
               item += "\n\n Magazine Specific Details: \n";
               item += "Reading Material Specific Details: \n";
               item += "Word Count: " + ((Magazine) c).getWordCount() + ", ";
               item += "Date Published: " + ((Magazine) c).getDatePublished() + ", ";
               item += "Author: " + ((Magazine) c).getAuthor() + ", ";

               //magazine specific
               item += "Cover Story Title: " + ((Magazine) c).getCoverStoryTitle() + ", ";
               item += "Print Date: " + ((Magazine) c).getPrintDate() + ", ";
           }

           if (c.getClass().equals(Arduino.class)) {
               //electronic items properties
               item += "\n\n Arduino Specific Details: \n";
               item += "Electronic Item Specific Details: \n";
               item += "Storage Capacity: " + ((Arduino) c).getStorageCapacity() + ", ";
               item += "Model: " + ((Arduino) c).getModel() + ", ";
               item += "Maker: " + ((Arduino) c).getMaker() + ", ";
               item += "Operating System: " + ((Arduino) c).getOperatingSystem() + ", ";

               //arduino specific properties
               item += "Version: " + ((Arduino) c).getVersion() + ", ";
           }

           if (c.getClass().equals(Phone.class)) {
               //electronic items properties
               item += "\n\n Phone Specific Details: \n";
               item += "Electronic Item Specific Details: \n";
               item += "Storage Capacity: " + ((Phone) c).getStorageCapacity() + ", ";
               item += "Model: " + ((Phone) c).getModel() + ", ";
               item += "Maker: " + ((Phone) c).getMaker() + ", ";
               item += "Operating System: " + ((Phone) c).getOperatingSystem() + ", ";

               //phone specific properties
               item += "Network Type: " + ((Phone) c).getNetworkType() + ", ";
               item += "Screen Size: " + ((Phone) c).getScreenSize() + ", ";
           }

           System.out.println(item);
       }
   }

   public void addItems(CISItem cisItem){
       this.cisItem.add(cisItem);
   }

}