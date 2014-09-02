package definitions;

/*
 * Provides static definitions that we can use in other classes
 */


/**
 *
 * @author Nuno Brito, 7th of December 2012 in Darmstadt, Germany.
 */
public class is {
    final public static String
            defaultIcon = "validation3check.png",
            plugin = "Plugin",
            extension = "FileExtension",
            trigger = "Trigger",
            license = "License",
            methodStartUp = "startup",
            script = "script",
            project = "project",
            settings = "settings",
            folderSPDX = "folderSPDX",
            library = "library",
            reports = "reports",
            textStart = "<text>",
            textEnd = "</text>",
            iconFolder = "icons",
            contentHTML = "text/html",
            contentText = "text/plain",
            methodDefault = "main",
            methodExecute = "x",
            ID = "id",
            
            // define immutable strings to speed up processing in scale
            tagFileName = "FileName:",
            tagFileType = "FileType:",
            tagFileChecksum = "FileChecksum:",
            tagFileChecksumSHA1 = "SHA1:",
            tagFileChecksumSHA256 = "SHA256:",
            tagFileChecksumMD5 = "MD5:",
            tagFileChecksumSSDEEP = "SSDEEP:",
            tagFileLOC = "FileLOC:",
            tagFileSize = "FileSize:",
            tagLicenseInfoInFile = "LicenseInfoInFile:",
            tagFileCopyrightText = "FileCopyrightText:",
            tagLicenseConcluded = "FileLicenseConcluded:",
            tagFileOrigin = "FileOrigin:",
            tagFileComponent = "ArtifactOfProjectName:",

            valueSource =  "SOURCE",
            valueBinary =  "BINARY",
            valueArchive = "ARCHIVE",
            valueOther =   "OTHER",
    
            textFinal = "</text>",
            
            lineBreak = "\n",
            space = " ";
            
    
      public final static int
              intSource = valueSource.hashCode();
            
    
    // related to processes
        public final static int
                
                // things we really need
                COMMAND = 1000,
                HOOK = 1001,
                
                
        // related to processes
            MAINTENANCE = 4,
            LISTENING = 3,
            RUNNING = 2,
            ACTIVE = 2,
            STARTING = 1,
            SUSPENDED = 1,
            PAUSED = 1,
            INACTIVE = 0,
            STOPPED = 0,
            ERROR = -1,
            FAILED = -5,
     // related to log entry types
            INFO = 30,
            DEBUG = 31,
            EXTRA = 32,
            ROUTINE = 33,
            WARNING = 34,
            CREDITS = 35,    
            ABORTED = 36,
            //ERROR = 30, defined previously, no problem in using the same
            
     // related to messages
            COMPLETED = 20,
            ACCEPTED = 10,
            FORGET = 6,
            PENDING = 5,
            EXPIRED = 4,
            IGNORED = 3,
            TIMEOUT = -10,
            REFUSED = -2,
            CONFLICT = -3,
            INVALID = -4,

       // ongoing actions (all things that end at "ing")         
            ADDING = 500,    
            REMOVING = 501,    
            INSTALLING = 502,
            FIXING = 503,    
            DELETING = 504,
            COPYING = 505,
            CREATING = 506,    
            EXTRACTING = 507,    
            OPENING = 508, 
            CLOSING = 509,    
                
       // related to status commands
            START = 100,
            RESUME = 103,
            CLOSE = 104,
        
        // web like
            NOTFOUND = 404,
            TEST = 311;
   
        
        
        public static String doubleClick = "doubleclick";
        
   
            
    
          /**
     * Provide a textual representation of our system status value
     * @param status
     * @return 
     */
    public static String translateStatus(String status){
        return translated(Integer.parseInt(status));
    }
    public static String translated(int status){

        String s;

        switch (status) {
            
            case is.ADDING: s =  "ADDING"; break;    
            case is.REMOVING: s =  "REMOVING"; break;    
            case is.INSTALLING: s =  "INSTALLING"; break;
            case is.FIXING: s =  "FIXING"; break;    
            case is.DELETING: s =  "DELETING"; break;
            case is.COPYING: s =  "COPYING"; break;
            case is.CREATING: s =  "CREATING"; break;  
            case is.EXTRACTING: s =  "EXTRACTING"; break;  
            case is.OPENING: s =  "OPENING"; break;  
            case is.CLOSING: s =  "CLOSING"; break;  
            
            case is.COMPLETED:
                s = "COMPLETED";
                break;
            case is.PENDING:
                s = "PENDING";
                break;
            case is.NOTFOUND:
                s = "NOT FOUND";
                break;
            case is.COMMAND:
                s = "COMMAND";
                break;
            case is.EXPIRED:
                s = "EXPIRED";
                break;
            case is.TIMEOUT:
                s = "TIMEOUT";
                break;
            case is.REFUSED:
                s = "REFUSED";
                break;
            case is.FAILED:
                s = "FAILED";
                break;
            case is.ERROR:
                s = "ERROR";
                break;
             case is.INVALID:
                s = "INVALID";
                break;
            case is.STOPPED:
                s = "STOPPED";
                break;
            case is.RUNNING:
                s = "RUNNING";
                break;
            case is.PAUSED:
                s = "PAUSED";
                break;
            case is.RESUME:
                s = "RESUME";
                break;
            
            case is.TEST:
                s = "TEST";
                break;
            case is.IGNORED:
                s = "IGNORED";
                break;
            case is.HOOK:
                s = "HOOK";
                break;
            case is.ABORTED:
                s = "ABORTED";
                break;
            case is.INFO: s =  "INFO"; break;
            case is.CREDITS: s =  "CREDITS"; break;
            case is.DEBUG: s =  "DEBUG"; break;
            case is.EXTRA: s =  "EXTRA"; break;
            case is.ROUTINE: s = "ROUTINE"; break;
            case is.WARNING: s =  "WARNING"; break;
            case is.ACCEPTED: s =  "ACCEPTED"; break;

                
           
                
            default:
                s = Integer.toString(status);
                break;
        }
        return s;
    }
        
        
}
