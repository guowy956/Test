package singleSignOn.cas.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * Created by newtouch on 2017/7/19.
 */
public class JwtHelper {
    public static Claims parseJWT(String jsonToken,String bse64Security){
        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(bse64Security)).parseClaimsJwt(jsonToken).getBody();
        return claims;
    }

    public static String createJWT(String userName,long TTLMillis,String bse64Security){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now =  new Date(nowMillis);
//        生成签名秘钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(bse64Security);
        Key signKey = new SecretKeySpec(apiKeySecretBytes,signatureAlgorithm.getJcaName());
//        添加构成JWT的参数
        JwtBuilder jwtBuilder = Jwts.builder().setHeaderParam("type","JWT").claim("username",userName).signWith(signatureAlgorithm,signKey);
//       添加token的过期时间
        if (TTLMillis >= 0) {
            long expMillis = nowMillis+TTLMillis;
            Date exp = new Date(expMillis);
            jwtBuilder.setExpiration(exp).setNotBefore(now);
        }
//        生成JWT
        return jwtBuilder.compact();
    }

}
