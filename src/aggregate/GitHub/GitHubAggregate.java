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
import java.io.IOException;
import com.jcabi.github.Github;
import com.jcabi.github.RtGithub;
import com.jcabi.github.User;

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
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
//        String resultAPI = utils.internet.webget("https://api.github.com/users?since=1");
////       // System.out.println(test);
////        
//        Gson gson = new Gson();
//        GitHubUser[] users = gson.fromJson(resultAPI, GitHubUser[].class); 
//        for(GitHubUser user : users){
//            System.out.println(user.login);
//        }
       
        
        Github github = new RtGithub();
    Iterable<User> users = github.users().iterate("");
    for (User user : users) {
      System.out.println("login: " + user.login());
    }
        
    }
}
  
