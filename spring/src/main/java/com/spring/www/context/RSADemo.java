package com.spring.www.context;

import com.lsy.baselib.crypto.util.CryptUtil;
import com.lsy.baselib.crypto.util.FileUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

public class RSADemo {


    public static void main(String[] args) throws IOException {

//        String filePath = "/Users/wangyongchun/Downloads/IacsReadme20201230/中信公钥证书/中信测试公钥.cer";
        String publicFilePath = "/Users/wangyongchun/Downloads/中信生产公钥.cer";
        String pubKey = getPubCer(publicFilePath);


//        String privateFilePath = "/Users/wangyongchun/Downloads/KEY189415259998650368/446910020000077.key";
//        String passwd = "t9zAiWr";
//        String priKey = getPriKey(passwd, privateFilePath);

        BufferedWriter out = new BufferedWriter(new FileWriter("cer.txt"));
        out.write(pubKey);
        out.close();
        System.out.println("文件创建成功！");

    }

    /**
     * 获取RSA加签私钥
     *
     * @param pwd         商户密码
     * @param filepathKey 中信银行提供的私钥文件路径
     * @return RSA加签私钥
     */
    public static String getPriKey(String pwd, String filepathKey) {

        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            char[] keyPassword = pwd.toCharArray();
            byte[] base64EncodedPrivateKey = FileUtil.read4file(filepathKey);
            PrivateKey signerPrivateKey = CryptUtil.decryptPrivateKey(decoder.decode(base64EncodedPrivateKey), keyPassword);
            byte[] keyBates = signerPrivateKey.getEncoded();
            return encoder.encodeToString(keyBates).replaceAll("[\r\n]", "");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取RSA验签公钥
     *
     * @param filepathCer 中信银行提供的公钥文件路径
     * @return RSA验签公钥
     */
    public static String getPubCer(String filepathCer) {
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            // 获取公钥
            byte[] base64EncodedSenderCert = FileUtil.read4file(filepathCer);
            X509Certificate signerCertificate = CryptUtil.generateX509Certificate(decoder.decode(base64EncodedSenderCert));
            PublicKey senderPubKey = signerCertificate.getPublicKey();
            byte[] keyBates = senderPubKey.getEncoded();
            return encoder.encodeToString(keyBates).replaceAll("[\r\n]", "");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * RSA验签
     *
     * @param receiveMsg 已接收的内容
     * @param sign       签名
     * @param pubKeyText 中信公钥
     * @return 签名结果
     */
    public static Boolean verifySignRSA(String receiveMsg, String sign, String pubKeyText) {
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(decoder.decode(pubKeyText));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initVerify(publicKey);
            signature.update(receiveMsg.getBytes());
            return signature.verify(decoder.decode(sign));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 所有非空字段，按照key的ASCII码排序，将value值进行拼接
     *
     * @param map 待排序的数据
     * @return 排序后拼接结果
     */
    public static String sortByASCII(Map<String, String> map) {
        List<Map.Entry<String, String>> fields = new ArrayList<>(map.entrySet());

        // 按照key的ASCII码排序
        Collections.sort(fields, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return (o1.getKey().compareTo(o2.getKey()));
            }
        });

        // 将排序后的value值进行拼接
        StringBuilder plain = new StringBuilder();
        for (Map.Entry<String, String> field : fields) {
            String value = field.getValue();
            plain.append(value);
        }

        return plain.toString();
    }
}
