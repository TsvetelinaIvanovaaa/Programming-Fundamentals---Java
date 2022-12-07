package FundamentalsFinalExam;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Map<String, Integer> followerLikesMap = new LinkedHashMap<>();
        Map<String, Integer> followerCommentsMap = new LinkedHashMap<>();

        String commandLine = scanner.nextLine();

        while(!commandLine.equals("Log out")){
            String[] tokens = commandLine.split(": ");
            String commandType = tokens[0];

            if(commandType.contains("New follower")){
                String username = tokens[1];
                if(!followerLikesMap.containsKey(username)){
                    followerLikesMap.put(username, 0);
                    followerCommentsMap.put(username, 0);
                }
            }else if(commandType.equals("Like")){
                String username = tokens[1];
                int countLikes = Integer.parseInt(tokens[2]);
                if(!followerLikesMap.containsKey(username)){
                    followerLikesMap.put(username, countLikes);
                    followerCommentsMap.put(username, 0);
                }else{
                    int currentCountLikes = followerLikesMap.get(username);
                    followerLikesMap.put(username, currentCountLikes + countLikes);
                }

            }else if(commandType.equals("Comment")){
                String username = tokens[1];
                if(!followerCommentsMap.containsKey(username)){
                    followerCommentsMap.put(username, 1);
                    followerLikesMap.put(username, 0);
                }else{
                    int currentCountComments = followerCommentsMap.get(username);
                    followerCommentsMap.put(username, currentCountComments + 1);
                }
            }else if(commandType.equals("Blocked")){
                String username = tokens[1];
                if(followerLikesMap.containsKey(username)){
                    followerLikesMap.remove(username);
                    followerCommentsMap.remove(username);
                }else{
                    System.out.printf("%s doesn't exist.%n",username);
                }

            }
            commandLine = scanner.nextLine();
        }
        System.out.printf("%d followers%n",followerCommentsMap.size());
        for (Map.Entry<String, Integer> entry : followerCommentsMap.entrySet()) {
            String currentUser = entry.getKey();
            int sumLikeComments = entry.getValue() + followerLikesMap.get(currentUser);
            System.out.printf("%s: %d%n",entry.getKey(), sumLikeComments);
        }

    }
}
