import java.util.Scanner;

public class RealEstate {

    private User[] users;
    private Property[] properties = new Property[0];
    private City[] cities = new City[10];
    //O(1)
    public RealEstate() {
        String[] arrayCities = {"Eilat", "Beer Sheva", "Ashkelon", "Tel Aviv", "Jerusalem", "Haifa", "Ashdod", "Tiberias", "Herzelia", "Hedera"};
        String[] arrayGeographicDistrict = {"south", "north", "center", "negev", "sharon"};

        for (int i = 0; i < arrayCities.length; i++) {
            if (arrayCities[i].equals("Ashkelon")) {
                String[] ashkelonStreets = {"Jabotinsky", "Ben Gurion", "Bialik"};
                this.cities[i] = new City(arrayCities[i], arrayGeographicDistrict[0], ashkelonStreets);
            }
            if (arrayCities[i].equals("Ashdod")) {
                String[] asdodStreets = {"Bialik", "Harav Kook", "Ben Yehuda", "Rothschild"};
                this.cities[i] = new City(arrayCities[i], arrayGeographicDistrict[0], asdodStreets);
            }
            if (arrayCities[i].equals("Eilat")) {
                String[] eilatStreets = {"Harav Kook", "Rothschild", "Ben Gurion", "Bialik"};
                this.cities[i] = new City(arrayCities[i], arrayGeographicDistrict[3], eilatStreets);
            }
            if (arrayCities[i].equals("Beer Sheva")) {
                String[] beerShevaStreets = {"Almog", "Leshem", "Hatsav", "Hadekel", "Harimon"};
                this.cities[i] = new City(arrayCities[i], arrayGeographicDistrict[3], beerShevaStreets);
            }
            if (arrayCities[i].equals("Tel Aviv")) {
                String[] telAvivStreets = {"Hatamar", "Hadekel", "Harimon"};
                this.cities[i] = new City(arrayCities[i], arrayGeographicDistrict[2], telAvivStreets);
            }
            if (arrayCities[i].equals("Jerusalem")) {
                String[] jerusalemStreets = {"Jaffש", "Nablus Road", "Hebron road", "Derech Bethlehem", "Jericho Road"};
                this.cities[i] = new City(arrayCities[i], arrayGeographicDistrict[2], jerusalemStreets);
            }
            if (arrayCities[i].equals("Herzelia")) {
                String[] herzeliaStreets = {"Hatamar", "Hadekel", "Harimon", "Hazait"};
                this.cities[i] = new City(arrayCities[i], arrayGeographicDistrict[4], herzeliaStreets);
            }
            if (arrayCities[i].equals("Hedera")) {
                String[] hederaStreets = {"Bialik", "Harav Kook", "Ben Yehuda"};
                this.cities[i] = new City(arrayCities[i], arrayGeographicDistrict[4], hederaStreets);
            }
            if (arrayCities[i].equals("Haifa")) {
                String[] haifaStreets = {"Hatamar", "Hadekel", "Harimon", "Harav Kook", "Ben Yehuda"};
                this.cities[i] = new City(arrayCities[i], arrayGeographicDistrict[1], haifaStreets);
            }
            if (arrayCities[i].equals("Tiberias")) {
                String[] tiberiasStreets = {"Hatamar", "Ben Yehuda", "Harimon"};
                this.cities[i] = new City(arrayCities[i], arrayGeographicDistrict[1], tiberiasStreets);
            }
        }
    }

    //O(1)
    public User[] getUsers() {
        return users;
    }

    //O(1)
    public City[] getCities() {
        return cities;
    }

    //O(n^2)
    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        boolean existName = false;
        String userName;
        do {
            System.out.println("enter user name");
            userName = scanner.nextLine();
            if (this.users != null)
                for (int i = 0; i < users.length; i++) {
                    if (users[i].getUserName().equals(userName)) {
                        existName = true;
                        System.out.println("This username is taken");
                        break;
                    }
                }
        } while (existName);

        boolean properPassword = false;
        String password;
        do {
            System.out.println("Enter a strong password");
            password = scanner.nextLine();
            if (password.length() >= 5)
                for (int w = 0; w < password.length(); w++) {
                    if (password.charAt(w) == '%' || password.charAt(w) == '$' || password.charAt(w) == '_') {
                        properPassword = true;
                        break;
                    }
                }
            if (!properPassword)
                System.out.println("The password is not strong(At least 5 label lengths contain at least 1 digit and at least one character:$,% or _");
        } while (!properPassword);

        boolean properPhoneNumber = true;
        String phoneNumber;
        do {
            properPhoneNumber = true;
            System.out.println("enter your phone number");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.length() != 10 || phoneNumber.charAt(0) != '0' || phoneNumber.charAt(1) != '5') {
                System.out.println("Invalid phone number");
                properPhoneNumber = false;
            } else
                for (int x = 0; x < phoneNumber.length(); x++)
                    if (!Character.isDigit(phoneNumber.charAt(x))) {
                        properPhoneNumber = false;
                        System.out.println("Invalid phone number");
                        break;
                    }

        } while (!properPhoneNumber);

        int theJob = 0;
        String intermediaryOrOrdinaryUser;
        do {
            System.out.println(" Are you a intermediary or a regular user");
            intermediaryOrOrdinaryUser = scanner.nextLine();
            if (intermediaryOrOrdinaryUser.equals("intermediary"))
                theJob = 1;
            else {
                if (intermediaryOrOrdinaryUser.equals("regular user"))
                    theJob = 2;
                else System.out.println("Improper job");
            }
        } while (theJob == 0);
        User newUser = new User(userName, password, phoneNumber, intermediaryOrOrdinaryUser);
        if (this.users != null) {
            User[] addUsers = new User[this.users.length + 1];
            for (int i = 0; i < this.users.length; i++) {
                addUsers[i] = this.users[i];
            }
            addUsers[this.users.length] = newUser;
            this.users = addUsers;
        } else {
            this.users = new User[1];
            this.users[0] = newUser;
        }
        System.out.println("Account created");
    }

    //O(n)
    public User UserLogin() {
        Scanner scanner = new Scanner(System.in);
        String enterUserName;
        String enterPassword;
        User theUser = null;
        System.out.println("Enter user name");
        enterUserName = scanner.nextLine();
        System.out.println("Enter password");
        enterPassword = scanner.nextLine();
        if (this.users != null)
            for (int i = 0; i < this.users.length; i++)
                if (this.users[i].getUserName().equals(enterUserName) && this.users[i].getPassword().equals(enterPassword)) {
                    theUser = this.users[i];
                    break;
                }
        return theUser;
    }

    //O(n)
    public boolean postNewProperty(User user) {
        Scanner scanner = new Scanner(System.in);
        boolean allowedAndExist = true;
        int count = 0;
        for (int i = 0; i < this.properties.length; i++)
            if (this.properties[i].getPostedUser().getUserName().equals(user.getUserName()))
                count++;
        if (user.getIntermediaryOrOrdinaryUser().equals("intermediary") && count == 5)
            allowedAndExist = false;
        else if (user.getIntermediaryOrOrdinaryUser().equals("regular user") && count == 2)
            allowedAndExist = false;
        if (!allowedAndExist) System.out.println("You can no longer advertise a property you have exceeded the limit");
        else {
            boolean existCity = false;
            int indexCity = 0;
            System.out.println("Select one of the cities in the list:");
            for (int i = 0; i < this.cities.length; i++)
                System.out.println(this.cities[i].getCityName());
            String cityChoose = scanner.nextLine();
            for (int w = 0; w < this.cities.length; w++)
                if (this.cities[w].getCityName().equals(cityChoose)) {
                    indexCity = w;
                    existCity = true;
                    break;
                }
            if (!existCity) {
                System.out.println("This city is not on the list");
                allowedAndExist = false;
            } else {
                boolean existStreet = false;
                String[] streetsCityChoose = this.cities[indexCity].getStreets();
                System.out.println("Select a street from this list:");
                for (int i = 0; i < streetsCityChoose.length; i++)
                    System.out.println(streetsCityChoose[i]);
                String streetChoose = scanner.nextLine();
                for (int i = 0; i < streetsCityChoose.length; i++) {
                    if (streetsCityChoose[i].equals(streetChoose)) {
                        existStreet = true;
                        break;
                    }
                }
                if (!existStreet) {
                    allowedAndExist = false;
                    System.out.println("This street is not on the list");
                } else {
                    System.out.println("What is the type of property?: \n 1.Ordinary apartment in an apartment building \n 2.Penthouse apartment in an apartment building \n 3.Private House");
                    int typeProperty = scanner.nextInt();
                    if (typeProperty == 1 || typeProperty == 2 || typeProperty == 3) {
                        int floorProperty = 0;
                        if (typeProperty != 3) {
                            System.out.println("On what floor is the property");
                            floorProperty = scanner.nextInt();
                        }
                        System.out.println("How many rooms does the property have?");
                        int roomNumber = scanner.nextInt();
                        System.out.println("What is the property number?");
                        int propertyNumber = scanner.nextInt();
                        boolean properChoose = false;
                        int rentOrSale;
                        do {
                            System.out.println("Is the property for: \n 1.rent  \n 2.sale?");
                            rentOrSale = scanner.nextInt();
                            if (rentOrSale == 1 || rentOrSale == 2)
                                properChoose = true;
                        } while (!properChoose);
                        System.out.println("What is the required price for the property?");
                        int priceProperty = scanner.nextInt();
                        Property newProperty = new Property(this.cities[indexCity], streetChoose, roomNumber, priceProperty, typeProperty, rentOrSale, propertyNumber, floorProperty, user);
                        Property[] addProperty = new Property[this.properties.length + 1];
                        for (int i = 0; i < this.properties.length; i++) {
                            addProperty[i] = this.properties[i];
                        }
                        addProperty[this.properties.length] = newProperty;
                        this.properties = addProperty;
                    } else {
                        allowedAndExist = false;
                        System.out.println("This option does not exist");
                    }
                }
            }
        }
        return allowedAndExist;
    }

    //O(n)
    public void removeProperty(User user) {
        Scanner scanner = new Scanner(System.in);
        int amountProperties = 0;
        boolean existProperty = false;
        for (int i = 0; i < this.properties.length; i++)
            if (this.properties[i].getPostedUser().getUserName().equals(user.getUserName())) {
                existProperty = true;
                break;
            }
        if (!existProperty)
            System.out.println("You haven't advertised any properties so far");
        else {
            System.out.println("The assets you have advertised:");
            for (int i = 0; i < this.properties.length; i++)
                if (this.properties[i].getPostedUser().getUserName().equals(user.getUserName())) {
                    amountProperties++;
                    System.out.println(amountProperties + ":\n" + this.properties[i].toString());
                }
            amountProperties = 0;
            System.out.println("Which asset would you like to remove?");
            int removeNumberChoose = scanner.nextInt();
            Property[] lessProperty = new Property[this.properties.length - 1];
            boolean removePlace = false;
            for (int i = 0; i < this.properties.length; i++) {
                if (this.properties[i].getPostedUser().getUserName().equals(user.getUserName()))
                    amountProperties++;
                if (removeNumberChoose == amountProperties)
                    removePlace = true;
                if (removePlace == false)
                    lessProperty[i] = this.properties[i];
                else if (i != 0)
                    lessProperty[i - 1] = this.properties[i];
            }
            this.properties = lessProperty;
            System.out.println("Property removed");
        }
    }

    //O(n)
    public void printAllProperties() {
        boolean existUserProperty = false;
        if (this.properties.length == 0)
            System.out.println("No assets in the system");
        else
            for (int i = 0; i < this.properties.length; i++)
                System.out.println("List of assets in the system: \n" + this.properties[i].toString());
    }

    //O(n)
    public void printProperties(User user) {
        int amountProperties = 0;
        boolean existProperty = false;
        for (int i = 0; i < this.properties.length; i++)
            if (this.properties[i].getPostedUser().getUserName().equals(user.getUserName())) {
                existProperty = true;
                break;
            }
        if (!existProperty)
            System.out.println("You haven't advertised any properties so far");
        else {
            System.out.println("The assets you have advertised: ");
            for (int i = 0; i < this.properties.length; i++)
                if (this.properties[i].getPostedUser().getUserName().equals(user.getUserName())) {
                    amountProperties++;
                    System.out.println(amountProperties + ":\n" + this.properties[i].toString());
                }
        }
    }

    //O(n)
    public Property[] search()
    {
        Scanner scanner = new Scanner(System.in);
        if (this.properties.length==0) {
            System.out.println("No assets in the system");
            Property[] empty = new Property[0];
            return empty;
        }
        System.out.println("Do: \n1. For rent  \n2. For sale");
        int searchRentOrSale = scanner.nextInt();
        System.out.println("What is the type of property?:\n 1.Ordinary apartment in an apartment building \n 2.Penthouse apartment in an apartment building \n 3.Private House");
        int searchType = scanner.nextInt();
        System.out.println("What is the desired number of rooms");
        int searchRoomNumber = scanner.nextInt();
        System.out.println("What is the desired price range? \nmin:");
        int searchMinPrice = scanner.nextInt();
        System.out.println("max:");
        int searchMaxPrice = scanner.nextInt();
        Property[] tempSearchProperty = new Property[this.properties.length];
        int indexTempProperty = 0;
        for (int i = 0 ; i < this.properties.length ; i++)
            if ((this.properties[i].getIsItForRentOrSale()==searchRentOrSale||searchRentOrSale==-999)&&(this.properties[i].getType()==searchType||searchType==-999)&& (this.properties[i].getNumberOfRoom()==searchRoomNumber||searchRoomNumber==-999)&&
                    ((this.properties[i].getPrice()>=searchMinPrice&&this.properties[i].getPrice()<=searchMaxPrice)||(this.properties[i].getPrice()>=searchMinPrice&&searchMaxPrice==-999)||(this.properties[i].getPrice()<=searchMaxPrice&&searchMinPrice==-999)))
            {
                tempSearchProperty[indexTempProperty] = this.properties[i];
                indexTempProperty++;
            }
        Property[] searchProperty = new Property[indexTempProperty];
        if (indexTempProperty==0) {
            System.out.println("No property is suitable for these requirements");
        }
        else{
            for (int i = 0; i < searchProperty.length; i++) {
                searchProperty[i] = tempSearchProperty[i];
            }
        }
        return searchProperty;
    }
}
