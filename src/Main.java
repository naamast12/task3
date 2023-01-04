import java.util.Scanner;

//O(n^2)
public class Main {
    //some change
    public static void main(String[] args) {
        final int CREATE_USER = 1;
        final int LOGIN = 2;
        final int EXIT = 3;
        final int ADVERTISING = 1;
        final int REMOVING = 2;
        final int VIEW_ALL = 3;
        final int VIEW_USER = 4;
        final int SEARCHING = 5;
        final int RETURN = 6;

        RealEstate realEstate = new RealEstate();
        Scanner scanner = new Scanner(System.in);
        boolean properChoose=true;
        boolean stop = true;
        while (stop) {
            do {
                System.out.println("");
                System.out.println("Are you interested: \n 1.Create an account \n 2.Connect to an existing account \n 3.End the program");
                int choose = scanner.nextInt();
                switch (choose){
                    case  CREATE_USER:
                    realEstate.createUser();
                        properChoose = false;
                    break;
                    case LOGIN:
                        User temp = realEstate.UserLogin();
                    if (temp == null) {
                        properChoose = false;
                        System.out.println("Non-existent username");
                    }
                    else
                    {
                        System.out.println("Are you interested: \n 1.Advertise a new property \n 2.Remove advertising about a property \n 3.View all properties in the system \n 4.View all properties published by you \n 5.Search for a property by parameters \n 6.Log out and return to the main menu");
                        int chooseTwo = scanner.nextInt();
                        switch (chooseTwo)
                        {
                            case ADVERTISING:
                                if (realEstate.postNewProperty(temp))
                                    System.out.println("The property has been preserved");
                                else
                                    System.out.println("Property not maintained");
                                    break;
                            case REMOVING:
                                realEstate.removeProperty(temp);
                                break;
                            case VIEW_ALL:
                                realEstate.printAllProperties();
                                break;
                            case VIEW_USER:
                                realEstate.printProperties(temp);
                                break;
                            case SEARCHING:
                                Property[] search = realEstate.search();
                                for (int i = 0 ; i < search.length ; i++) {
                                    System.out.println(search[i].toString());
                                }
                                break;
                            case RETURN:
                                break;
                            default:
                                System.out.println("Wrong choice");
                                break;
                        }
                    }
                        properChoose = false;
                    break;
                    case EXIT:
                    stop = false;
                    properChoose=true;
                    break;
                    default:
                    System.out.println("Wrong choice");
                    properChoose = false;
                    break;
                }
            } while (!properChoose);
        }
    }

}
