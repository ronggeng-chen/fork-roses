package cn.stylefeng.roses.kernel.db.api.util;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.Clob;

/**
 * oracle数据库转化工具
 *
 * @author fengshuonan
 * @since 2021/5/19 10:33
 */
public class ClobUtil {

    /**
     * Clob类型转换成String类型
     *
     * @author fengshuonan
     * @since 2021/5/19 10:33
     */
    public static String clobToString(final Clob clob) {

        if (clob == null) {
            return null;
        }

        Reader reader = null;
        try {
            reader = clob.getCharacterStream();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (reader == null) {
            return "";
        }

        BufferedReader br = new BufferedReader(reader);


        String str = null;

        // 读取第一行
        try {
            str = br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();

        // 如果没有到达流的末尾，则继续读取下一行
        while (str != null) {
            sb.append(str);
            try {
                str = br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

}
