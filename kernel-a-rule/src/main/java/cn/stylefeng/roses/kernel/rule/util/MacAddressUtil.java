package cn.stylefeng.roses.kernel.rule.util;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 获取mac地址的工具类
 *
 * @author fengshuonan
 * @since 2020/11/13 12:59
 */
public class MacAddressUtil {

    /**
     * 获取mac的地址信息列表
     * <p>
     * 一台机器不一定有多个网卡，所以返回的是数组
     *
     * @author fengshuonan
     * @since 2020/11/13 13:00
     */
    public static List<String> getMacList() throws Exception {
        java.util.Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> tmpMacList = new ArrayList<>();
        while (en.hasMoreElements()) {
            NetworkInterface iface = en.nextElement();
            List<InterfaceAddress> addrs = iface.getInterfaceAddresses();
            for (InterfaceAddress addr : addrs) {
                InetAddress ip = addr.getAddress();
                NetworkInterface network = NetworkInterface.getByInetAddress(ip);
                if (network == null) {
                    continue;
                }
                byte[] mac = network.getHardwareAddress();
                if (mac == null) {
                    continue;
                }
                sb.delete(0, sb.length());
                for (int i = 0; i < mac.length; i++) {
                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                }
                tmpMacList.add(sb.toString());
            }
        }
        if (tmpMacList.size() <= 0) {
            return tmpMacList;
        }

        // 去重，同一个网卡的ipv4,ipv6得到的mac都是一样的
        return tmpMacList.stream().distinct().collect(Collectors.toList());
    }

}