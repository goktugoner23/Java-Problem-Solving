import java.util.Objects;
import java.util.regex.Pattern;

/*https://leetcode.com/problems/validate-ip-address/
Given a string queryIP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.
A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0" are valid IPv4 addresses while "192.168.01.1", "192.168.1.00", and "192.168@1.1" are invalid IPv4 addresses.
A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:
1 <= xi.length <= 4
xi is a hexadecimal string which may contain digits, lowercase English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
Leading zeros are allowed in xi.
For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.

Example 1:
Input: queryIP = "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".

Example 2:
Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".

Example 3:
Input: queryIP = "256.256.256.256"
Output: "Neither"
Explanation: This is neither a IPv4 address nor a IPv6 address.*/
public class ValidateIpAddress {
    public static String validIpAddress(String queryIP){
        boolean isIpv4 = true;
        if(queryIP == null || queryIP.equals("")){
            return "Neither";
        }
        if(queryIP.charAt(0) == '.' ||queryIP.charAt(queryIP.length() - 1) == '.'){
            isIpv4 = false;
        }
        String[] ipv4 = queryIP.split("\\.");
        if (ipv4.length != 4){
            isIpv4 = false;
        }
        for(String s : ipv4){
            if(Objects.equals(s, queryIP)){ //couldn't split
                isIpv4 = false;
                break;
            }
            if(Objects.equals(s, "")){ //couldn't split
                isIpv4 = false;
                break;
            }
            if (s.matches("[a-zA-Z]+") || (s.length() > 1 && s.charAt(0) == '0')){
                isIpv4 = false;
                break;
            }
            int num;
            try {
                num = Integer.parseInt(s);
            }catch(NumberFormatException e){
                isIpv4 = false;
                break;
            }
            if(num < 0 || num > 255){
                isIpv4 = false;
                break;
            }
        }
        boolean isIpv6 = true;
        if(queryIP.charAt(0) == ':' ||queryIP.charAt(queryIP.length() - 1) == ':'){
            isIpv6 = false;
        }
        String[] ipv6 = queryIP.split(":");
        if(ipv6.length != 8){
            isIpv6 = false;
        }
        for(String s : ipv6){
            if(Objects.equals(s, queryIP)){ //couldn't split
                isIpv6 = false;
                break;
            }
            if(Objects.equals(s, "")){ //couldn't split
                isIpv6 = false;
                break;
            }
            if ((s.length() < 1 || s.length() > 4) || !s.matches("-?[0-9a-fA-F]+")) {
                isIpv6 = false;
                break;
            }
        }
        if (isIpv4){
            return "IPv4";
        }else if(isIpv6){
            return "IPv6";
        }else{
            return "Neither";
        }

        // best solution
        /*class bestSol {
            String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
            Pattern pattenIPv4 =
                    Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

            String chunkIPv6 = "([0-9a-fA-F]{1,4})";
            Pattern pattenIPv6 =
                    Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

            public String validIPAddress(String IP) {
                if (pattenIPv4.matcher(IP).matches()) return "IPv4";
                return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
            }
        }*/
    }

    public static void main(String[] args) {
        System.out.println(validIpAddress("192.0.0.1")); //ipv6
        //"2001:0db8:85a3:0:0:8A2E:0370:7334"
    }
}
