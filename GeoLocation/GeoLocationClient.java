//Gg Tran
//HW 8 Part B
//THis program creates GeoLocation objects
//and prints out their latitudes, longitudes as well as the distances 
//between the objects

public class GeoLocationClient {
   public static void main(String[] args) {
      GeoLocation stash = new GeoLocation(34.988889, -106.614444);
      GeoLocation studio = new GeoLocation(34.989978, -106.614357);
      GeoLocation fbi = new GeoLocation(35.131281, -106.61263);
      
      location("the stash", stash.toString());
      location("ABQ studio", studio.toString());
      location("FBI building", fbi.toString());
      
      System.out.println("distance in miles between:");
      System.out.println("    stash/studio = " + stash.distanceFrom(studio));
      System.out.println("    stash/fbi    = " + stash.distanceFrom(fbi));

   } 
   
   //Print out the name of the place and its coordinators (latitude and longtitude)
   public static void location(String place, String coordinate) {
      System.out.println(place + " is at " + coordinate);
   }
} 
   
   