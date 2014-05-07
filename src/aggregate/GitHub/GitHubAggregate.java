/**
 * SPDXVersion: SPDX-1.1 
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de) 
 * Created: 2014-05-06T00:00:00Z 
 * LicenseName: EUPL-1.1-without-appendix 
 * FileName: CollectGitHub.java 
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Uses the GitHub API to collect data from
 * the Internet repository</text>
 */

package aggregate.GitHub;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import main.core;
import static main.core.getWorkFolder;


/**
 *
 * @author Nuno Brito, 6th of May 2014 in Darmstadt, Germany
 */
public class GitHubAggregate {
/**
 * Documentation about the API:
 * https://developer.github.com/v3/users/#get-all-users
 * 
 * Example:
 * https://api.github.com/users?since=135
 * 
 */
    
   
    int throttle = 5;
    
    
    
        static String test = "[\n" +
"  {\n" +
"    \"login\": \"ged\",\n" +
"    \"id\": 13501,\n" +
"    \"avatar_url\": \"https://avatars.githubusercontent.com/u/13501?\",\n" +
"    \"gravatar_id\": \"04cdb622ce0aac272b61f23f373e2abf\",\n" +
"    \"url\": \"https://api.github.com/users/ged\",\n" +
"    \"html_url\": \"https://github.com/ged\",\n" +
"    \"followers_url\": \"https://api.github.com/users/ged/followers\",\n" +
"    \"following_url\": \"https://api.github.com/users/ged/following{/other_user}\",\n" +
"    \"gists_url\": \"https://api.github.com/users/ged/gists{/gist_id}\",\n" +
"    \"starred_url\": \"https://api.github.com/users/ged/starred{/owner}{/repo}\",\n" +
"    \"subscriptions_url\": \"https://api.github.com/users/ged/subscriptions\",\n" +
"    \"organizations_url\": \"https://api.github.com/users/ged/orgs\",\n" +
"    \"repos_url\": \"https://api.github.com/users/ged/repos\",\n" +
"    \"events_url\": \"https://api.github.com/users/ged/events{/privacy}\",\n" +
"    \"received_events_url\": \"https://api.github.com/users/ged/received_events\",\n" +
"    \"type\": \"User\",\n" +
"    \"site_admin\": false\n" +
"  },\n" +
"  {\n" +
"    \"login\": \"esmil\",\n" +
"    \"id\": 13502,\n" +
"    \"avatar_url\": \"https://avatars.githubusercontent.com/u/13502?\",\n" +
"    \"gravatar_id\": \"caee99686781bdf27499d0be4b92019b\",\n" +
"    \"url\": \"https://api.github.com/users/esmil\",\n" +
"    \"html_url\": \"https://github.com/esmil\",\n" +
"    \"followers_url\": \"https://api.github.com/users/esmil/followers\",\n" +
"    \"following_url\": \"https://api.github.com/users/esmil/following{/other_user}\",\n" +
"    \"gists_url\": \"https://api.github.com/users/esmil/gists{/gist_id}\",\n" +
"    \"starred_url\": \"https://api.github.com/users/esmil/starred{/owner}{/repo}\",\n" +
"    \"subscriptions_url\": \"https://api.github.com/users/esmil/subscriptions\",\n" +
"    \"organizations_url\": \"https://api.github.com/users/esmil/orgs\",\n" +
"    \"repos_url\": \"https://api.github.com/users/esmil/repos\",\n" +
"    \"events_url\": \"https://api.github.com/users/esmil/events{/privacy}\",\n" +
"    \"received_events_url\": \"https://api.github.com/users/esmil/received_events\",\n" +
"    \"type\": \"User\",\n" +
"    \"site_admin\": false\n" +
"  }\n" +
"]";
    
        
    /**
     * Gets a given number of users from the Github site
     * @param since
     * @return 
     */    
    public GithubUser[] getUsers(int since){
        String resultAPI = utils.internet.webget("https://api.github.com/users?since="
                + since);
        Gson gson = new Gson();
        return gson.fromJson(resultAPI, GithubUser[].class); 
    }    
        
    /**
     * Save the user data to disk
     * @param user      The user object
     * @param folder    Where the file will be written
     */
    public void saveToDisk(GithubUser user, File folder){
       // enable pretty printing
       Gson gson = new GsonBuilder().setPrettyPrinting().create();
       String text = gson.toJson(user);
       // create the filename
       String fileString = user.id + "-" + user.login;
       File file = new File(folder, fileString);
       // save the file to disk
        utils.files.SaveStringToFile(file, text);
       //System.out.println(file.getAbsolutePath());
       // all done
       System.out.println("Saved: " + fileString);
    }
    
    
    /**
     * Gets the folder where misc settings are placed
     * @return The folder from where the main application is running
     */
    public static File getFolder(){
        File result = new File(core.getMiscFolder(), "github");
        // if the folder doesn't exist, create one
        if(result.exists() == false){
            utils.files.mkdirs(result);
        }
        return result;
    }
    /**
     * Creates the list of users at Github
     */
    public void buildList(){
        File folder = getFolder();
        int counter = 0;
        
        // avoid starting from 0
        ArrayList<File> files = utils.files.findFiles(folder);
        if(files.size() > 0){
            counter = files.size();
        }
        
        // main loop
        while(counter < 20){
            GithubUser[] users = getUsers(counter);
            // iterate all users
            for(GithubUser user : users){
                saveToDisk(user, folder);
                counter++;
            }
            // wait some time to respect rate limit
            utils.time.wait(throttle);
            
        }
        
        
    }
        
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{

        GitHubAggregate github = new GitHubAggregate();
            
        github.buildList();
//        // get users
//        GithubUser[] users = github.getUsers(1);
//        // iterate all users       
//        for(GithubUser user : users){
//            System.out.println(user.login);
//        }
      
    }
}
  
