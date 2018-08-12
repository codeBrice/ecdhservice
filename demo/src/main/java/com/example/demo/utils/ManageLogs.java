package com.example.demo.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

public class ManageLogs {
    /*Atributos*/
    private static final Logger log = LoggerFactory. getLogger(ManageLogs.class);
    public static final String START = "START";
    public static final String PROCESS = "PROCESS";
    public static final String SUCCESS = "SUCCESS";
    public static final String ERROR = "ERROR";

    public static final String NOSUCCESS = "NOSUCCESS";
    /**
     * metodo para optener el ManagedServer
     * @return
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
     * metodo para optener la direccion de ip del host
     * @return
     */
    public static String obtenerIpHost(){
        InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            log.error("Exception getting the host ip || ",e);
        }
        return String.valueOf(ip);
    }
    /**
     * metodo para optener la direccion de ip del usuario
     * @return
     */
    public static String obtenerIpUser(HttpServletRequest request){
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
