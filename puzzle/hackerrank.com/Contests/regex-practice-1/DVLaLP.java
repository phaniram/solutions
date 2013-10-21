import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Detecting Valid Latitude and Longitude Pairs
 * https://www.hackerrank.com/contests/regex-practice-1/challenges/detecting-valid-latitude-and-longitude
 */

public class DVLaLP {

	public static boolean txt(String tst)
	{
	    String re = "\\(([+-]?\\d*)(\\.\\d+)?(?![-+0-9\\.]), ([+-]?\\d*)(\\.\\d+)?(?![-+0-9\\.])\\)";
	    boolean ret = false;
	    Matcher m = Pattern.compile(re).matcher(tst);
	    if (m.find())
	    {
	        String lat1=m.group(1);
	        String lat2=m.group(2);
	        String lon1=m.group(3);
	        String lon2=m.group(4);
	        if(lat1.charAt(0) == '+' || lat1.charAt(0) == '-')
	        {
	        	if(lat1.charAt(1) == '0') return false;
	        }else
	        {
	        	if(lat1.charAt(0) == '0') return false;
	        }	        
	        if(lon1.charAt(0) == '+' || lon1.charAt(0) == '-')
	        {
	        	if(lon1.charAt(1) == '0') return false;
	        }else
	        {
	        	if(lon1.charAt(0) == '0') return false;
	        }
        
	        if (lat1.charAt(0) == '+') lat1 = lat1.substring(1);
	        int latInt = Integer.parseInt(lat1);
	        if (lon1.charAt(0) == '+') lon1 = lon1.substring(1);
	        int lonInt = Integer.parseInt(lon1);
	        boolean clat = false;
	        boolean clon = false;	
	        if(lat2!=null)
	        {
	        	double dbl = Double.parseDouble(lat1+lat2);
	        	clat = checkLat(dbl);
	        }
	        else
	        {
	        	clat = checkLat(latInt);
	        }
	        if(!clat) return false;
	        if(lon2!=null)
	        {
	        	double dbl = Double.parseDouble(lon1+lon2);
	        	clon = checkLon(dbl);
	        }
	        else
	        {
	        	clon = checkLon(lonInt);
	        }
	        return clat&&clon;
	    }
	    return ret;
	}
	private static boolean checkLon(double lon) {
		if(lon>=-180 && lon<=180)
		{
			return true;
		}
		return false;
	}
	private static boolean checkLat(double lat) {
		if(lat>=-90 && lat<=90)
		{
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testcases = Integer.parseInt(sc.nextLine());
		
		while(testcases-->0)
		{
			String inpLine = sc.nextLine();
			if(DVLaLP.txt(inpLine))
			{
				System.out.println("Valid");
			}else
			{
				System.out.println("Invalid");
			}
		}
	}
}
