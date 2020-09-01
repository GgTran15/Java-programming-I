//Gg Tran  
//The PlaceInformation class stores information about a place
//Including its name, address, tag, location. The class's methods return
//each piece of information, and compute the distance between the place 
//and another spot


public class PlaceInformation {
   private String name;
   private String address;
   private String tag;
   private GeoLocation location;
   
   //Construct the PlaceInformation object to store information about a place
   //such as its name, address, tag, and location
   public PlaceInformation(String name, String address, String tag,
                        double latitude, double longitude) {
      this.name = name;
      this.address = address;
      this.tag = tag;
      this.location = new GeoLocation(latitude, longitude);
   }
   
   //Return the name of the location                     
   public String getName() {
      return this.name;
   }
   
   //Return the address of the place
   public String getAddress() {
      return this.address;
   }
   
   //Return the tag of the place
   public String getTag() {
      return this.tag;
   }
   
   //Return the name and the adress of the place
   public String toString() {
      return this.getName() + " (" + this.getLocation() + ")" ;
   }
   
   //Return the location of the place
   public GeoLocation getLocation() {
      return this.location;
   }
   
   //Return the distance between the place and another spot 
   //Using the distanceMethod from the GeoLocation class
   public double distanceFrom(GeoLocation spot) {
      return this.location.distanceFrom(spot);
   }
}