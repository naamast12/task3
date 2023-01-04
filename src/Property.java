public class Property {

    private final City THE_CITY;
    private final String STREET;
    private final int NUMBER_OF_ROOM;
    private final int PRICE;
    private final int TYPE;
    private final int IS_FOR_RENT_OR_SALE;
    private final int HOUSE_NUMBER;
    private final int FLOOR_NUMBER;
    private final User POSTED_USER;

    //O(1)
    public Property(City theCity,String street, int numberOfRoom, int price, int type, int isItForRentOrSale, int houseNumber, int floorNumber, User postedUser)
    {
        this.THE_CITY = theCity;
        this.STREET = street;
        this.NUMBER_OF_ROOM = numberOfRoom;
        this.PRICE = price;
        this.TYPE = type;
        this.IS_FOR_RENT_OR_SALE = isItForRentOrSale;
        this.HOUSE_NUMBER = houseNumber;
        this.FLOOR_NUMBER = floorNumber;
        this.POSTED_USER = postedUser;
    }

    //O(1)
    public City getTheCity()
    {
       return THE_CITY;
    }
    //O(1)
    public String getStreet()
    {
        return STREET;
    }
    //O(1)
    public int getNumberOfRoom() {return NUMBER_OF_ROOM;}
    //O(1)
    public int getPrice() {return PRICE;}
    //O(1)
    public int getType() {return TYPE;}
    //O(1)
    public int getIsItForRentOrSale() {return IS_FOR_RENT_OR_SALE;}
    //O(1)
    public int getHouseNumber() {return HOUSE_NUMBER;}
    //O(1)
    public int getFloorNumber() {return FLOOR_NUMBER;}
    //O(1)
    public User getPostedUser() {return POSTED_USER;}
    //O(1)
    public String toString()
    {
        String houseType ;
        String floorNumber;
        String rentOrSale;

        if (this.TYPE == 1) {
            houseType = "ordinary apartment";
            floorNumber = ", floor " + getFloorNumber();
        }
        else if (this.TYPE == 2) {
            houseType = "penthouse apartment";
            floorNumber = ", floor " + getFloorNumber();
        }
        else {
            houseType = "private house";
            floorNumber = "";
        }
        if (this.IS_FOR_RENT_OR_SALE==1)
            rentOrSale = "for rent";
        else rentOrSale = "for sale";


        return this.THE_CITY+ this.STREET+" " + this.HOUSE_NUMBER + ".\n"+ houseType + "-"+rentOrSale+":" + this.NUMBER_OF_ROOM
                +" rooms" + floorNumber + ".\nprice:" +this.PRICE +"$ .\n"+ "contact info: "+ this.POSTED_USER;
    }
}
