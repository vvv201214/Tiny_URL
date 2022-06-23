package Main;

import java.util.*;

public class TinyUrlService {

    public void mainWork(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your URL : ");
        String userUrl = sc.nextLine();
        StringBuilder baseUrl = new StringBuilder("https://tiny-url.com");
        HashMap<String, Integer> hash = new HashMap<>(); // user + random
        HashMap<String, String> finalHash = new HashMap<>(); // tiny + user
        HashSet<Integer> hs = new HashSet<>();
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        hs.add(randomNumber);
        hash.put(userUrl, randomNumber);
        if (!hash.isEmpty()){
            if((hash.containsKey(userUrl))){
                String randomString =  "/" + Integer.toString(hash.get(userUrl));
                baseUrl.append(randomString);
                finalHash.put(baseUrl.toString(), userUrl);
            }
            else{
                while(hs.contains(randomNumber)){
                    randomNumber = random.nextInt(1000);
                }
                String randomString =  "/" + Integer.toString(hash.get(userUrl));
                baseUrl.append(randomString);
                finalHash.put(baseUrl.toString(), userUrl);
            }
        }
        System.out.print("Get your Tiny URL : ");
        System.out.println(baseUrl);
        System.out.println();
        System.out.print("Enter your tiny-url for redirecting : ");
        String getUrl = sc.nextLine();
        System.out.println();
        System.out.println("-------Backend Process---------");
        System.out.println();
        System.out.println("Redirecting this request as per your Tiny URL : ");
        if(finalHash.containsKey(getUrl)) {
            System.out.println(finalHash.get(baseUrl.toString()));
        }
        else{
            System.out.println("URL not found....");
        }
    }
}
