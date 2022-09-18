import java.util.*;

public class Court {
    int courtID;
    int totalCapacity;
    int currCapacity;
    List<List<String>> playerList;

    public Court (int courtID, int totalCapacity, int currCapacity, List<List<String>> playerList) {
        this.totalCapacity = totalCapacity;
        this.currCapacity = currCapacity;
        this.playerList = playerList;
        this.courtID = courtID;

    }
}
