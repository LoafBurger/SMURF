import java.util.*;

public class Queue {

    public static List<List<Integer>>  findGroup(List<List<Integer>> q, int groupRequest) {
        // q is formatted as such:
        // [userID, number of members in group]

        //Stores group members currently in group
        List<List<Integer>> currGroup = new ArrayList<>();

        //Tracks if a member that can be removed from the queue was found
        boolean found = true;

        while (found == true) {
            //Every for loop must find a new user, else break
            found = false;

            for (List<Integer> i : q) {
                // If a value is found, flip found
                if (i.get(1) < groupRequest) {
                    groupRequest -= i.get(1);
                    currGroup.add(i);
                    found = true;

                } else if (i.get(1) == groupRequest) {
                    groupRequest = 0;
                    currGroup.add(i);

                    //Ensures while break, even though it is true
                    found = false;
                    break;
                }
            }
        }

        return currGroup;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<List<Integer>> q = new ArrayList<>();

        System.out.println("Enter Group Request Size");
        int groupRequest = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter number of members in queue");
        int queueSize = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < queueSize; i++) {
            System.out.println((i+1) + ". Enter member ID and group size");
            int userID = scan.nextInt();
            int groupSize = scan.nextInt();
            q.add(Arrays.asList(userID, groupSize));
        }

        List<List<Integer>> ans =  findGroup(q, groupRequest);

        System.out.println("Remove from queue:");
        for (List<Integer> i : ans)
            System.out.println(i);

    }
}
