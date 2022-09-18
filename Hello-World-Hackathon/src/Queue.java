import java.util.*;

public class Queue {

    public static List<List<String>>  findGroup(List<List<String>> q, int groupRequest) {
        // q is formatted as such:
        // [userID, number of members in group]

        //Stores group members currently in group
        List<List<String>> currGroup = new ArrayList<>();

        //Tracks if a member that can be removed from the queue was found
        boolean found = true;

        //Tracks members to be removed from q
        List<List<String>> toRemove = new ArrayList<>();

        while (found) {
            //Every for loop must find a new user, else break
            found = false;

            //Checks if queue is empty
            if (q.size() == 0)
                return currGroup;

            for (List<String> i : q) {
                // If a value is found, flip found
                if (Integer.parseInt(i.get(1)) < groupRequest) {
                    groupRequest -= Integer.parseInt(i.get(1));
                    currGroup.add(i);
                    toRemove.add(i);
                    found = true;

                //If value is equal to the remaining amount, break
                } else if (Integer.parseInt(i.get(1)) == groupRequest) {
                    groupRequest = 0;
                    currGroup.add(i);

                    //Ensures while break, even though it is true
                    found = false;
                    break;

                }
            }
            //Removes all items from q after the end of a for loop
            q.removeAll(toRemove);
        }

        return currGroup;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Initializes Queue
        List<List<String>> q = new ArrayList<>();

        //In the future this should be replaced by user input from server files
        System.out.println("Enter number of members in queue");
        int queueSize = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < queueSize; i++) {
            System.out.println((i + 1) + ". Enter member ID and group size");
            String[] temp = scan.nextLine().split("\\s+");
            String userID = temp[0];
            String groupSize = temp[1];
            q.add(Arrays.asList(userID, groupSize));
        }

        //In the future this should call the list of all courts
        List<Court> courts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<List<String>> temp_l = new ArrayList<>();
            courts.add(new Court(i+1, 10, 0, temp_l ));

        }
        //Sort the courts by player availability -- Reverse Bubble sort
        for (int i = 0; i < courts.size(); i++) {
            for (int j = i; j < courts.size(); j++) {
                int c1 = courts.get(i).totalCapacity - courts.get(i).currCapacity;
                int c2 = courts.get(j).totalCapacity - courts.get(j).currCapacity;

                if (c1 < c2) {
                    Court temp = courts.get(i);
                    courts.set(i, courts.get(j));
                    courts.set(j, temp);
                }
            }
        }

        //If player availability > 0, request more players from queue
        for (Court i : courts) {
            int availability = i.totalCapacity - i.currCapacity;

            // If availability = 0, all subsequent availabilities will be 0.
            // If q size is 0, no more users are in queue
            if (availability == 0 || q.size() == 0) {
                break;
            } else {
                List<List<String>> playerChange;

                //Calls findGroup function to
                playerChange = findGroup(q, availability);
                q.removeAll(playerChange);
                i.playerList.addAll(0, playerChange);

            }
        }

        for (Court i : courts) {
            System.out.println(i.courtID);
            System.out.println(i.playerList);
            System.out.printf("\n");
        }
    }
}
