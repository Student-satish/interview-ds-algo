import java.util.*;
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // direction map
        HashMap<String, HashMap<Integer, String>> map = new HashMap<>();
        map.put("east", new HashMap<>());
        map.put("west", new HashMap<>());
        map.put("north", new HashMap<>());
        map.put("south", new HashMap<>());
        map.get("east").put(-1, "south");
        map.get("east").put(-2, "north");
        map.get("west").put(-1, "north");
        map.get("west").put(-2, "south");
        map.get("north").put(-1, "east");
        map.get("north").put(-2, "west");
        map.get("south").put(-1, "west");
        map.get("south").put(-2, "east");
        // store all obstacles in the form of string in a set
        HashSet<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            int x = obstacle[0];
            int y = obstacle[1];
            set.add(x+","+y);
        }

        int x = 0, y = 0;
        int maxDistance = 0;
        String dir = "north";

        for (int val : commands) {
            // if val is -1 or -2 change direction
            if (val == -1 || val == -2) {
                dir = map.get(dir).get(val);
                continue;
            }
            // move one step at a time and check if there is any obstacle
            for (int j = 0; j < val; j++) {
                if (dir.equals("east")) {
                    x++;
                } else if (dir.equals("west")) {
                    x--;
                } else if (dir.equals("north")) {
                    y++;
                } else {
                    y--;
                }
                // if there is any obstacle move to previous location
                if (set.contains(x+","+y)) {
                    if (dir.equals("east")) {
                        x--;
                    } else if (dir.equals("west")) {
                        x++;
                    } else if (dir.equals("north")) {
                        y--;
                    } else {
                        y++;
                    }
                    break;
                }
                // update maximum distance from origin
                maxDistance = Math.max(maxDistance, x * x + y * y);
            }
        }

        return maxDistance;
    }
}