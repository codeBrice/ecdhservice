package com.example.demo.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

/**
 * class responsible for providing the data for the creation of logs
 */
public class ManageLogs {
    private static final Logger log = LoggerFactory. getLogger(ManageLogs.class);
    /**
     * phases of the request
     */
    public static final String START = "START";
    public static final String PROCESS = "PROCESS";
    public static final String SUCCESS = "SUCCESS";
    public static final String ERROR = "ERROR";

    public static final String NOSUCCESS = "NOSUCCESS";
    /**
     * get ip from the weblogic server where it is hosted
     * @return String iphost
     */
   /* public static String obtenerManagedServer() {
        String serverName = null;
        try {
            InitialContext myCtx = new InitialContext();
            MBeanHome mbeanHome = (MBeanHome) myCtx.lookup("weblogic.management.home.localhome");
            serverName = mbeanHome.getMBeanServer().getServerName();
        } catch (Exception e) {
            try {
                throw new JspException(e);
            } catch (JspException e1) {
                log.error("JspException : ",e);
            }
        }
        return serverName;
    }*/


    /**
     * method to get the host's IP address
     * @return String iphost
     */
    public static String getIpHost(){
        InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            log.error("Exception getting the host ip || ",e);
        }
        return String.valueOf(ip);
    }

    /**
     * method to obtain the user's ip address
     * @param request HttpServletRequest
     * @return String ipAddress
     */
    public static String getIpUser(HttpServletRequest request){
        String ipAddress = "";
        try {
            ipAddress= request.getHeader("X-Forwarded-For");
            if (ipAddress== null || "".equals(ipAddress)) { ipAddress = request.getHeader("Proxy-Client-IP");}
            if (ipAddress== null || "".equals(ipAddress)) { ipAddress = request.getHeader("WL-Proxy-Client-IP");}
            if (ipAddress== null || "".equals(ipAddress)) { ipAddress = request.getHeader("HTTP_CLIENT_IP");}
            if (ipAddress== null || "".equals(ipAddress)) { ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");}
            if (ipAddress== null || "".equals(ipAddress)) { ipAddress = request.getHeader("CLIENTIP");}
            if (ipAddress== null || "".equals(ipAddress)) { ipAddress = request.getRemoteAddr();}
            if(ipAddress != null)
            {
                StringTokenizer st = new StringTokenizer(ipAddress, ",");
                if(st.hasMoreTokens())
                {
                    ipAddress = st.nextToken();
                }
            }
        } catch (Exception e) {
            log.error("Exception getting the user ip || ",e);
        }
        return ipAddress;
    }
}
